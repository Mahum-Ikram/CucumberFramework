package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;

import bsh.util.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utilities;

public class stepDefinition extends Utilities {

	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	JsonPath js;
	static String place_Id;

	TestDataBuild data = new TestDataBuild();
//	Utilities utils = new Utilities(); // Create an instance of Utilities

	
	@Given("Add Place Payload with {string}, {string}, {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		res = given().spec(requestSpecification()).body(data.AddPlacePayload(name, language, address));
	}

	@When("user calls {string} with {string} https request")
	public void user_calls_with_https_request(String resource, String method) {

		// constructor will be called with value of resource which you pass
		APIResources recourceAPI = APIResources.valueOf(resource);
		System.out.println(recourceAPI.getResource());

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("POST"))
			response = res.when().post(recourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			response = res.when().get(recourceAPI.getResource());
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void status_in_response_body_is_ok(String keyValue, String Expectedvalue) {
		assertEquals(getJsonPath(response, keyValue), Expectedvalue);
	}

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_created_maps_to_using(String expectedName, String resource) throws IOException { {

		place_Id = getJsonPath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_Id);
		user_calls_with_https_request(resource, "GET");
		String name = getJsonPath(response, "name");
		assertEquals(name, expectedName);
		}
	}
	
	@Given("DeletePlace payload")
	public void delete_place_with_payload() throws IOException {
		res = given().spec(requestSpecification()).body(data.DeletePayload(place_Id));
		//user_calls_with_https_request(resource, "POST");
	}
	
	}
