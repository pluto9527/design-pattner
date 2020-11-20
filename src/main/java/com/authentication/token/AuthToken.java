package com.authentication.token;

import com.authentication.apirequest.ApiRequest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Map;

public class AuthToken {

    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;

    private String token;

    private long createTime;

    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this(token, createTime);
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String baseUrl, long createTime, Map<String, String> param) {
        // TODO... 创建AutoToken
        return null;
    }

    public static AuthToken generate(String baseUrl, String appId, long timestamp, String password) {
        ApiRequest apiRequest = new ApiRequest(baseUrl, appId, timestamp);
        return generate(apiRequest, password);
    }

    public static AuthToken generate(ApiRequest req, String password) {
        // srcStr format:
        // "GETcvm.api.qcloud.com/v2/index.php?"
        //        + "AppID=AKIDz8krbsJ5yKBZQpn74WFkmLPx3gnPhESA"
        //        + "&Timestamp=1465185768";
        //req.getBaseUrl()+"AppID="+req.getAppId()+"&Timestamp="+req.getTimestamp()
        String srcStr = ""; // TODO
        srcStr = "geekbang?"
                + "AppID=designpattern"
                + "&Timestamp=1465185768";
        String token = generateToken(srcStr, password);
        System.out.println("buildAuthToken: " + token);
        return new AuthToken(token, req.getTimestamp());
    }

    public static String generateToken(String value, String key) {
        return hmacSha1(value, key);
    }

    private static String hmacSha1(String value, String key) {
        try {
            // Get an hmac_sha1 key from the raw key bytes
            byte[] keyBytes = key.getBytes();
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

            // Get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(value.getBytes());

            byte[] result = Base64.getEncoder().encode(rawHmac);

            //  Covert array of Hex bytes to a String
            return new String(result, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isExpired() {
        return createTime + expiredTimeInterval < System.currentTimeMillis();
    }

    public boolean match(AuthToken authToken) {
        return this.token.equals(authToken.getToken());
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getExpiredTimeInterval() {
        return expiredTimeInterval;
    }

    public void setExpiredTimeInterval(long expiredTimeInterval) {
        this.expiredTimeInterval = expiredTimeInterval;
    }
}
