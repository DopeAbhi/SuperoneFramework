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
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.runner.RunWith;


import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
public class Signup extends Utils {

RequestSpecification requestSpecification;
RequestSpecification requestSpec;
    static String vertoken;
 static String token;
    static String imageurl;
            static int userid;

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


    //Verification URL
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


    //Verify User
    @Given("Verifying user with token")
    public void verifyingUserWithToken() throws IOException {
        System.out.println(vertoken);
        requestSpecification=given().log().all().spec(requestSpecification()).body(userpayload.verifyuserpayload(vertoken));
    }

    @When("Call {string} with Post http request")
    public void callWithPostHttpRequest(String endurl) {
        APIResources apiResources=APIResources.valueOf(endurl);
        response= requestSpecification.when().post(apiResources.getResource());
    }
    @Then("Verification of status code {int}")
    public void verificationOfStatusCode(int arg0) {
        assertEquals(response.getStatusCode(),arg0);

    }

    //Verification Check
    @Given("Verification check of {string}")
    public void verification_check_of(String Email) throws IOException {
        requestSpecification = given().spec(requestSpecification()).queryParam("email", Email);

    }
    @When("Verification check {string} with end url")
    public void verification_check_with_end_url(String endurl) {
        APIResources apiResources= APIResources.valueOf(endurl);
    response=requestSpecification.when().get(apiResources.getResource());

    }
    @Then("Verification of Status")
    public void verification_of_status() {
        String verificationresponse=response.then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js2 = Utils.rawtojson(verificationresponse);
        token = js2.getString("data.token");
        System.out.println(token);

    }

    //Set Password
    @Given("Verification of user password with {string}")
    public void verificationOfUserPasswordWith( String password) throws IOException {
        System.out.println(Signup.token);
       requestSpecification= given().header("token",Signup.token).spec(requestSpecification())
               .body(userpayload.passwordpayload(password));
    }

    @When("Setting password with patch request {string}")
    public void settingPasswordWithPatchRequest(String endurl) {
        APIResources apiResources=APIResources.valueOf(endurl);
        response=requestSpecification.when().patch(apiResources.getResource());
    }

    @Then("Checking password set successfully")
    public void checkingPasswordSetSuccessfully() {
        assertEquals(response.getStatusCode(),200);
    }

    //Verify Referral
    @Given("Verifying user {string} with {string}")
    public void verifyingUserWith(String email, String referral) throws IOException {
       requestSpecification= given().spec(requestSpecification()).header("token",Signup.token).body(userpayload.referralpayload(email, referral));
    }

    @When("Setting referral with post request {string}")
    public void settingReferralWithPostRequest(String endurl) {
        APIResources apiResource=APIResources.valueOf(endurl);
        response=requestSpecification.when().post(apiResource.getResource());


    }
    @Then("Checking referral get successfully")
    public void checkingReferralGetSuccessfully() {
        assertEquals(response.getStatusCode(), 200);
    }

    //Username
    @Given("Setting username with {string}")
    public void settingUsernameWith(String username) throws IOException {
        requestSpecification=given().spec(requestSpecification()).header("token",Signup.token).body(userpayload.usernamepayload(username));
    }

    @When("Setting username with patch request {string}")
    public void settingUsernameWithPatchRequest(String endurl) {
        APIResources apiResources=APIResources.valueOf(endurl);
        response=requestSpecification.when().patch(apiResources.getResource());
    }

    @Then("Checking username set successfully")
    public void checkingUsernameSetSuccessfully() {
        assertEquals(response.getStatusCode(),200);
    }


    // First and Last Name
    @Given("Setting first and last name with {string}")
    public void settingFirstAndLastNameWithAnd(String firstname ) throws IOException {
        requestSpecification=given().header("token",Signup.token).spec(requestSpecification()).body(userpayload.namepayload(firstname));
    }

    @When("Setting first and last name with put request {string}")
    public void settingFirstAndLastNameWithPatchRequest(String endurl) {
        APIResources apiResources=APIResources.valueOf(endurl);
        response=requestSpecification.when().put(apiResources.getResource());
    }

    @Then("Checking first and last name set successfully")
    public void checkingFirstAndLastNameSetSuccessfully() {
    assertEquals(response.getStatusCode(),200);
   String rawresponse = response.then().extract().response().asString();
        JsonPath js3 = Utils.rawtojson(rawresponse);
      imageurl=   js3.getString("data.imageUrl");
      userid=   js3.getInt("data.id");
    }


    //Avatar

    @Given("Setting avatar of the user")
    public void settingAvatarOfTheUser() throws IOException {
        System.out.println(Signup.imageurl);
        System.out.println(Signup.userid);
        requestSpecification=given()
                .spec(requestSpecification()).header("token",Signup.token).body(userpayload.avatarpayload(Signup.imageurl,Signup.userid));
    }

    @When("Setting avatar with patch request {string}")
    public void settingAvatarWithPatchRequest(String endurl) {
    APIResources apiResources=APIResources.valueOf(endurl);
    response=requestSpecification.when().post(apiResources.getResource());

    }

    @Then("Checking avatar set successfully")
    public void checkingAvatarSetSuccessfully() {
        assertEquals(response.getStatusCode(),200);
//     String avatarresp=   response.then().extract().response().asString();
//        JsonPath avatarjson = Utils.rawtojson(avatarresp);
//    String rawreferral = avatarjson.getString("data.referralCode");
//        System.out.println(rawreferral);

    }


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

