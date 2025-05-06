package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//td[text()='Organization Name 			']/ancestor::tr[@style='height:25px']/descendant::img[@src='themes/softed/images/select.gif']")
	private WebElement selectImg;
	
	public WebElement getSelectImg() {
		return selectImg;
	}

	public WebElement getSupportStartDateField() {
		return supportStartDateField;
	}

	public WebElement getSupportEndDateField() {
		return supportEndDateField;
	}

	@FindBy(name="support_start_date")
	private WebElement supportStartDateField;
	
	@FindBy(name="support_end_date")
	private WebElement supportEndDateField;

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	
	public WebElement getsaveBtn() {
		return saveBtn;
	}
	

}
