package com.appName.domainName;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appName.objectRepository.CreateNewOrganizationPage;
import com.appName.objectRepository.OrganizationInformationPage;
import com.appName.objectRepository.OrganizationsPage;
import com.orgName.genericUtility.BaseClass;
import com.orgName.genericUtility.GetterandSetterForUtility;

public class TestcaseNameTest extends BaseClass{

	@Test
	public void testCaseName() {
		//read all the testdata
		String orgName=GetterandSetterForUtility.getExcelUtility().getDataFromExcel("module1", "orgName12",getClass().getSimpleName())+GetterandSetterForUtility.getRandomNumber();
	System.out.println(orgName);
		
		//create object for POM class instance
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage();
		OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage();
		OrganizationsPage organizationsPage=new OrganizationsPage();

		homePage.clickOrganizations();
		organizationsPage.clickCreateOrganizationLookUpImg();
		createNewOrganizationPage.createOrgnization(orgName);
		Assert.assertEquals(organizationInformationPage.getorganizationName(), orgName);
		//GetterandSetterForUtility.getInstance().getJavaUtility().printStatement("TC PASS");
	}

}
