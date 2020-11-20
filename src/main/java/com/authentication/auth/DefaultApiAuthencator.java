package com.authentication.auth;

import com.authentication.apirequest.ApiRequest;
import com.authentication.storage.CredentialStorage;
import com.authentication.storage.MysqlCredentialStorage;
import com.authentication.token.AuthToken;

public class DefaultApiAuthencator implements ApiAuthenticator {

    private CredentialStorage storage;

    public DefaultApiAuthencator() {
        storage = new MysqlCredentialStorage();
    }

    public DefaultApiAuthencator(CredentialStorage storage) {
        this.storage = storage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.buildFromUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String originalUrl = apiRequest.getBaseUrl();

        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()) {
            throw new RuntimeException("Token is expired!!!");
        }
        String password = storage.getPasswordByAppId(appId);
        AuthToken serverAuthToken = AuthToken.generate(originalUrl, appId, timestamp, password);
        if (!serverAuthToken.match(clientAuthToken)) {
            throw new RuntimeException("Token verfication failed!!!");
        }
    }

}