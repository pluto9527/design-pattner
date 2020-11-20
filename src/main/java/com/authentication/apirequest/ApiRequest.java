package com.authentication.apirequest;

import java.util.Map;
import java.util.TreeMap;

public class ApiRequest {

    private String baseUrl;

    private String appId;

    private String token;

    private long timestamp;

    public ApiRequest(String baseUrl, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public ApiRequest(String baseUrl, String appId, String token, long timestamp) {
        this.baseUrl = baseUrl;
        this.appId = appId;
        this.token = token;
        this.timestamp = timestamp;
    }

    public static ApiRequest buildFromUrl(String fullUrl) {
        // fullUrl：baseUrl?appId=1001&timestamp=1307788865&token=a78cdef998
        // 根据URL解析出appId, token, timestamp, baseUrl
        Map<String, String> paramMap = parse(fullUrl);
        String baseUrl = "";
        String appId = "";
        String token = "";//通过AuthToken生成
        long timestamp = 0L;
        return new ApiRequest(baseUrl, appId, token, timestamp);
    }

    private static Map<String, String> parse(String fullUrl) {
        Map<String, String> params = new TreeMap<String, String>();
        // TODO
        return params;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
