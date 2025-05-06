package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrganizationInfoPage {
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement orgInfoHeader;
	
	@FindBy(xpath = "//td[@class='tabSelected']/a[text()='Organizations']")
	private WebElement organizationLink;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryOption;
	
	@FindBy(id="dtlview_Type")
	private WebElement typeOption;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phone;
	
	public WebElement getPhone() {
		return phone;
	}
	public WebElement getIndustryOption() {
		return industryOption;
	}
	public WebElement getTypeOption() {
		return typeOption;
	}
	public WebElement getOrgInfoHeader()
	{
		return orgInfoHeader;
	}
	public WebElement getOrganizationLink()
	{
		return organizationLink;
	}

}
