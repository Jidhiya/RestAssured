
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



public class del_JobAPI {
	@Test
	public void testDelete() {
		
		baseURI = "https://numpyninja-joblistapi.herokuapp.com";
		basePath = "/Jobs";
	given()
	
			.header("Content-Type","application/json")
	.when()
		.param("Job Id","1035")
			.delete()
	.then()
			.log().ifStatusCodeIsEqualTo(200);
	}

}
