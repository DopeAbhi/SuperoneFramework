package Start;

import io.restassured.RestAssured;
import Payloads.*;
import java.util.Scanner;

import static io.restassured.RestAssured.given;

public class Login {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Parent Email Address");
        String parentemail=scanner.next();


        RestAssured.baseURI="https://quickdev3.super.one";

        //User Status Check
        given().header("Content-Type","application/json").header("Bypass-W3villa-Areyxukcyb",true).header("Device-Type","WEB")
                .body(userpayload.userstatuspayload(parentemail)).when().post("/writer/v3/user/checkAccountStatus").
                then().log().all().assertThat().statusCode(200);

        given().header("Content-Type","application/json").header("Bypass-W3villa-Areyxukcyb",true).header("Device-Type","WEB")
                .body(userpayload.intiateloginpayload(parentemail,"Test@123"))
                .when().patch("/writer/v2/user/email/initiatelogin").then().log().all().assertThat().statusCode(200);


        given().header("Content-Type","application/json").header("Bypass-W3villa-Areyxukcyb",true).header("Device-Type","WEB")
                .body(userpayload.loginpayload(parentemail,"Test@123"))
                .when().patch("/writer/user/email/login").then().log().all().assertThat().statusCode(200);

    }
}
