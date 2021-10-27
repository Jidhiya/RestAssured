package LMS_API;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class LMS_API {
	{
	  baseURI = "https://lms-admin-rest-service.herokuapp.com";
	basePath = "/programs";
			 
	}
	 @Test
  public void get_prog_cont() {
	 
	 	 
	  given()
	  	.auth().basic("Admin", "password")
	  	.header("Content-Type","application/json")
	  .when()
	 	  	.get()
	 .then()
	  	.contentType(ContentType.JSON)
	  	.log().all().statusCode(200);
  }

 public void post_prog_cont() {
	  
			JSONObject request1 = new JSONObject(); 
			request1.put("online", 	"true");
			request1.put("programDescription", "Application Support");
			//request1.put("programId", "700");
			request1.put("programName", "Full time");
			
	given()
		.auth().basic("Admin", "password")
		.header("Content-Type","application/json")
		.body(request1.toJSONString())
	.when()
		.post()
	.then()
		.statusCode(200);
 }

 public void put_prog_cont() {
	  
		 
		 JSONObject request2 = new JSONObject(); 
			request2.put("programName", "DS");
			//request.put("programId", "333");
			//request2.put("programDescription", "Full time");
			request2.put("online", 	true);
			
			
			
	given()
		.baseUri(baseURI).basePath(basePath).auth().basic("Admin", "password")
		.header("Content-Type","application/json")
		.body(request2.toJSONString())
				
	.when()
		.put("/433")
	.then()
		.statusCode(200).log().all();
	
	 
 }


 public void del_prog_cont() {
	 given()
	 	.baseUri(baseURI).basePath(basePath).header("Content-Type","application/json")
	 .when()
	 		.delete("/432")
	 .then()
	 	.log().ifStatusCodeIsEqualTo(200);
	 
	 	
	 
 }
 }

