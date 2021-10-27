package LMS_API;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class put_LMS_API {
  @Test
  public void put_prog_cont() {
	  baseURI = "https://lms-admin-rest-service.herokuapp.com";
		basePath = "/programs";
		 
		 JSONObject request2 = new JSONObject(); 
			request2.put("programName", "SDET");
			//request2.put("programId", "427");
			request2.put("programDescription", "Full time");
			request2.put("online", 	true);
			
			
			
	given()
	  		.baseUri(baseURI).basePath(basePath)
		.auth().basic("Admin", "password")
		.header("Content-Type","application/json")
		.body(request2.toJSONString())
				
	.when()
		.put("/452")
	.then()
	.log().all()
		.statusCode(200);
	
	 
 }



public void post_prog_cont() {
	  
	JSONObject request1 = new JSONObject(); 
	request1.put("online", 	"true");
	request1.put("programDescription", "Application Support");
	request1.put("programId", "500");
	request1.put("programName", "Full time");
	
given()
.baseUri(baseURI).basePath(basePath).auth().basic("Admin", "password")
.header("Content-Type","application/json")
.body(request1.toJSONString())
.when()
.post()
.then()
.statusCode(200);
}
}