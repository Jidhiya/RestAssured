package LMS_API;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class LMS_API_automation {
	{
		  baseURI = "https://lms-admin-rest-service.herokuapp.com";
		basePath = "/programs";
				 
}
  @Test
 
	   public void post_prog_cont() {
	 	  //baseURI = "https://lms-admin-rest-service.herokuapp.com/programs";
	 		//basePath = "/programs";
	 	  
	 		JSONObject request1 = new JSONObject(); 
	 		//request1.put("online", 	"true");
	 		request1.put("programDescription", "Support Analyst");
	 		//request1.put("programId", "601");
	 		request1.put("programName", "SP1");
	 		
	Response resp_progId =  given()
	 	.auth().basic("Admin", "password")
	 	.header("Content-Type","application/json")
	 	.body(request1.toJSONString())
	 .when()
	 	.post()
	 .then().assertThat()
	 	.statusCode(200).log().all().extract().response();
	
	//String str = resp_progId.asString();
	//System.out.println(str);
	JsonPath extractId = resp_progId.jsonPath();
	int  pid = extractId.get("programId");
	System.out.println(pid);

	put_prog_cont(pid);
	
	
	
	 }

 
  public void put_prog_cont(int progId) {
	  //baseURI = "https://lms-admin-rest-service.herokuapp.com/programs";
		//basePath = "/programs";
	  
		JSONObject request1 = new JSONObject(); 
		request1.put("online", 	"true");
		request1.put("programDescription", "Application Support");
		request1.put("programId", + progId);
		request1.put("programName", "AS35");
		
  given()
	.auth().basic("Admin", "password")
	.header("Content-Type","application/json")
	.body(request1.toJSONString())
.when()
	.put("/"+progId)
.then().assertThat()
	.statusCode(200).log().all();
  
get_prog_cont(progId);
}

 
  public void get_prog_cont(int progId) {
		 
	 	 
	  given()
	  .auth().basic("Admin", "password")
	  	.header("Content-Type","application/json")
	  .when()
	 	  	.get("/"+progId)
	 .then().assertThat().statusCode(200)
	  	.contentType(ContentType.JSON)
	  	.log().all(); 
  }

}
