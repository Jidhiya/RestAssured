import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class E2E_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username = "Admin";
		String password = "password";
		String baseURL = "https://lms-admin-rest-service.herokuapp.com";
		
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given().auth().basic(username, password);
		
		request.header("Content-Type", "application/json");


		
		
		//Get all the programs
	  Response response = request.get("/programs");
	  Assert.assertEquals(response.getStatusCode(),200);
	  String resp_body = response.asPrettyString();
	 System.out.println(resp_body);

//	   String jsonString = response.asString();
//	    jsonString = response.asString();
//        

	
	
	  
	  //to post a new program
	}

}
