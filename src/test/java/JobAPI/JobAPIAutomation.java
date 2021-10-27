package JobAPI;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class JobAPIAutomation {
	{
	baseURI = "https://numpyninja-joblistapi.herokuapp.com/Jobs";
	//basePath = "/Jobs";
}
 // @Test(priority=3)
  public void get_JobAPI() {
	  given()
		//.baseUri(baseURI)
		//.basePath(basePath)
		.header("Content-Type","application/json")

	.when()
		//.param("Job Id", "7000")
		.get()
	.then()
	.statusCode(200)
	.log().all();
  }
  //@Test(priority=1)
  
  public void testPost() {
		
		//Map<String,Object> map=new HashMap<String,Object>();
		JSONObject request = new JSONObject(); 
		request.put("Job Id", 	"6002");
		request.put("Job Title", "SDET");
		request.put("Job Location", "New Jersey");
		request.put("Job Company Name", "XYZ");
		request.put("Job Type", "Full Time");
		request.put("Job Posted time", "15 minutes");
		request.put("Job Description", "Full time contract");
		
		
		//System.out.println(request.toJSONString());
		//baseURI = "https://numpyninja-joblistapi.herokuapp.com/Jobs";
//		
	given()
	//.baseUri(baseURI)
	.header("Content-Type","application/json")
	.body(request.toJSONString())
	.when()
		.post()
	.then()
	.log().all()
		.statusCode(200);
		
	}
 // @Test(priority=2)

  public void testPut() {
		
		//Map<String,Object> map=new HashMap<String,Object>();
		
		JSONObject request = new JSONObject(); 
		request.put("Job Id", 	"6002");
		request.put("Job Location", "California");
		
		//System.out.println(request.toJSONString());
		//baseURI = "https://numpyninja-joblistapi.herokuapp.com/Jobs";
//		
	given()
	//.baseUri(baseURI)
	.header("Content-Type","application/json")
	.body(request.toJSONString())
	.when()
		.put()
	.then()
	.log().all()
		.statusCode(200);
		
	}
@Test
  public void testDelete() {
		
		
		//System.out.println(request.toJSONString());
		//baseURI = "https://numpyninja-joblistapi.herokuapp.com";
		//basePath = "/Jobs";
		
//		
	given()
			.baseUri(baseURI)
			//.basePath(basePath)
			.header("Content-Type","application/json")
	
	.when()
	.param("Job Id", "6002")
		.delete()
	.then()
	.log().ifStatusCodeIsEqualTo(200);
	//.log().body()
	//.log().all();
		
		
	}

}
