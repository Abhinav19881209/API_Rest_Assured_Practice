package Day3;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class PathandQueryParam {
	
	//https://reqres.in/api/users?page=2&id=5
	
	
	@Test
	public void getRequestforPathandParam() {
		
		given()
			.pathParam("mypath", "users")
			.queryParam("page", 2)
			.queryParam("id", 8)
		
		.when()
			.get("https://reqres.in/api/{mypath}")
		.then()
			.statusCode(200)
			.log().all();
	}
}
