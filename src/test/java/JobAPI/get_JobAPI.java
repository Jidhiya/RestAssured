package JobAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
//import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

public class get_JobAPI {
	
    
	
		@Test
	
	/*public void getJobList() {
			
		Response response1 = get("https://numpyninja-joblistapi.herokuapp.com/Jobs");
		System.out.println(response1.getStatusCode());
		
	}
	*/
	public void getJobListTest() {		
		baseURI = "https://numpyninja-joblistapi.herokuapp.com";
		basePath = "/Jobs";

		
		given()
			.baseUri(baseURI)
			.basePath(basePath)
			.header("Content-Type","application/json")

		.when()
			//.param("Job Id", "7000")
			.get()
		.then()
		.statusCode(200)
		.log().all();
			//.log().ifStatusCodeIsEqualTo(200);
			//.log().body()
			//.log().all(); 		

		
	}
	}


