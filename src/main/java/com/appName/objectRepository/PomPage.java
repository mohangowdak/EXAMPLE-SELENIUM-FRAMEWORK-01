package com.appName.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orgName.genericUtility.GetterandSetterForUtility;

public class PomPage {

	@FindBy(xpath = "")
	private  WebElement elementName;
	
	

	public PomPage() {
		PageFactory.initElements(GetterandSetterForUtility.getDriver(), this);
	}
	

//business library		
	public  void methodName() {
		//common action
	}
	
	/*
	 * public void loginAction(String username, String password){
	 * 
	 * }
	 */
}
