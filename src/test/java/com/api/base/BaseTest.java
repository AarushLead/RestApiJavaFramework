package com.api.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
     
	public RequestSpecification httpRequest;
	public Response response;
	public Logger logger;
	public static String empID="51838";
	
	@BeforeClass
	public void setUp()
	{
	  String logPath=System.getProperty("user.dir")+"/src/test/resources";
	  logger=Logger.getLogger("APIExecutionLog");
	  PropertyConfigurator.configure(logPath+"/log4j.properties");    //Logger
	  logger.setLevel(Level.DEBUG);
	}
}
