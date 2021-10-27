package JobAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class get_requestTest {
	@Test
  
  public void get_JobDetails() {
	  {
		  RestAssured.baseURI = "https://numpyninja-joblistapi.herokuapp.com";
		  RequestSpecification httpRequest = RestAssured.given();
		  Response response = httpRequest.get("/Jobs");
		  
				 
		  // Retrieve the body of the Response
		  ResponseBody body = response.getBody();
		  
		 
		  
		  // By using the ResponseBody.asString() method, we can convert the  body
		  // into the string representation.
		  
		  System.out.println("Response Body is: " + body.asString());
	
		 }
		 }

	}


