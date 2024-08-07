Feature: Validating Place API's
@AddPlace @Regression
Scenario: Verify if Place is being Successfully added using AddPlaceAPI

Given Add Place Payload with "<name>", "<language>", "<address>"
When user calls "AddPlaceAPI" with "POST" https request
Then the API call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_Id created maps to "<name>" using "getplaceAPI"

Examples: 	
		|	name       | language | address |
		|	Mahum	     | English  | Karachi |
	 #|	John Doe	 | French   | Alberta |
			

@DeletePlace @Regression
Scenario: Verify if delete functionality is working

Given DeletePlace payload
When user calls "deleteplaceAPI" with "POST" https request
Then the API call is success with status code 200
And "status" in response body is "OK"

			