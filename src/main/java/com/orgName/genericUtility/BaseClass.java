package com.orgName.genericUtility;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.appName.objectRepository.HomePage;
import com.appName.objectRepository.LoginPage;

/**
 * This class contains implementation of all basic configuration annotations
 * @author MOHAN GOWDA
 * It is a base Class of all the clases
 */
public class BaseClass {

	private static String username;
	private static String password;
	protected LoginPage loginPage;
	protected HomePage homePage;

	/**
	 * In this annotation we fetch the common data from the property file 
	 * create the instance for all generic utility
	 * launch browser
	 * do the browser setting (maximize, implicit wait, action class initialization, explicit wait instance initialization)
	 * create the instance for common object repository class
	 * @throws IOException 
	 */

	@BeforeClass(groups = "baseclass")
	public void beforeClass1Test(/*String browser*/) throws IOException {
		GetterandSetterForUtility.setFileUtility(new FileUtility());
		GetterandSetterForUtility.setExcelUtility(new ExcelUtility());
		GetterandSetterForUtility.setJavaUtility(new JavaUtility());
		GetterandSetterForUtility.setWebDriverUtility(new WebDriverUtility());

		ExcelUtility excelUtility = GetterandSetterForUtility.getExcelUtility();
		FileUtility fileUtility=GetterandSetterForUtility.getFileUtility();
		JavaUtility javaUtility=GetterandSetterForUtility.getJavaUtility();
		WebDriverUtility webDriverUtility= GetterandSetterForUtility.getWebDriverUtility();
		//intiallize the Excel file and Property file
		excelUtility.openExcel(IconstantPath.EXCELFILEPATH);
		fileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		//read the data from propery file
		String url = fileUtility.getDataFromPropertyFile("url");
		String timeout = fileUtility.getDataFromPropertyFile("timeout");
		username = fileUtility.getDataFromPropertyFile("userName");
		password = fileUtility.getDataFromPropertyFile("password");
		String browser = fileUtility.getDataFromPropertyFile("browser");
		GetterandSetterForUtility.setTimeout(javaUtility.stringToLong(timeout));
		GetterandSetterForUtility.setRandomNumber(javaUtility.getRandomNumber(1000));
		webDriverUtility.launchBrowser(browser);

		//navigate to the application
		webDriverUtility.navigateApp(url);
		//browser settings(maximize, implicit wait, action class initialization, explicit wait instance initialization)
		webDriverUtility.maximizeBrowser();
		webDriverUtility.waitTillPageLoad(GetterandSetterForUtility.getTimeout());
		webDriverUtility.intiallizeActions(GetterandSetterForUtility.getDriver());
		webDriverUtility.explicitlyWait(GetterandSetterForUtility.getTimeout());

		//create the instance for common object repository class
		loginPage = new LoginPage();
		homePage = new HomePage();

	}



	/**
	 * In this annotation we will do login action
	 * @throws IOException 
	 */
	@BeforeMethod(groups = "baseclass")
	public void beforeMethod1Test() {
		//open database if it is required
		loginPage.loginAction(username, password);
	}

	/**
	 * In this annotation we will do signout action
	 */

	@AfterMethod(groups = "baseclass")
	public void afterMethod1Test() {
		//signout action
		homePage.signout();
		GetterandSetterForUtility.getExcelUtility().saveExcelData(IconstantPath.EXCELFILEPATH);


	}

	/**
	 * In this annotation we will close the browser instance
	 */
	@AfterClass(groups = "baseclass")
	public void afterCass1Test() {

		GetterandSetterForUtility.getWebDriverUtility().quitBrowser();


	}

	/**
	 * In this annotation close database
	 * close excel sheet
	 * save excel data
	 */
	@AfterSuite(groups = "baseclass")
	public void aftersuite1Test() {
		//close database connection code
		GetterandSetterForUtility.getExcelUtility().closeExcel();
	}
}
