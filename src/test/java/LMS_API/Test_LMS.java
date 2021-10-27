package LMS_API;

import org.testng.annotations.Test;

import org.apache.commons.codec.binary.Base64;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_LMS {
  @Test
       public void lmsAPI()
       {
        //Specify base URI
        RestAssured.baseURI="https://lms-admin-rest-service.herokuapp.com/programs";
        
        //Request object
        RequestSpecification httpRequest=RestAssured.given();
        
        String credentials= "admin:password";
        
        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
        
        String encodedCredentialsAsString = new String(encodedCredentials);
        
        httpRequest.header("Authorization","Basic "+encodedCredentialsAsString);
        
        System.out.println("Hello");
        
        //Response object
        Response response=httpRequest.request(Method.GET);
        
        //print response in console window
     
        
        //System.out.println("response" +response);
        //String responseBody=response.getBody().asString();
        String responseBody=response.getBody().asPrettyString();
        System.out.println("Response Body is:" +responseBody);
        
        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);    
       }

}