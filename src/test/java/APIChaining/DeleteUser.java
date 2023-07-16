package APIChaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class DeleteUser {
	
	
	@Test
	void getUser(ITestContext context) {
		
		int id = (int) context.getAttribute("user_id");
		
		String bearertoken = "ef6ce82577fc5ff347e239818780f7c08517cda9fda556ac268d204537a18463";
		
		given()
			.headers("Authorization","Bearer "+bearertoken)
			.pathParam("pathid", id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{pathid}")
			
		.then()
			.statusCode(204)
			.log().all();
		
	}
}
