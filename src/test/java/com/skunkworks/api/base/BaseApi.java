package com.skunkworks.api.base;

import com.skunkworks.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseApi {
    protected RequestSpecification requestSpec(){
        return new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base.uri")).addHeader("x-api-key",ConfigReader.getProperty("x.api.key")).
                addHeader("Content-Type","application/json").build();
    }
}
