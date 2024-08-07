package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void BeforeScenerio() throws IOException {
		stepDefinition m = new stepDefinition();
		if(stepDefinition.place_Id==null)
		{
		m.add_place_payload_with("John Doe", "French", "House");
		m.user_calls_with_https_request("AddPlaceAPI", "POST");
		m.verify_created_maps_to_using("Shetty", "POST");
	}
	
	}}
