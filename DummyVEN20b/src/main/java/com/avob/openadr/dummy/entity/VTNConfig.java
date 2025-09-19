package com.avob.openadr.dummy.entity;

/**
 * @author david
 * Date  2025/8/9
 */
public class VTNConfig {
    public String getVenId() {
        return venId;
    }

    public void setVenId(String venId) {
        this.venId = venId;
    }

    public String getVtnUrl() {
        return vtnUrl;
    }

    public void setVtnUrl(String vtnUrl) {
        this.vtnUrl = vtnUrl;
    }

    public String getVenName() {
        return venName;
    }

    public void setVenName(String venName) {
        this.venName = venName;
    }

    private String venId;
    private String vtnUrl;
    private String venName;
    private String preload;

    public String getPreload() {
        return preload;
    }

    public void setPreload(String preload) {
        this.preload = preload;
    }
}
