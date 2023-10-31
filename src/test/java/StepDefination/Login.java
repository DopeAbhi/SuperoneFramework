package StepDefination;

import io.restassured.RestAssured;
import Payloads.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Scanner;

import static io.restassured.RestAssured.given;

public class Login {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Parent Email Address");
        String parentemail=scanner.next();


        RestAssured.baseURI="https://quickdev3.super.one";
        RequestSpecification requestSpecification=new
                RequestSpecBuilder().addHeader("Content-Type","application/json").addHeader( "Device-Type", "WEB")
                .build();

//        .addHeader("Content-Type","application/json")
//                .addHeader("Bypass-W3villa-Areyxukcyb", String.valueOf(true)).addHeader("Device-Type","WEB").build();

        //User Status Check api
        given().spec(requestSpecification).body(userpayload.userstatuspayload(parentemail))
                .when().post("/writer/v3/user/checkAccountStatus")
                .then().log().all().assertThat().statusCode(200);

        given().headers("Content-Type", "application/json", "Device-Type", "WEB")
                //spec(requestSpecification)
                .body(userpayload.intiateloginpayload(parentemail,"Test@123"))
                .when().patch("/writer/v2/user/email/initiatelogin")
                .then().log().all().assertThat().statusCode(200);


        given().spec(requestSpecification)
                .body(userpayload.loginpayload(parentemail,"Test@123"))
                .when().patch("/writer/user/email/login")
                .then().log().all().assertThat().statusCode(200);

    }
}
