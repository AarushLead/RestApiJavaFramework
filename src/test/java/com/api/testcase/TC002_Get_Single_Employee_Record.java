package com.api.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.api.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Employee_Record extends BaseTest {
	
	@BeforeClass
	public void getSingleEmployee() throws InterruptedException
	{   
		logger.info("********  Started TC002_Get_Single_Employee_Record  **********");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		httpRequest.request(Method.GET,"/employees/"+empID);
		
		Thread.sleep(5000);
	}
	@Test
	public void checkResponseBody() {
		String responseBody = response.getBody().asString();
		logger.info("Response Body is===>" + responseBody);
		Assert.assertTrue(responseBody.contains(empID));
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
		Assert.assertTrue(responseTime < 2000);
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
		Assert.assertEquals(contentType, "text/html; charset=UTF-88");
	}

	@Test
	public void checkContentEncoding() {
		logger.info("***********  Checking Content Encoding  ***********");

		String contentEncoding = response.header("Content-Encoding");
		logger.info("Content Encoding is===>" + contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
	}

	@Test
	public void checkContentLength() {
		logger.info("***********  Checking Content Length  ***********");

		String contentLength = response.header("Content-Length");
		logger.info("Response Time is===>" + contentLength);
		Assert.assertTrue(Integer.parseInt(contentLength) <1500);
	}

	@AfterClass
	public void tearDown() {
		logger.info("***********  Finished TC001_Get_All_Employees  ***********");
	}
}
