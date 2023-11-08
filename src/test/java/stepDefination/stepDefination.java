package stepDefination;


import Payloads.userpayload;
import Resources.APIResources;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.runner.RunWith;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


@RunWith(Cucumber.class)
public class stepDefination extends Utils {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
     Response response;

//    @Given("User Status Payload with Email$")
//    public void user_status_payload_with_email() throws IOException {
//       requestSpecification= given().spec(requestSpecification())
//                .body(userpayload.userstatuspayload("max600@y.com"));
//
//    }
//    @When("user calls with {string} http request")
//    public void userCallsWithHttpRequest(String resources) {
//        APIResources resourcesAPI=APIResources.valueOf(resources); //enum implementation
//        System.out.println(resourcesAPI.getResource());
//
//        response=requestSpecification.when().post(resourcesAPI.getResource());
//    }
//    @Then("the API call got success with status code$")
//    public void the_api_call_got_success_with_status_code()
//    {
//        assertEquals(response.getStatusCode(),200);
//    }
//
//
//
//    @Given("User Login with Email")
//    public void userLoginWithEmail() throws IOException {
//        requestSpecification= given().spec(requestSpecification())
//            .body(userpayload.userstatuspayload("max600@y.com"));
//
//    }
//
//    @When("Login with Patch {string} request")
//    public void loginWithPatchRequest(String resources) throws IOException {
//
//        APIResources resourcesAPI=APIResources.valueOf(resources); //enum implementation
//        System.out.println(resourcesAPI.getResource());
//        response=requestSpecification.when().patch(resourcesAPI.getResource());
//
//    }
//    @Then("the API call got success status code$")
//    public void the_api_call_got_success_status_code()
//    {
//        assertEquals(response.getStatusCode(),200);
//    }
//




//    @Given("User Status Payload with {string}")
//    public void userStatusPayloadWith(String Email) throws IOException {
//        requestSpecification = given().spec(requestSpecification())
//                .body(userpayload.userstatuspayload(Email));
//    }
//    @When("user calls {string} with Post http request")
//    public void user_calls_with_post_http_request(String endurl) {
//        APIResources apiResources=APIResources.valueOf(endurl);
//        response=requestSpecification.when().post(apiResources.getResource());
//    }
//
//
//    @Then("the API call got success with status code {int}")
//    public void theAPICallGotSuccessWithStatusCode(int arg0) {
//        assertEquals(response.getStatusCode(),arg0);
//    }
//
//
//    @Given("User verification url")
//    public void userVerificationUrl() {
//        requestSpecification=given().queryParam("password", "711b525c69e8b0edc6221518b8ff878f");
//    }
//
//
//    @When("User call {string} with Get http request")
//    public void userCallWithGetHttpRequest(String endurl) {
//        APIResources apiResources=APIResources.valueOf(endurl);
//        response= requestSpecification.when().get(apiResources.getResource());
//    }
//    @Then("the API call got success with status code ")
//    public void theAPICallGotSuccessWithStatusCode() {
//        System.out.println(response.getBody());
//        assertEquals(response.getStatusCode(),200);
//    }






//    @Given("Verification check of {string}")
//    public void verificationCheckOfUser(String Email) throws IOException {
//        requestSpecification = given().spec(requestSpecification()).queryParam("email", Email);
//    }
//
//    @When("Verification check {String} with end url")
//    public void verificationCheckWithEndUrl(String endurl) throws IOException {
//        APIResources apiResources= APIResources.valueOf(endurl);
//        response=requestSpecification.when().get(apiResources.getResource());
//    }
//
//    @Then("Verification of Status")
//    public void verificationOfStatus() {
//        String verificationresponse=response.then().log().all().assertThat().statusCode(200).extract().response().asString();
//        JsonPath js2 = Utils.rawtojson(verificationresponse);
//        String token = js2.getString("data.token");
//        System.out.println(token);
//    }







}

