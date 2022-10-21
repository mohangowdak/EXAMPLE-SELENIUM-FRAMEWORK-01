package com.orgName.genericUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class GetterandSetterForUtility {

	private static ThreadLocal<ExtentTest> testTL=new ThreadLocal<>();
	private static ThreadLocal<WebDriver> driverTL=new ThreadLocal<>();
	private static ThreadLocal<FileUtility> fileUtilityTL=new ThreadLocal<>();
	private static ThreadLocal<ExcelUtility> excelUtilityTL=new ThreadLocal<>();
	private static ThreadLocal<JavaUtility> javaUtilityTL=new ThreadLocal<>();
	private static ThreadLocal<WebDriverUtility> webDriverUtilityTL=new ThreadLocal<>();
	private static ThreadLocal<Integer> randomNumberTL=new ThreadLocal<>();
	private static ThreadLocal<Long> timeoutTL=new ThreadLocal<>();


	public static ExtentTest getTest() {
		return testTL.get();
	}
	public static WebDriver getDriver() {
		return driverTL.get();
	}

	public static FileUtility getFileUtility() {
		return fileUtilityTL.get();
	}
	public static ExcelUtility getExcelUtility() {
		return excelUtilityTL.get();
	}
	public static JavaUtility getJavaUtility() {
		return javaUtilityTL.get();
	}
	public static WebDriverUtility getWebDriverUtility() {
		return webDriverUtilityTL.get();
	}
	public static int getRandomNumber() {
		return randomNumberTL.get();
	}
	public static long getTimeout() {
		return timeoutTL.get();
	}

	public static void setDriver(WebDriver driver) {
		driverTL.set(driver);
	}
	public static void setFileUtility(FileUtility fileUtility) {
		fileUtilityTL.set(fileUtility);
	}
	public static void setExcelUtility(ExcelUtility excelUtility) {
		excelUtilityTL.set(excelUtility);
	}
	public static void setJavaUtility(JavaUtility javaUtility) {
		javaUtilityTL.set(javaUtility);
	}
	public static void setWebDriverUtility(WebDriverUtility webDriverUtility) {
		webDriverUtilityTL.set(webDriverUtility);
	}


	public static void setTest(ExtentTest test) {
		testTL.set(test);
	}

	public static void setRandomNumber(int randomNumber) {
		randomNumberTL.set(randomNumber);
	}

	public static void setTimeout(long timeout) {
		timeoutTL.set(timeout);
	}
}
