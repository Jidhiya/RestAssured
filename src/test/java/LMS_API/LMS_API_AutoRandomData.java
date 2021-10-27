package LMS_API;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LMS_API_AutoRandomData {
	public static HashMap map = new HashMap();
	
	@BeforeTest
	public void postdata() {
		map.put("programName", LMS_Utils.getProgramName() );
		map.put("programDescription", LMS_Utils.getProgramDesc());
		
		RestAssured.baseURI = "https://lms-admin-rest-service.herokuapp.com";
		RestAssured.basePath = "/programs";
	}
  @Test
  public void testpost() {
	  given()
	 	.auth().basic("Admin", "password")
	 	.header("Content-Type","application/json")
	 	.body(map)
	 .when()
	 	.post()
	 .then()
	 	.statusCode(200).log().all();
	 	
  }
}
