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
    static String token;
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
        token = loginjson.getString("data.token");
        System.out.println(token);
    }

    @Given("Getting sender wallet data")
    public void gettingSenderWalletData() throws IOException {
        System.out.println(Transfer.token);
        requestSpecification=  given().header("Token",Transfer.token).spec(requestSpecification());
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
}

