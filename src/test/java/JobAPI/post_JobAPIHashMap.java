package JobAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.AfterClass;

public class post_JobAPIHashMap {
	 public static HashMap map = new HashMap();
	 
	  @BeforeClass
	  public void postdata() {
		  map.put("Job Id", RestUtilis.get_JobId());
		  map.put("Job Title", RestUtilis.get_JobTitle());
		  map.put("Job Location", RestUtilis.get_JobLocation());
		  map.put("Job Company Name", RestUtilis.get_JobCompName());
		  map.put("Job Type", RestUtilis.get_JobType());
		  map.put("Job Posted time", RestUtilis.get_JobPostedTime());
		  map.put("Job Description", RestUtilis.get_JobDesc());
		  
		  RestAssured.baseURI = "https://numpyninja-joblistapi.herokuapp.com";
		  RestAssured.basePath="/Jobs";
		
	  }

  @Test
  public void testPost() {
	  given()
	  	.contentType("applicaiton/json")
	  	.body(map.toString())
	  .when()
	  	.post()
	  .then()
	  	.statusCode(200);
	  
	  
  
  }


}