package stepDefination;


import Payloads.userpayload;
import Resources.APIResources;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.runner.RunWith;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


@RunWith(Cucumber.class)
public class Login extends Utils {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
     Response response;


       requestSpecification= given().spec(requestSpecification())
                .body(userpayload.userstatuspayload("max600@y.com"));



        APIResources resourcesAPI=APIResources.valueOf(resources); //enum implementation
        System.out.println(resourcesAPI.getResource());

        response=requestSpecification.when().post(resourcesAPI.getResource());


        assertEquals(response.getStatusCode(),200);





        requestSpecification= given().spec(requestSpecification())
            .body(userpayload.userstatuspayload("max600@y.com"));




        APIResources resourcesAPI=APIResources.valueOf(resources); //enum implementation
        System.out.println(resourcesAPI.getResource());
        response=requestSpecification.when().patch(resourcesAPI.getResource());



        assertEquals(response.getStatusCode(),200);













}

