package com.skunkworks.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void verifyGetUser(){
        Response response = RestAssured.given().baseUri("https://reqres.in").header("x-api-key", "pub_d3ee12e8c83807eed593c8486851cbf6912ff9497353584f4ea08b73efb8ac6c").when().
                            get("/api/users/2").then().extract().response();
        System.out.println(response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        String email=response.jsonPath().getString("data.email");
        Assert.assertTrue(email.contains("@reqres.in"));
    }
    @Test
    public void verifyPostUser(){
        String requestBody="{\"first_name\": \"Chacko\",\"last_name\": \"Choco\",\"email\": \"Chacko@reqres.in\",\"password\": \"Chacko@123\"}";
        Response response=RestAssured.given().baseUri("https://reqres.in").header("x-api-key", "pub_d3ee12e8c83807eed593c8486851cbf6912ff9497353584f4ea08b73efb8ac6c").header("Content-Type","application/json").
                body(requestBody).when().post("/api/users").then().extract().response();
        System.out.println(response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 201);
        String first_name=response.jsonPath().getString("first_name");
        Assert.assertEquals(first_name,"Chacko");
    }
}
