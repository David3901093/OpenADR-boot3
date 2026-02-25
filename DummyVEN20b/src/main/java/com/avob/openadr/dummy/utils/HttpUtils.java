package com.avob.openadr.dummy.utils;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author David GE
 * Date  2026/2/12
 */
public class HttpUtils {
    /**
     * Extracts the host part from a given URL string.
     *
     * @param urlString The URL string to parse.
     * @return The host component of the URL, or null if the URL is malformed.
     */
    public static String extractHost(String urlString) throws URISyntaxException {
        if (urlString == null || urlString.isEmpty()) {
            return null;
        }
            URI uri = new URI(urlString);
            return uri.getHost();


    }

    /**
     * Extracts the path part from a given URL string.
     *
     * @param urlString The URL string to parse.
     * @return The path component of the URL, or null if the URL is malformed.
     *         For example, for "https://example.com/path/to/resource", returns "/path/to/resource".
     */
    public static String extractPath(String urlString) throws URISyntaxException {
        if (urlString == null || urlString.isEmpty()) {
            return null;
        }
            URI uri = new URI(urlString);
            return uri.getPath(); // Gets the decoded path
            // If you need the raw, encoded path (e.g., %20 for space), use uri.getRawPath()

    }


}
