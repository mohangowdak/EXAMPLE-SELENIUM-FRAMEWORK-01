package com.appName.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orgName.genericUtility.GetterandSetterForUtility;

// create the class as webpage name and make it as public
public final class HomePage {
	
	// declare all the elements and specify the accesss specifier as private
	@FindBy(linkText = "More")
	private WebElement moreDropDown;
	
	@FindBy(linkText = "Products")
	private WebElement productsTab;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsTab;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsTab;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campainsTab;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admistrorIcon;
	
	@FindBy(linkText  = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText  = "Documents")
	private WebElement documentsLink;
	
	
	//intiallize the driver address to all the elements through constructors and make it as pubilc
	public HomePage() {
		PageFactory.initElements(GetterandSetterForUtility.getDriver(), this);
	}

	
	/**
	 * 
	 * @param driver
	 */
	public void clickCampaign() {
		GetterandSetterForUtility.getWebDriverUtility().mouseHoverOntheElement(moreDropDown);
		campainsTab.click();
	}
	
	
	public void clickContacts() {
		contactsTab.click();
	}
	
	public WebElement getMoreDropDown() {
		return moreDropDown;
	}
	
	public WebElement getContacts() {
		return contactsTab;
	}
	public void clickOrganizations() {
		organizationsTab.click();
	}
	
	public void clickDocument() {
		documentsLink.click();
	}
	
	public void clickProduct() {
		productsTab.click();
	}
	public void signout() {
		GetterandSetterForUtility.getWebDriverUtility().mouseHoverOntheElement(admistrorIcon);
		signOutLink.click();
	}
	
	
	
	
}
