package Day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.module.jsv.JsonSchemaValidator;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SchemaValidator {
	
	@Test
	void schemaValidationJSON() {
		
		given()	
			.contentType("ContentType.JSON")
		.when()
			.get("https://reqres.in/api/unknown")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidation.json"));
		
	}
}
