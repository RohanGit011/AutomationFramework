package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className ="dvHeaderText")
	private WebElement contactInfo;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement supportStartDate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement supportEndDate;

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getContactInfo() {
		return contactInfo;
	}
	
	

}
