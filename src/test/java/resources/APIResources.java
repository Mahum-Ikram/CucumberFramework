package resources;

//special class in java which contains collection of constants or methods
public enum APIResources {

	AddPlaceAPI("/maps/api/place/add/json"), 
	getplaceAPI("/maps/api/place/get/json"),
	deleteplaceAPI("/maps/api/place/delete/json");

	private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}
}
