package com.avob.openadr.dummy.utils;

import com.avob.openadr.client.http.OadrHttpClient;
import com.avob.openadr.client.http.OadrHttpClientBuilder;
import com.avob.openadr.client.http.oadr20b.ResponseUtils;
import com.avob.openadr.security.exception.OadrSecurityException;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author David GE
 * Date  2026/2/21
 */
public class HttpClientUtils {
    /**
     * Builds the full URL for a given base URL, session ID, and action.
     * @param baseUrl The base URL.
     * @param venId The session ID.
     * @param action The action.
     * @return The full URL.
     */

    private static String baseUrl;

    public static String getBaseUrl(){
        return baseUrl;
    }
    public static String buildFullUrl(String baseUrl, String venId, String action) {
        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder(baseUrl);
            uriBuilder.addParameter("venId", venId);
            uriBuilder.addParameter("action", action);
            return uriBuilder.toString();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid URL: " + baseUrl, e);
        }
    }

    public static String sendRequest(String dataUrl, VtnSessionConfiguration vtnSessionConfiguration, String action){
        if (dataUrl==null) {dataUrl=baseUrl;}
        String fullUrl = buildFullUrl(dataUrl, vtnSessionConfiguration.getVenId(), action);
        HttpGet request = new HttpGet(fullUrl);
        request.setHeader("Content-Type", "application/json");
        String responseBody=null;
        try {
            if (fullUrl!=null && fullUrl.contains("https")){
                OadrHttpClientBuilder builder = new OadrHttpClientBuilder().withTrustedCertificate(vtnSessionConfiguration.getTrustCertificates()).withX509Authentication(vtnSessionConfiguration.getVenPrivateKeyPath(), vtnSessionConfiguration.getVenCertificatePath()).withDefaultHost(fullUrl);
                OadrHttpClient httpClient = builder.build(true);
                HttpResponse response = httpClient.execute(request, fullUrl);
                responseBody = ResponseUtils.toString(response.getEntity());
            }else if (fullUrl!=null && fullUrl.contains("http")){
                HttpClient client = HttpClientBuilder.create().build();
                HttpResponse response = client.execute(request);
                responseBody = ResponseUtils.toString(response.getEntity());
            }
           return responseBody;
        }

        catch (JsonProcessingException | URISyntaxException | OadrSecurityException e) {
            throw  new IllegalStateException(e) ;
        }
        catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void loadUrl(String dataUrl) {
        baseUrl = dataUrl;
    }
}
