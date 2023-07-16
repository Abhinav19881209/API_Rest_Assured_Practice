package day2;

import org.json.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import java.util.*;
import java.io.*;


public class PostMethodsRequestBody {
	
	/*
	 * there are 4 way by which user can send the request body
	 * 1- by HashMap
	 * 2 - using org.json
	 * 3- POJO class
	 * 4- external JSON file
	 */
	
	//by using haspmap
//
	
//	@Test (priority =1)
	void testPostUsingHashMap() {
		
	HashMap map = new HashMap();
		
		map.put("name","Ashish");
		map.put("location", "France");
		map.put("Mob", "536492028");
		
		String[] Scourses = {"Perl","COBOL"};
		map.put("courses", Scourses);
		
		
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Ashish"))
			.body("location", equalTo("France"))
			.body("Mob", equalTo("536492028"))
		//	.body("Scourses[1]", equalTo("COBOL"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
			
	}
	
	//by using Org.json lib
//		@Test (priority =1)
		void testPostUsingOrgJsonLib() {
			
			JSONObject jdata = new JSONObject();
			jdata.put("name","Tom");
			jdata.put("location", "Spain");
			jdata.put("Mob", "0842582073");
			
			String[] Scourses = {"MOJO","Java"};
			jdata.put("courses", Scourses);

			given()
				.contentType("application/json")
				.body(jdata.toString())
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Tom"))
			.body("location", equalTo("Spain"))
			.body("Mob", equalTo("0842582073"))
			//.body("Scourses[1]", equalTo("Java"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		}

		//by using POJO class
//		@Test (priority =1)
		void testPostUsingPOJO() {
			
			POJOClass data = new POJOClass();
			
			data.setName("Gary");
			data.setLocation("Canada");
			data.setMob("09477893");
			
			String[] Scourses = {"R","Python"};
			data.setCourses(Scourses);

			given()
				.contentType("application/json")
				.body(data)
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Gary"))
			.body("location", equalTo("Canada"))
			.body("mob", equalTo("09477893"))
			//.body("Scourses[1]", equalTo("Java"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		}
	
		
		//by using external json file class	
	@Test (priority =1)
		void testPostUsingExternaljsonfile() throws FileNotFoundException {
			
		File file = new File(".\\postrequestbody.json");
		
		FileReader fr = new FileReader(file);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject ob = new JSONObject(jt);


			given()
				.contentType("application/json")
				.body(ob.toString())
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Nicky"))
			.body("location", equalTo("UK"))
			.body("Mob", equalTo("5555547483"))
			//.body("Scourses[1]", equalTo("Java"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		}	
		
//	@Test (priority =2)
	void deleteRequest() {
		
		given()
		
		.when()
				.delete("http://localhost:3000/students/5")
		.then()
			.statusCode(200);
		
	}
}
