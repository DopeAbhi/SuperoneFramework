package stepDefination;

import Payloads.userpayload;
import Resources.APIResources;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.jshell.execution.Util;
import org.junit.runner.RunWith;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
public class Signup extends Utils {

RequestSpecification requestSpecification;
RequestSpecification requestSpec;
    String vertoken;

Response response;

//User Status
    @Given("User Status Payload with {string}")
    public void userStatusPayloadWith(String Email) throws IOException {
   requestSpecification = given().spec(requestSpecification())
            .body(userpayload.userstatuspayload(Email));
    }
    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String endurl) {
        APIResources apiResources=APIResources.valueOf(endurl);
         response= requestSpecification.when().post(apiResources.getResource());
    }


    @Then("the API call got success with status code {int}")
    public void theAPICallGotSuccessWithStatusCode(int arg0) {
        assertEquals(response.getStatusCode(),arg0);
    }


    @Given("User verification url")
    public void userVerificationUrl() throws IOException {
        requestSpecification=given().spec(requestSpecification()).queryParam("password", "711b525c69e8b0edc6221518b8ff878f");
    }


    @When("User call {string} with Get http request")
    public void userCallWithGetHttpRequest(String endurl) {

        APIResources apiResources=APIResources.valueOf(endurl);

        response= requestSpecification.when().get(apiResources.getResource());
    }
    @Then("the API call got success with status code")
    public void theAPICallGotSuccessWithStatusCode() {
   String verifyresponse= response.then().statusCode(200).extract().response().asString();
    JsonPath js1 = Utils.rawtojson(verifyresponse);
    String hash = js1.getString("data[0].verificationHash");

     vertoken = hash.substring(67, hash.length());
        System.out.println(vertoken);
    }

    @Given("Verifying user with token")
    public void verifyingUserWithToken() throws IOException {
        requestSpecification=given().spec(requestSpecification()).body(userpayload.verifyuserpayload(vertoken));
    }

    @When("Call {string} with Post http request")
    public void callWithPostHttpRequest(String endurl) {
        APIResources apiResources=APIResources.valueOf(endurl);
        response= requestSpecification.when().get(apiResources.getResource());
    }
    @Then("Verification of status code {int}")
    public void verificationOfStatusCode(int arg0) {
        assertEquals(response.getStatusCode(),arg0);

    }

//Verify User
//           String verify= given().spec(requestSpecification())
//    .body(userpayload.verifyuserpayload(vertoken))
//            .when().post("/writer/v3/user/verifyUserToken")
//    .then().log().all().assertThat().statusCode(200);

    //Verification Check

//    String verificationresponse = given().header("Bypass-W3villa-Areyxukcyb", true).header("device-type", "WEB").queryParam("email", Treedata[0])
//            .when().get("/reader/user/checkVerificationStatus")
//            .then().log().all().assertThat().statusCode(200).extract().response().asString();
//    JsonPath js2 = Utils.rawtojson(verificationresponse);
//    String token = js2.getString("data.token");
//
//
//    RequestSpecification req = new RequestSpecBuilder().addHeader("device-type", "WEB").addHeader("token", token)
//            .build(); //Common parameter in single specbuilder class
//
//
//    //set password
//  String pass=  given().spec(req).body(userpayload.passwordpayload(Treedata[1]))
//            .when().patch("/writer/v3/user/password/set").
//    then().log().all().assertThat().statusCode(200);
//
//
//    //Verify Referral
//  String reff=  given().spec(req).body(userpayload.referralpayload(Treedata[0],""))
//            .when().post("/writer/v3/user/verifyReferral")
//                                    .then().log().all().assertThat().statusCode(200);
//
//    //Set Username
//   String use= given().spec(req).body(userpayload.usernamepayload(Treedata[2]))
//            .when().patch("/writer/v3/user/updateUserName").
//    then().log().all().assertThat().statusCode(200);
//
//    //Set First and Last Name
//    String flresponse = given().spec(req).body(userpayload.namepayload(Treedata[3]))
//            .when().put("/writer/v3/user/100706/updateUserInfo")
//            .then().log().all().assertThat().statusCode(200).extract().response().asString();
//    JsonPath js3 = Utils.rawtojson(flresponse);
//
//    String imageurl = js3.getString("data.imageUrl");
//    int userid = js3.getInt("data.id");
//
//
//
//
//    //Avatar
//    String avatarresp = given().spec(req).body(userpayload.avatarpayload(imageurl, userid))
//            .when().post("/writer/user/update-avatar")
//                                    .then().log().all().assertThat().statusCode(200).extract().response().asString();
//    JsonPath avatarjson = Utils.rawtojson(avatarresp);
//    String rawreferral = avatarjson.getString("data.referralLink");
//
//
//
//    referralLink = rawreferral.substring((rawreferral.length()) - 10, rawreferral.length());

}

