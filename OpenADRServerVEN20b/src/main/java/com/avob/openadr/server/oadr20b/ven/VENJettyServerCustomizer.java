package com.avob.openadr.server.oadr20b.ven;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConfiguration.Customizer;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;

import com.avob.openadr.security.exception.OadrSecurityException;

public class VENJettyServerCustomizer implements JettyServerCustomizer {

    private final Map<String, VtnSessionConfiguration> multiConfig;
    private final String[] protocols;
    private final String[] ciphers;


    public VENJettyServerCustomizer(Map<String, VtnSessionConfiguration> multiConfig, String[] protocols,
                                    String[] ciphers) {
        this(multiConfig, protocols, ciphers, false, false);
    }

    public VENJettyServerCustomizer(Map<String, VtnSessionConfiguration> multiConfig, String[] protocols,
                                    String[] ciphers, boolean enableHttp2, boolean enableOcsp) {
        if (multiConfig == null || multiConfig.isEmpty()) {
            throw new IllegalArgumentException("VTN session configurations cannot be null or empty");
        }
        this.multiConfig = multiConfig;
        this.protocols = protocols != null ? protocols.clone() : null;
        this.ciphers = ciphers != null ? ciphers.clone() : null;

    }

    private HttpConfiguration getHttpConfiguration(VtnSessionConfiguration session) {
        HttpConfiguration config = new HttpConfiguration();
        config.setSecureScheme("https");
        config.setSecurePort(session.getPort());
        config.setSendXPoweredBy(false);
        config.setSendServerVersion(false);
        SecureRequestCustomizer secureRequestCustomizer = new SecureRequestCustomizer();
        secureRequestCustomizer.setSniHostCheck(false);
        secureRequestCustomizer.setSniRequired(false);
        config.addCustomizer(secureRequestCustomizer);
        config.addCustomizer(new Customizer() {
            @Override
            public Request customize(Request request, HttpFields.Mutable responseHeaders) {
                // Add security headers
                responseHeaders.put("X-Content-Type-Options", "nosniff");
                responseHeaders.put("X-XSS-Protection", "1; mode=block");
                responseHeaders.put("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
                return request;
            }
        });

        return config;
    }

    private SslContextFactory.Server getSslContextFactory(VtnSessionConfiguration session)
            throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException,
            OadrSecurityException, UnrecoverableKeyException, KeyManagementException {

        SslContextFactory.Server sslContextFactory = new SslContextFactory.Server();

        // Configure SSL context from session
        sslContextFactory.setSslContext(session.getSslContext());

        // Protocol configuration
        sslContextFactory.setExcludeProtocols("SSL", "SSLv2", "SSLv3", "TLSv1", "TLSv1.1");
        if (this.protocols != null && this.protocols.length > 0) {
            sslContextFactory.setIncludeProtocols(this.protocols);
        }

        // Cipher suite configuration
        sslContextFactory.setExcludeCipherSuites("^.*_(MD5|SHA|SHA1)$");
        if (this.ciphers != null && this.ciphers.length > 0) {
            sslContextFactory.setIncludeCipherSuites(this.ciphers);
        }

        // Client authentication
        sslContextFactory.setWantClientAuth(true);
        sslContextFactory.setNeedClientAuth(true);

        // Performance optimizations
        sslContextFactory.setSessionCachingEnabled(true);
        sslContextFactory.setSslSessionCacheSize(1024);
        sslContextFactory.setSslSessionTimeout(3600);

        return sslContextFactory;
    }

    @Override
    public void customize(Server server) {
        try {
            List<Connector> connectorList = new ArrayList<>();

            for (Entry<String, VtnSessionConfiguration> entry : multiConfig.entrySet()) {
                VtnSessionConfiguration session = entry.getValue();

                // Skip if port is invalid
                if (session.getPort() <= 0 || session.getPort() > 65535) {
                    continue;
                }
                HttpConfiguration config = getHttpConfiguration(session);
                HttpConnectionFactory http1 = new HttpConnectionFactory(config);
                SslConnectionFactory ssl = new SslConnectionFactory(this.getSslContextFactory(session), "http/1.1");
                ServerConnector connector = new ServerConnector(server, ssl, http1);
                connector.setPort(session.getPort());
                connectorList.add(connector);
            }

            Connector[] connectors = new Connector[connectorList.size()];
            connectors = connectorList.toArray(connectors);

            server.setConnectors(connectors);

        } catch (Exception e) {
            throw new IllegalStateException("Failed to configure Jetty server", e);
        }
    }
}