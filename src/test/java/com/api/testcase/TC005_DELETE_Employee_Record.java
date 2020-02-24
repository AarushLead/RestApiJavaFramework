package com.api.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_DELETE_Employee_Record extends BaseTest{

	@BeforeClass 
	public void deleteEmployee() throws InterruptedException
	{
		logger.info("********  Started TC003_DELETE_Employee_Record  **********");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response=httpRequest.request(Method.GET, "/employees/");
		
		JsonPath json=response.jsonPath();
		String empID=json.get("[0].id");
		response=httpRequest.request(Method.DELETE, "/delete/"+empID);
		Thread.sleep(5000);
		
	}
	@Test
	public void checkResponseBody() {
		String responseBody = response.getBody().asString();
		logger.info("Response Body is===>" + responseBody);
		Assert.assertEquals(responseBody.contains("success"), true);
	}

	@Test
	public void checkStatusCode() {
		logger.info("*********** Checking Status Code  ***********");

		int statusCode = response.getStatusCode();
		logger.info("Status Code is===>" + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void checkStatusLine() {
		logger.info("***********  Checking Status Line  ***********");

		String statusLine = response.getStatusLine();
		logger.info("Status Line is===>" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

	@Test
	public void checkResponseTime() {
		logger.info("***********  Checking Response Time  ***********");

		long responseTime = response.getTime();
		logger.info("Response Time is===>" + responseTime);
		Assert.assertTrue(responseTime < 3000);
	}

	@Test
	public void checkServerType() {
		logger.info("***********  Checking Server Type  ***********");

		String serverType = response.header("Server");
		logger.info("Server Type is===>" + serverType);
		Assert.assertEquals(serverType, "nginx/1.16.0");
	}

	@Test
	public void checkContentType() {
		logger.info("***********  Checking Content Encoding  ***********");

		String contentType = response.header("Content-Type");
		logger.info("Content Type is===>" + contentType);
		Assert.assertEquals(contentType, "application/json;charset=utf-8");
	}

	@Test
	public void checkContentLength() {
		logger.info("***********  Checking Content Length  ***********");

		String contentLength = response.header("Content-Length");
		logger.info("Response Time is===>" + contentLength);
		Assert.assertTrue(Integer.parseInt(contentLength) <100);
	}

	@AfterClass
	public void tearDown() {
		logger.info("***********  Finished TC003_DELETE_Employee_Record  ***********");
	}
}
