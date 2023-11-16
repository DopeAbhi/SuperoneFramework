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

    @Given("Checking user status with {string}")
    public void checkingUserStatusWith(String email) throws IOException {

        requestSpecification = given().spec(requestSpecification())
                .body(userpayload.userstatuspayload(email));
    }

    @When("user calls {string} with post request")
    public void userCallsWithPostRequest(String endurl) {

        APIResources resourcesAPI = APIResources.valueOf(endurl); //enum implementation
        System.out.println(resourcesAPI.getResource());

        response = requestSpecification.when().post(resourcesAPI.getResource());

    }
    @Then("Checking status of user status")
    public void checkingStatusOfUserStatus() {

        assertEquals(response.getStatusCode(), 200);

    }


    @Given("User Login with {string}")
    public void userLoginWith(String email) throws IOException {
        requestSpecification= given().spec(requestSpecification())
                .body(userpayload.userstatuspayload(email));

    }

    @When("Login with Patch {string} request")
    public void loginWithPatchRequest(String endurl) {
        APIResources resourcesAPI=APIResources.valueOf(endurl); //enum implementation
        System.out.println(resourcesAPI.getResource());
        response=requestSpecification.when().patch(resourcesAPI.getResource());

    }

    @Then("the API call got success status code")
    public void theAPICallGotSuccessStatusCode() {
        assertEquals(response.getStatusCode(),200);
    }


}

