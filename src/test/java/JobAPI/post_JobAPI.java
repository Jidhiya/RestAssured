
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



public class post_JobAPI {
	@Test
	public void testPost() {
		
		//Map<String,Object> map=new HashMap<String,Object>();
		JSONObject request = new JSONObject(); 
		request.put("Job Id", 	"5000");
		request.put("Job Title", "SDET");
		request.put("Job Location", "New Jersey");
		request.put("Job Company Name", "XYZ");
		request.put("Job Type", "Full Time");
		request.put("Job Posted time", "15 minutes");
		request.put("Job Description", "Full time contract");
		
		
		System.out.println(request.toJSONString());
		baseURI = "https://numpyninja-joblistapi.herokuapp.com/Jobs";
//		
	given()
	.header("Content-Type","application/json")
	.body(request.toJSONString())
	.when()
		.post()
	.then()
	.log().all()
		.statusCode(200);
		
	}

}
