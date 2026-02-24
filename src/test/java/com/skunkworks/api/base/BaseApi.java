package com.skunkworks.api.base;

import com.skunkworks.config.ConfigReader;
import com.skunkworks.config.SecureDataReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseApi {
    protected RequestSpecification requestSpec(){
        return new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base.uri")).addHeader("x-api-key", SecureDataReader.getXapiKey()).
                addHeader("Content-Type","application/json").build();
    }
}
