
package JobAPI;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;



public class delete_JobAPI {
	@Test
	public void testDelete() {
	
		
		//System.out.println(request.toJSONString());
		baseURI = "https://numpyninja-joblistapi.herokuapp.com/Jobs";
		//basePath = "/Jobs";
		
//		
	given()
			.baseUri(baseURI)
			//.basePath(basePath)
			.header("Content-Type","application/json")
	
	.when()
	.param("Job Id","1010")
		.delete()
	.then()
	.log().ifStatusCodeIsEqualTo(200);
	//.log().body()
	//.log().all();
		
		
	}

}
