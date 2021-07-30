package apiTest;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ApiTestRestAssured {

	@Test
	public void getData() {
		String endpoint = "https://reqres.in/api/users?page=2";

		int statusCode = RestAssured.get(endpoint).statusCode();

		System.out.println("Status code is " + statusCode);

		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void postData() {
		int expectedStatusCode = 201;
		RestAssured.baseURI = "https://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "leader");

		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());

		// Post the request and check the response
		Response response = request.post("https://reqres.in/api/users");

		// validate the response
		int statusCode = response.getStatusCode();
		System.out.println("Put Status Code: " + statusCode);
		Assert.assertEquals(statusCode, expectedStatusCode);
		String successCode = response.jsonPath().get("SuccessCode");
		// Assert.assertEquals( "Correct Success code was returned", successCode,
		// "OPERATION_SUCCESS");

	}

}
