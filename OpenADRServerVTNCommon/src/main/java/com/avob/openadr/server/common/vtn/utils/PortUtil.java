package com.avob.openadr.server.common.vtn.utils;

import java.net.ServerSocket;

public class PortUtil {
    // 利用可能なポートを探す
    public static int findAvailableTcpPort() {
        try (ServerSocket socket = new ServerSocket(0)) {
            return socket.getLocalPort();
        } catch (Exception e) {
            throw new RuntimeException("Failed to find available TCP port", e);
        }
    }
}