package com.api.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RestApiUtil {

	public static String empName()
	{
		String name = RandomStringUtils.randomAlphabetic(3);
		return "John"+name;
	}
	public static String empSalary()
	{
		 String sal = RandomStringUtils.randomNumeric(5);
		 return sal;
	}
	public static String empAge()
	{
		String age = RandomStringUtils.randomNumeric(2);
		return age;
	}
}
