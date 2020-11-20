package com.authentication.storage;

public interface CredentialStorage {

  String getPasswordByAppId(String appId);

}