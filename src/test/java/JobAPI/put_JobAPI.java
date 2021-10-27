
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



public class put_JobAPI {
	@Test
	public void testPut() {
		
		//Map<String,Object> map=new HashMap<String,Object>();
		
		JSONObject request = new JSONObject(); 
		request.put("Job Id", 	"3000");
		request.put("Job Location", "New Jersey");
		
		//System.out.println(request.toJSONString());
		baseURI = "https://numpyninja-joblistapi.herokuapp.com/Jobs";
//		
	given()
	.header("Content-Type","application/json")
	.body(request.toJSONString())
	.when()
		.put()
	.then()
	.log().all()
		.statusCode(200);
		
	}

}
