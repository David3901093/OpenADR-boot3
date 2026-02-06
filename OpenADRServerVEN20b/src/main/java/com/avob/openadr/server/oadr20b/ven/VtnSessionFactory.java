package com.avob.openadr.server.oadr20b.ven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.annotation.Resource;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.avob.openadr.model.oadr20b.Oadr20bJAXBContext;
import com.avob.openadr.model.oadr20b.exception.Oadr20bUnmarshalException;
import com.avob.openadr.model.oadr20b.oadr.OadrRegisterReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrReportType;
import com.avob.openadr.security.OadrPKISecurity;
import com.avob.openadr.security.exception.OadrSecurityException;

@Service
public class VtnSessionFactory {

    private static final String VTN_ID = "oadr.vtn.vtnid";
    private static final String VTN_ID_FILE = "oadr.vtn.vtnid.file";
    private static final String VTN_URL = "oadr.vtn.vtnUrl";

    private static final String VTN_XMPP_HOST = "oadr.vtn.xmpp.host";
    private static final String VTN_XMPP_PORT = "oadr.vtn.xmpp.port";
    private static final String VTN_XMPP_DOMAIN = "oadr.vtn.xmpp.domain";

    private static final String AUTHENTIFICATION_BASIC_USER = "oadr.vtn.security.authentication.basic.username";
    private static final String AUTHENTIFICATION_BASIC_PASS = "oadr.vtn.security.authentication.basic.password";
    private static final String AUTHENTIFICATION_DIGEST_USER = "oadr.vtn.security.authentication.digest.username";
    private static final String AUTHENTIFICATION_DIGEST_PASS = "oadr.vtn.security.authentication.digest.password";
    private static final String AUTHENTIFICATION_DIGEST_REALM = "oadr.vtn.security.authentication.digest.realm";

    private static final String AUTHENTIFICATION_XMPP_USER = "oadr.vtn.security.authentication.xmpp.username";
    private static final String AUTHENTIFICATION_XMPP_PASS = "oadr.vtn.security.authentication.xmpp.password";

    private static final String CONTEXT_PATH = "oadr.vtn.server.context_path";
    private static final String PORT = "oadr.vtn.server.port";
    private static final String VEN_ID = "oadr.vtn.venid";


    private static final String VEN_ID_FILE = "oadr.vtn.venid.file";
    private static final String VEN_NAME = "oadr.vtn.venName";
    private static final String VEN_URL = "oadr.vtn.venUrl";
    private static final String TRUST_CERTIFICATES = "oadr.vtn.security.vtn.trustcertificate";
    private static final String PRIVATE_KEY = "oadr.vtn.security.ven.key";
    private static final String CERTIFICATE = "oadr.vtn.security.ven.cert";

    private static final String PULL_FREQUENCY = "oadr.pullFrequencySeconds";
    private static final String REPORT_ONLY = "oadr.reportOnly";
    private static final String XML_SIGNATURE = "oadr.xmlSignature";
    private static final String PULL_MODEL = "oadr.pullModel";
    private static final String REPLAY_PROTECTION_DELAY = "oadr.security.replayProtectAcceptedDelaySecond";
    private static final String VEN_REGISTER_REPORT_FILE = "oadr.vtn.venRegisterReport.file";

    private static final String USE_JKS_EXTRACTION = "oadr.vtn.security.use_jks_extraction";


    @Resource
    private Oadr20bJAXBContext oadr20bJAXBContext;

    @Value("${oadr.pullFrequencySeconds:#{null}}")
    private Long defaultPullFrequencySeconds;

    @Value("${oadr.reportOnly}")
    private Boolean defaultReportOnly;

    @Value("${oadr.xmlSignature}")
    private Boolean defaultXmlSignature;

    @Value("${oadr.pullModel}")
    private Boolean defaultPullModel;

    @Value("${oadr.security.replayProtectAcceptedDelaySecond:#{null}}")
    private Long defaultReplayProtectAcceptedDelaySecond;

    private static final Logger LOGGER = LoggerFactory.getLogger(VtnSessionFactory.class);

    public VtnSessionConfiguration createVtnSession(String sessionId, Properties properties, Map<String, List<Path>> tempFilesMap) {
        VtnSessionConfiguration session = new VtnSessionConfiguration();
        session.setSessionId(sessionId);
        session.setReportOnly(defaultReportOnly);
        session.setXmlSignature(defaultXmlSignature);
        session.setPullModel(defaultPullModel);
        session.setReplayProtectAcceptedDelaySecond(defaultReplayProtectAcceptedDelaySecond);
        session.setPullFrequencySeconds(defaultPullFrequencySeconds);

        for (Map.Entry<Object, Object> e : properties.entrySet()) {
            String keyStr = (String) e.getKey();
            String prop = (String) e.getValue();
            if (VTN_ID.equals(keyStr)) {
                session.setVtnId(prop);
            } else if (VTN_ID_FILE.equals(keyStr)) {
                session.setVtnId(getIdFromFile(prop, VTN_ID_FILE));
            } else if (VTN_URL.equals(keyStr)) {
                session.setVtnUrl(prop);
            } else if (VTN_XMPP_HOST.equals(keyStr)) {
                session.setVtnXmppHost(prop);
            } else if (VTN_XMPP_PORT.equals(keyStr)) {
                session.setVtnXmppPort(Integer.parseInt(prop));
            } else if (VTN_XMPP_DOMAIN.equals(keyStr)) {
                session.setVtnXmppDomain(prop);
            } else if (AUTHENTIFICATION_BASIC_USER.equals(keyStr)) {
                session.setBasicUsername(prop);
            } else if (AUTHENTIFICATION_BASIC_PASS.equals(keyStr)) {
                session.setBasicPassword(prop);
            } else if (AUTHENTIFICATION_DIGEST_USER.equals(keyStr)) {
                session.setDigestUsername(prop);
            } else if (AUTHENTIFICATION_DIGEST_PASS.equals(keyStr)) {
                session.setDigestPassword(prop);
            } else if (AUTHENTIFICATION_DIGEST_REALM.equals(keyStr)) {
                session.setDigestRealm(prop);
            } else if (AUTHENTIFICATION_XMPP_USER.equals(keyStr)) {
                session.setVtnXmppUser(prop);
            } else if (AUTHENTIFICATION_XMPP_PASS.equals(keyStr)) {
                session.setVtnXmppPass(prop);
            } else if (CONTEXT_PATH.equals(keyStr)) {
                session.setContextPath(prop);
            } else if (PORT.equals(keyStr)) {
                session.setPort(Integer.valueOf(prop));
            } else if (VEN_ID.equals(keyStr)) {
                session.setVenId(prop);
            } else if (VEN_ID_FILE.equals(keyStr)) {
                session.setVenId(getIdFromFile(prop, VEN_ID_FILE));
            } else if (VEN_NAME.equals(keyStr)) {
                session.setVenName(prop);
            } else if (VEN_URL.equals(keyStr)) {
                session.setVenUrl(prop);
            } else if (TRUST_CERTIFICATES.equals(keyStr)) {
                session.setTrustCertificates(Arrays.asList(prop.split(",")));
            } else if (PRIVATE_KEY.equals(keyStr)) {
                session.setVenPrivateKeyPath(prop);
            } else if (CERTIFICATE.equals(keyStr)) {
                session.setVenCertificatePath(prop);
            } else if (PULL_FREQUENCY.equals(keyStr)) {
                session.setPullFrequencySeconds(Long.valueOf(prop));
            } else if (REPORT_ONLY.equals(keyStr)) {
                session.setReportOnly(Boolean.valueOf(prop));
            } else if (XML_SIGNATURE.equals(keyStr)) {
                session.setXmlSignature(Boolean.valueOf(prop));
            } else if (PULL_MODEL.equals(keyStr)) {
                session.setPullModel(Boolean.valueOf(prop));
            } else if (REPLAY_PROTECTION_DELAY.equals(keyStr)) {
                session.setReplayProtectAcceptedDelaySecond(Long.valueOf(prop));
            } else if (VEN_REGISTER_REPORT_FILE.equals(keyStr)) {
                OadrRegisterReportType registerReportFromFile = getRegisterReportFromFile(prop);
                session.setVenRegisterReport(registerReportFromFile.getOadrReport().stream()
                        .collect(Collectors.toMap((OadrReportType r) -> r.getReportSpecifierID(), r -> r)));
            } else if (USE_JKS_EXTRACTION.equals(keyStr)) {

                String jksPathKey = "oadr.vtn." + "security.keystore.path";
                String jksPasswordKey = "oadr.vtn." + "security.keystore.password";
                String jksTypeKey = "oadr.vtn." + "security.keystore.type";


                String jksPath = properties.getProperty(jksPathKey);
                String jksPassword = properties.getProperty(jksPasswordKey);
                String jksType = properties.getProperty(jksTypeKey, "JKS");

                if (jksPath == null || jksPassword == null) {
                    throw new IllegalStateException(
                            "JKS Extraction is enabled but required configuration is missing. Missing keys: " +
                                    (jksPath == null ? jksPathKey : "") +
                                    (jksPassword == null ? ", " + jksPasswordKey : ""));
                }

                try {

                    String[] extractedPaths = extractKeysFromJKS(jksPath, jksPassword, jksType, sessionId);
                    String extractedPrivateKeyPath = extractedPaths[0];
                    String extractedCertificatePath = extractedPaths[1];


                    session.setVenPrivateKeyPath(extractedPrivateKeyPath);
                    session.setVenCertificatePath(extractedCertificatePath);


                    session.setTempVenPrivateKeyPath(extractedPrivateKeyPath);
                    session.setTempVenCertificatePath(extractedCertificatePath);
                    session.setVenCertificatePath(extractedCertificatePath);
                    session.setVenPrivateKeyPath(extractedPrivateKeyPath);


                    List<Path> tempFiles = new ArrayList<>();
                    tempFiles.add(Path.of(extractedPrivateKeyPath));
                    tempFiles.add(Path.of(extractedCertificatePath));
                    tempFilesMap.put(sessionId, tempFiles);
                    TrustManagerFactory trustManagerFactory = null;
                    if (session.getTrustCertificates() != null) {
                        trustManagerFactory = OadrPKISecurity.createTrustManagerFactory(session.getTrustCertificates());
                    } else {
                        String truststorePathKey = "oadr.vtn.security.truststore.path";
                        String truststorePasswordKey = "oadr.vtn.security.truststore.password";

                        String truststorePath = properties.getProperty(truststorePathKey);
                        String truststorePassword = properties.getProperty(truststorePasswordKey);

                        if (truststorePath == null || truststorePassword == null) {
                            throw new IllegalStateException(
                                    "Truststore configuration is missing. Required keys: " +
                                            (truststorePath == null ? truststorePathKey : "") +
                                            (truststorePassword == null ? ", " + truststorePasswordKey : ""));
                        }
                        List<String> certificates = extractTrustCertificatesFromJKS(truststorePath, truststorePassword);
                        session.setTrustCertificates(certificates);

                        try {

                            KeyStore trustStore = KeyStore.getInstance("JKS");
                            try (FileInputStream fis = new FileInputStream(truststorePath)) {
                                trustStore.load(fis, truststorePassword.toCharArray());
                            }
                            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                            trustManagerFactory.init(trustStore);
                        } catch (Exception ex) {
                            throw new IllegalStateException("Failed to load truststore: " + truststorePath, ex);
                        }
                    }

                    KeyManagerFactory keyManagerFactory = OadrPKISecurity.createKeyManagerFactory(
                            extractedPrivateKeyPath, extractedCertificatePath, UUID.randomUUID().toString());

                    SSLContext sslContext = SSLContext.getInstance("TLS");
                    String seed = UUID.randomUUID().toString();
                    sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(),
                            new SecureRandom(seed.getBytes()));

                    session.setSslContext(sslContext);


                    LOGGER.info("JKS Extraction successful for VTN '{}'. SSLContext initialized with PEM files: {} and {}",
                            sessionId, extractedPrivateKeyPath, extractedCertificatePath);

                } catch (OadrSecurityException | NoSuchAlgorithmException | KeyManagementException ex) {
                    throw new IllegalStateException("Failed to initialize SSLContext for VTN: " + sessionId, ex);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }


        }

        String password = UUID.randomUUID().toString();
        TrustManagerFactory trustManagerFactory;
        try {
            trustManagerFactory = OadrPKISecurity.createTrustManagerFactory(session.getTrustCertificates());
            KeyManagerFactory keyManagerFactory = OadrPKISecurity
                    .createKeyManagerFactory(session.getVenPrivateKeyPath(), session.getVenCertificatePath(), password);

            // SSL Context Factory
            SSLContext sslContext = SSLContext.getInstance("TLS");

            // init ssl context
            String seed = UUID.randomUUID().toString();
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(),
                    new SecureRandom(seed.getBytes()));

            session.setSslContext(sslContext);

        } catch (OadrSecurityException | NoSuchAlgorithmException | KeyManagementException e) {
            throw new IllegalStateException(e);
        }

        return session;

    }

    /**
     * Extracts private key and certificate from a JKS file and saves them as temporary PEM files.
     *
     * @param jksPath     The path to the JKS file.
     * @param jksPassword The password for the JKS file.
     * @param jksType     The type of the keystore (e.g., JKS, PKCS12). Defaults to JKS.
     * @param vtnId       The ID of the VTN, used for naming temporary files.
     * @return An array containing the paths to the temporary private key file and certificate file.
     * @throws Exception If an error occurs during extraction.
     */
    private String[] extractKeysFromJKS(String jksPath, String jksPassword, String jksType, String vtnId) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(jksType != null ? jksType : "JKS");
        try (FileInputStream fis = new FileInputStream(jksPath)) {
            keyStore.load(fis, jksPassword.toCharArray());
        }

        // Find the first private key entry alias
        String alias = null;
        Enumeration<String> aliasesEnum = keyStore.aliases();
        while (aliasesEnum.hasMoreElements()) {
            String a = aliasesEnum.nextElement();
            if (keyStore.isKeyEntry(a) && keyStore.getKey(a, jksPassword.toCharArray()) instanceof PrivateKey) {
                alias = a;
                break;
            }
        }

        if (alias == null) {
            throw new IllegalStateException("No PrivateKey entry found in the KeyStore: " + jksPath);
        }

        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, jksPassword.toCharArray());
        Certificate[] certChain = keyStore.getCertificateChain(alias);

        if (privateKey == null || certChain == null || certChain.length == 0) {
            throw new IllegalStateException("Could not retrieve PrivateKey or Certificate Chain for alias: " + alias);
        }

        X509Certificate certificate = (X509Certificate) certChain[0]; // Use the first certificate in the chain

        // Create temporary files for the private key and certificate
        Path tempPrivateKeyFile = Files.createTempFile("temp_ven_key_" + vtnId + "_", ".key");
        Path tempCertificateFile = Files.createTempFile("temp_ven_cert_" + vtnId + "_", ".crt");

        // Write private key to temporary file in PEM format
        String encodedKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        try (PrintWriter writer = new PrintWriter(tempPrivateKeyFile.toFile())) {
            writer.println("-----BEGIN PRIVATE KEY-----");
            // Split the base64 string into 64-character lines
            for (int i = 0; i < encodedKey.length(); i += 64) {
                writer.println(encodedKey.substring(i, Math.min(i + 64, encodedKey.length())));
            }
            writer.println("-----END PRIVATE KEY-----");
        }

        // Write certificate to temporary file in PEM format
        String encodedCert = Base64.getEncoder().encodeToString(certificate.getEncoded());
        try (PrintWriter writer = new PrintWriter(tempCertificateFile.toFile())) {
            writer.println("-----BEGIN CERTIFICATE-----");
            // Split the base64 string into 64-character lines
            for (int i = 0; i < encodedCert.length(); i += 64) {
                writer.println(encodedCert.substring(i, Math.min(i + 64, encodedCert.length())));
            }
            writer.println("-----END CERTIFICATE-----");
        }

        return new String[]{tempPrivateKeyFile.toString(), tempCertificateFile.toString()};
    }

    private String getIdFromFile(String filePath, String property) {
        // set vtnId by reading vtnIdFile path first line
        Path path = Paths.get(filePath);
        File file = path.toFile();
        if (! file.exists()) {
            throw new IllegalArgumentException(
                    String.format("%s must be a valid file path containing venId as it's first line", property));
        }
        try (Stream<String> lines = Files.lines(path);) {
            Optional<String> findFirst = lines.findFirst();
            if (! findFirst.isPresent()) {
                throw new IllegalArgumentException(
                        String.format("%s must be a valid file path containing venId as it's first line", property));

            }
            return findFirst.get().trim();

        } catch (IOException e) {
            throw new IllegalArgumentException(
                    String.format("%s must be a valid file path containing venId as it's first line", property), e);

        }
    }
    /**
     * Extracts the trust certificates from a JKS file and saves them as temporary PEM files.
     *
     * @param truststorePath     The path to the JKS file containing the trust certificates.
     * @param truststorePassword The password for the JKS file.
     * @return A list of paths to the temporary PEM files containing the trust certificates.
     * @throws Exception If an error occurs during extraction.
     */
    private List<String> extractTrustCertificatesFromJKS(String truststorePath, String truststorePassword) throws Exception {
        List<String> certificatePaths = new ArrayList<>();

        // 加载 truststore
        KeyStore trustStore = KeyStore.getInstance("JKS");
        try (FileInputStream fis = new FileInputStream(truststorePath)) {
            trustStore.load(fis, truststorePassword.toCharArray());
        }

        // 遍历所有别名
        Enumeration<String> aliases = trustStore.aliases();
        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();

            // 检查是否为证书条目
            if (trustStore.isCertificateEntry(alias)) {
                Certificate cert = trustStore.getCertificate(alias);
                if (cert instanceof X509Certificate) {
                    X509Certificate x509Cert = (X509Certificate) cert;

                    // 创建临时文件存储证书
                    Path tempCertFile = Files.createTempFile("trust_cert_" + alias + "_", ".crt");

                    // 写入 PEM 格式的证书内容
                    String encodedCert = Base64.getEncoder().encodeToString(x509Cert.getEncoded());
                    try (PrintWriter writer = new PrintWriter(tempCertFile.toFile())) {
                        writer.println("-----BEGIN CERTIFICATE-----");
                        for (int i = 0; i < encodedCert.length(); i += 64) {
                            writer.println(encodedCert.substring(i, Math.min(i + 64, encodedCert.length())));
                        }
                        writer.println("-----END CERTIFICATE-----");
                    }

                    // 添加文件路径到列表
                    certificatePaths.add(tempCertFile.toString());
                }
            }
        }

        return certificatePaths;
    }

    private OadrRegisterReportType getRegisterReportFromFile(String filePath) {
        Path path = Paths.get(filePath);
        File file = path.toFile();
        if (! file.exists()) {
            throw new IllegalArgumentException(
                    "oadr.vtn.venRegisterReport.file must be a valid file path containing XML formatted OadrRegisterReportType");
        }

        try {
            return oadr20bJAXBContext.unmarshal(file, OadrRegisterReportType.class);
        } catch (Oadr20bUnmarshalException e) {
            throw new IllegalArgumentException(
                    "oadr.vtn.venRegisterReport.file must be a valid file path containing XML formatted OadrRegisterReportType",
                    e);
        }

    }

}
