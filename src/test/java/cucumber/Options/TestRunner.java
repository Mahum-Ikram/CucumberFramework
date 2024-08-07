package cucumber.Options;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", plugin = "json:target/jsonReports/cucumber-report.json", glue = {
		"stepDefinitions" })

public class TestRunner {

}
