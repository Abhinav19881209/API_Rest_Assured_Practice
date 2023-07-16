package APIChaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	@Test
	void updateUser(ITestContext context) {
		
		Faker fake = new Faker();
		JSONObject jobj = new JSONObject();
		
		jobj.put("name", fake.name().fullName());
		jobj.put("email", fake.internet().safeEmailAddress());
		jobj.put("gender", "male");
		jobj.put("status", "inactive");
		
		String bearertoken = "ef6ce82577fc5ff347e239818780f7c08517cda9fda556ac268d204537a18463";
		
		int id = (int) context.getAttribute("user_id");
		
		given()
			.headers("Authorization","Bearer "+bearertoken)
			.contentType("application/json")
			.body(jobj.toString())
			.pathParam("pathid", id)
		
		.when()
			.put("https://gorest.co.in/public/v2/users/{pathid}")
			
			
		.then()
			.statusCode(200)
			.log().all();
	
		
	}
}
