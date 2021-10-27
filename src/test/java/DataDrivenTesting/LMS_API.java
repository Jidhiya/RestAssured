package DataDrivenTesting;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LMS_API {
	{
		baseURI = "https://lms-admin-rest-service.herokuapp.com";
		basePath = "/programs";
	}

	@Test(dataProvider = "progdata")
	public void post_programs(String progdesc, String progname) {
		
		//Creating Json object to send data along with post request
		JSONObject requestparams = new JSONObject();
		// requestparams.put("online", "true");
		requestparams.put("programDescription", progdesc);
		requestparams.put("programName", progname);
		// requestparams.put("programId", "601");

		Response resp_prog_details = given().auth().basic("Admin", "password")
				.header("Content-Type", "application/json").body(requestparams.toJSONString()).when().post().then()
				.assertThat().statusCode(200).log().all().extract().response();
		
		//Asserting the status code is success
		int statusCode = resp_prog_details.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("The response code is "+statusCode);

		String responseBody = resp_prog_details.getBody().asPrettyString();
	
		//Asserting the correct values are posted
		Assert.assertEquals(responseBody.contains(progdesc), true);
		Assert.assertEquals(responseBody.contains(progname), true);
		
		

	}

	@DataProvider(name = "progdata")
	String[][] get_prog_data() throws IOException {
		// String prog_data[][] = {{"SDET", "SDET100"},{"DS","DS100"}};
		String path = System.getProperty("user.dir") + "/src/test/java/DataDrivenTesting/ProgData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);
		String progdata[][] = new String[rownum][colnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				progdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return progdata;

	}
}
