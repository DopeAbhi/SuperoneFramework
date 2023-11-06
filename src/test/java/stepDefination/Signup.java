package stepDefination;

import Payloads.userpayload;
import Resources.Utils;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import jdk.jshell.execution.Util;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
public class Signup extends Utils {

RequestSpecification requestSpecification;

//User Status
    String statusresp = given().spec(requestSpecification)
            .body(userpayload.userstatuspayload(""))
            .when().post("/writer/v3/user/checkAccountStatus")
            .then().log().all().assertThat().statusCode(200).extract().response().asString();

    //Verification URL
    String verifyresponse = given().queryParam("password", "711b525c69e8b0edc6221518b8ff878f")
            .when().get("/reader/getVerificationHistory")
            .then().statusCode(200).extract().response().asString();
    JsonPath js1 = Utils.rawtojson(verifyresponse);
    String hash = js1.getString("data[0].verificationHash");

    String vertoken = hash.substring(67, hash.length());


//Verify User
           String verify= given().spec(requestSpecification)
    .body(userpayload.verifyuserpayload(vertoken))
            .when().post("/writer/v3/user/verifyUserToken")
    .then().log().all().assertThat().statusCode(200);

    //Verification Check

    String verificationresponse = given().header("Bypass-W3villa-Areyxukcyb", true).header("device-type", "WEB").queryParam("email", Treedata[0])
            .when().get("/reader/user/checkVerificationStatus")
            .then().log().all().assertThat().statusCode(200).extract().response().asString();
    JsonPath js2 = Utils.rawtojson(verificationresponse);
    String token = js2.getString("data.token");


    RequestSpecification req = new RequestSpecBuilder().addHeader("device-type", "WEB").addHeader("token", token)
            .build(); //Common parameter in single specbuilder class


    //set password
  String pass=  given().spec(req).body(userpayload.passwordpayload(Treedata[1]))
            .when().patch("/writer/v3/user/password/set").
    then().log().all().assertThat().statusCode(200);


    //Verify Referral
  String reff=  given().spec(req).body(userpayload.referralpayload(Treedata[0],""))
            .when().post("/writer/v3/user/verifyReferral")
                                    .then().log().all().assertThat().statusCode(200);

    //Set Username
   String use= given().spec(req).body(userpayload.usernamepayload(Treedata[2]))
            .when().patch("/writer/v3/user/updateUserName").
    then().log().all().assertThat().statusCode(200);

    //Set First and Last Name
    String flresponse = given().spec(req).body(userpayload.namepayload(Treedata[3]))
            .when().put("/writer/v3/user/100706/updateUserInfo")
            .then().log().all().assertThat().statusCode(200).extract().response().asString();
    JsonPath js3 = Utils.rawtojson(flresponse);

    String imageurl = js3.getString("data.imageUrl");
    int userid = js3.getInt("data.id");




    //Avatar
    String avatarresp = given().spec(req).body(userpayload.avatarpayload(imageurl, userid))
            .when().post("/writer/user/update-avatar")
                                    .then().log().all().assertThat().statusCode(200).extract().response().asString();
    JsonPath avatarjson = Utils.rawtojson(avatarresp);
    String rawreferral = avatarjson.getString("data.referralLink");
    referralLink = rawreferral.substring((rawreferral.length()) - 10, rawreferral.length());

}

