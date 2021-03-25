package com.voctoria.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class ApiTest {

	public static void main(String[] args) {
		
    	 RestAssured.baseURI = "https://api.victoriassecret.com";
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/settings/v1/languages?activeCountry=US")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("French", response.jsonPath().getString("languageDescription[1]"));
    }
}
