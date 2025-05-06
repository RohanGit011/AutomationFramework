package learning_datadriven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).click();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ihpone",Keys.ENTER);
		
		 List<WebElement> allIphone = driver.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"));
		 
		 for(WebElement x:allIphone)
		 {
			 String data=x.getText();
			 
			 if(data.equalsIgnoreCase("Apple iPhone 15 (128 GB) - Pink")) {
				 
				 WebElement price = driver.findElement(By.xpath("//span[text()='Apple iPhone 15 (128 GB) - Pink']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[text()='61,390']"));
				 System.out.println(data);
				 System.out.println(price.getText());
			 }
				 
		 }
	}

}
