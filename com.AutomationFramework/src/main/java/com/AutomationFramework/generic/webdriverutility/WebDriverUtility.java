package com.AutomationFramework.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	
	public void waitForElementToLoad(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public void WaitForElementToPresent(WebDriver driver,int time,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchtoWindowOrTab(WebDriver driver,String title)
	{
		Set<String> allId=driver.getWindowHandles();
		
		for(String id:allId)
		{
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().equalsIgnoreCase(title))
				break;
		}
	}
	public void switchToParentWindow(WebDriver driver,String title) {
		
		Set<String> allId=driver.getWindowHandles();
		
		for(String id:allId)
		{
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().equalsIgnoreCase(title))
				break;
		}
	}
	public void selectFromDropdown(WebElement element,String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	public void selectFromDropdown(WebElement element,int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void switchAlertAndAccept(WebDriver driver)
	{
		Alert a = driver.switchTo().alert();
		
		a.accept();
	}
	public void moveMouseCursor(WebDriver driver,WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}


}
