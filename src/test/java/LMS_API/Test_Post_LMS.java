package LMS_API;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_Post_LMS {
  @Test
  public void f()
  {
  //Specify base URI
      RestAssured.baseURI="https://lms-admin-rest-service.herokuapp.com/programs";
      
      //Request object
      RequestSpecification httpRequest=RestAssured.given();
      
      String credentials= "admin:password";
      
      byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
      
      String encodedCredentialsAsString = new String(encodedCredentials);
      
      httpRequest.header("Authorization","Basic "+encodedCredentialsAsString);
              
      //Request payload sending along with post request
    JSONObject requestParams=new JSONObject();
    
    requestParams.put("online",true);
    requestParams.put("programDescription","Java 10 Training");
    requestParams.put("programId",635);
    requestParams.put("programName","Java 10 Training");
        
    httpRequest.header("Content-Type","application/json");
    
    httpRequest.body(requestParams.toJSONString()); // attach above data to the request
    
      //Response object
    Response response=httpRequest.body(requestParams).put("641");
      
      //print response in console window
      
      String responseBody=response.getBody().asPrettyString();
      System.out.println("Response Body is:" +responseBody);
      
      //status code validation
      int statusCode=response.getStatusCode();
      System.out.println("Status code is: "+statusCode);
      Assert.assertEquals(statusCode, 200);   
  }
}