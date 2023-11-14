package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import  Resources.*;
import Payloads.*;

import java.io.IOException;

public class Transfer extends Utils {

    RequestSpecification requestSpecification;
    Response response;
    static String sendertoken;
    static String receivertoken;
    static String receiver_referralcode;
    static String memberid;

    // Sender Login
    @Given("Sender credentials {string} and {string}")
    public void senderCredentialsAnd(String Email, String Password) throws IOException {
      requestSpecification=  given().spec(requestSpecification()).body(userpayload.loginpayload(Email, Password));
    }

    @When("Sender login with patch request {string}")
    public void senderLoginWithPatchRequest(String endurl) {
        APIResources apiResources=APIResources.valueOf(endurl);
         response=requestSpecification.when().patch(apiResources.getResource());

    }

    @Then("Checking user login status and extracting token")
    public void checkingUserLoginStatusAndExtractingToken() {
       String loginresponse= response.then().extract().response().asString();
        JsonPath loginjson = Utils.rawtojson(loginresponse);
        sendertoken = loginjson.getString("data.token");
        System.out.println(sendertoken);
    }

    //Sender Wallet Data
    @Given("Getting sender wallet data")
    public void gettingSenderWalletData() throws IOException {
        System.out.println(Transfer.sendertoken);
        requestSpecification=  given().header("Token",Transfer.sendertoken).spec(requestSpecification());
    }

    @When("Sender wallet data with get request {string}")
    public void senderWalletDataWithGetRequest(String endurl) {

        APIResources apiResources=APIResources.valueOf(endurl);
        response=requestSpecification.when().get(apiResources.getResource());
    }

    @Then("Checking sender wallet data status")
    public void checkingSenderWalletDataStatus() {
        String walletresponse= response.then().extract().response().asString();
        JsonPath walletjson = Utils.rawtojson(walletresponse);
        String freebalance = walletjson.getString("data.Balance.freeBalance");
        System.out.println(freebalance);

    }

//Receiver Login
    @Given("Receiver credentials {string} and {string}")
    public void receiverCredentialsAnd(String Email, String Password) throws IOException {
        requestSpecification=  given().spec(requestSpecification()).body(userpayload.loginpayload(Email, Password));
    }

    @When("Receiver login with patch request {string}")
    public void receiverLoginWithPatchRequest(String endurl) {
        APIResources apiResources=APIResources.valueOf(endurl);
        response=requestSpecification.when().patch(apiResources.getResource());
    }

    @Then("Checking user login status and extracting token & referral")
    public void checkingUserLoginStatusAndExtractingTokenReferral() {
        String receiverloginresponse= response.then().extract().response().asString();
        JsonPath receiverloginjson = Utils.rawtojson(receiverloginresponse);
        receivertoken = receiverloginjson.getString("data.token");
         receiver_referralcode= receiverloginjson.getString("data.referralCode");
        System.out.println(receiver_referralcode);
        System.out.println(receivertoken);

    }

    //Seraching of User
    @Given("Searching user for transfer")
    public void searchingUserForTransfer() throws IOException {
        requestSpecification=  given().header("Token",Transfer.sendertoken)
                .spec(requestSpecification()).body(Transferpayload.searchpayload(Transfer.receiver_referralcode));
    }

    @When("Searching user for transfer with post request {string}")
    public void searchingUserForTransferWithPostRequest(String endurl) {
        APIResources apiResources=APIResources.valueOf(endurl);
        response=requestSpecification.when().post(apiResources.getResource());
    }

    @Then("Checking user search status and extracting member id")
    public void checkingUserSearchStatusAndExtractingMemberId() {

  String searchresponse=  response.then().extract().response().asString();
    JsonPath searchjson=Utils.rawtojson(searchresponse);
    memberid=searchjson.getString("data.members[0].id");

    }
}

