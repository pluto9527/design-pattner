package com.authentication.auth;

import com.authentication.apirequest.ApiRequest;

public interface ApiAuthenticator {

    void auth(String url);

    void auth(ApiRequest apiRequest);

}