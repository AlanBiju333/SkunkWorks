package com.skunkworks.api.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseApi {
    protected RequestSpecification requestSpec(){
        return new RequestSpecBuilder().setBaseUri("https://reqres.in").addHeader("x-api-key","pub_d3ee12e8c83807eed593c8486851cbf6912ff9497353584f4ea08b73efb8ac6c").
                addHeader("Content-Type","application/json").build();
    }
}
