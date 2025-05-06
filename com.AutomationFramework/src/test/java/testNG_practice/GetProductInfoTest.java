package testNG_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTest {
	
	@Test(dataProvider = "getData")
	public void createContactTest(String brand,String phone)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).click();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brand,Keys.ENTER);
		
		 List<WebElement> allIphone = driver.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"));
		 
		 for(WebElement x:allIphone)
		 {
			 String data=x.getText();
			 
			 if(data.equalsIgnoreCase(phone)) {
				 
				 WebElement price = driver.findElement(By.xpath("//span[text()='"+phone+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
				 System.out.println(data);
				 System.out.println(price.getText());
			 }
				 
		 }
		 driver.quit();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[4][2];
		
		objArr[0][0] = "iphone";
		objArr[0][1] = "Apple iPhone 15 (128 GB) - Pink";
		
		objArr[1][0] = "iphone";
		objArr[1][1] = "iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Black";
		
		objArr[2][0] = "iphone";
		objArr[2][1] = "Apple iPhone 15 (128 GB) - Green";
		
		objArr[3][0] = "iphone";
		objArr[3][1] = "Apple iPhone 15 (256 GB) - Black";
		
		return objArr;
		
	}


}
