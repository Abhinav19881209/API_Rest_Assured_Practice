package API_RA;
import java.util.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class Httprequest {
	
	int id;
	
	@Test (priority=2)
	void getRequest() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.statusCode(200)
			.assertThat()
			.body("page",equalTo(2))
			.log().all();
	}
	
	@Test (priority=2)
	void createUser() {
		
		Map<String,String> mpdata = new HashMap<String,String>();
		mpdata.put("name", "Rajesh");
		mpdata.put("job", "PM");
		
		id =given()
			.contentType("application/json")
			.body(mpdata)
			
		.when()
			.post("https://reqres.in/api/users")
			//Use when user need to capture response (here ID) from response
			.jsonPath().getInt("id");

		//*****use when user need to run only POST method
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	
	/*
	 * {
    "name": "Rajesh",
    "job": "PM",
    "id": "117",
    "createdAt": "2023-06-25T05:43:09.791Z"
}
	 */
	
	@Test (priority=3)
	void updateUser() {
		
		Map<String,String> mpdata = new HashMap<String,String>();
		mpdata.put("name", "Rajesh");
		mpdata.put("job", "teacher");
		
		given()
			.contentType("application/json")
			.body(mpdata)
			
		.when()
			.put("https://reqres.in/api/users/"+id)

		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test (priority=4)
	void deleteUser() {
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(204)
			.log().all();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
