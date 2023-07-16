package day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import java.util.*;
import java.io.*;

public class Authentication {
	
//	types of authenticationn
//	1- basic
//	2- digest
//	3- preemptive 
//	4 - Bearer Token
//	5 - oauth 1.0 ,2.0
//	6 - API key
	
	
	//@Test
	void testBasicAuthentication() {
		
		given()
			.auth().basic("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log();
	}
	
	//oauth 2 authentication
	@Test
	void testOAUTHAuthentication() {
		
		given()
			.auth().basic("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log();
	}
	
	
}
