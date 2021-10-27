package LMS_API;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class httpMethods_LMS {
	{
	baseURI = "https://lms-admin-rest-service.herokuapp.com";
	basePath = "/programs";
}
	// @Test
	public void post_prog_cont() {
	
		JSONObject request1 = new JSONObject();
		request1.put("online", "true");
		request1.put("programDescription", "SDET100");
		// request1.put("programId", "500");
		request1.put("programName", "SDET100");

		given() 
			.auth().basic("Admin", "password")
			.header("Content-Type", "application/json")
			.body(request1.toJSONString())
		.when()	
			.post()
		.then().assertThat()
			.statusCode(200).log().all();
	}

//@Test
	public void put_prog_cont() {


		JSONObject request1 = new JSONObject();
		request1.put("online", "true");
		request1.put("programDescription", "Application Support122");
		request1.put("programId", "473");
		request1.put("programName", "AS111");

		given()
			.auth().basic("Admin", "password")
			.header("Content-Type", "application/json")
			.body(request1.toJSONString())
		.when()
			.put("/473")
		.then().assertThat()
			.statusCode(200).log().all();
	}
//@Test


	public void get_prog_cont() {

		given()
			.auth().basic("Admin", "password")
			.header("Content-Type", "application/json")
		.when()
			.get()
		.then().assertThat().statusCode(200)
			.contentType(ContentType.JSON).log().all();
	}

@Test
public void del_prog_cont() {

	 given()
	 	.baseUri(baseURI).basePath(basePath).header("Content-Type","application/json")
	 .when()
	 	.delete("/473")
	 .then()
	 	.log().ifStatusCodeIsEqualTo(200);
	 
	 	
}
}