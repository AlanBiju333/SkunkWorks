package com.skunkworks.api.tests;

import com.skunkworks.api.base.BaseApi;
import com.skunkworks.api.pojo.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewApiTest extends BaseApi {
    @Test
    public void getTest(){
        Response response = RestAssured.given().spec(requestSpec()).when().get("/api/users/2").then().
                extract().response();
        System.out.println(response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        String name= response.jsonPath().getString("data.first_name");
        Assert.assertEquals(name,"Janet");
    }
    @Test
    public void postTest(){
        User user = new User("Tintu@reqres.in","Tintu@123","Tintu","Mon");
       Response response=RestAssured.given().spec(requestSpec()).body(user).when().post("/api/users").
               then().extract().response();
       System.out.println(response.getBody().asPrettyString());
       Assert.assertEquals(response.getStatusCode(), 201);
       String email=response.jsonPath().getString("email");
       Assert.assertTrue(email.contains("Tintu@reqres"));
    }
}
