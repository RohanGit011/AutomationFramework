package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Create a separate java class
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Object creation
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Object initialization
	    //done is the script
	
	//Object encapsulation
	public WebElement getUsernameEdt()
	{
		return usernameEdt;
	}
	public WebElement getPasswordEdt()
	{
		return passwordEdt;
	}
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	
	//Provide Actions(Another way is business method)
	public void loginToApp(String url , String username,String password)
	{
		//driver.manage().window().maximize(); (in order to use driver object we need to declare the driver object globally and initialize that in constructor)
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

}
