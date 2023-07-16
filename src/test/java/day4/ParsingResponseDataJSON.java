package day4;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.json.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class ParsingResponseDataJSON {
	
	
	//@Test(priority=1)
	void parsingJSONResponse() {
		
	
		given()	.contentType("ContentType.JSON")
		.when()
			.get("https://reqres.in/api/unknown")
		.then()
			.statusCode(200)
			.body("data[1].name", equalTo("fuchsia rose"))
			.log().headers();
		
	}
	
//	@Test(priority=1)
	void parsingJSONResponsewithVariable() {
		
	
		Response res = given()	
			.contentType("ContentType.JSON")
		.when()
			.get("https://reqres.in/api/unknown");
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.getContentType(), "application/json; charset=utf-8");
		String bookname =res.jsonPath().get("data[1].name").toString();
		Assert.assertEquals(bookname, "fuchsia rose");

		
	}
	
	@Test(priority=1)
	void validatingJSONBody() {
			
		Response res = given()	
			.contentType(ContentType.JSON)
		.when()
			.get("https://reqres.in/api/unknown");
		
		JSONObject jo = new JSONObject(res.asString());
		
		for(int i =0;i< jo.getJSONArray("data").length();i++) {
			
			String bookname = jo.getJSONArray("data").getJSONObject(i).get("name").toString();
			
			System.out.println(bookname);
		}
		
		

		
	}
	
	
}
