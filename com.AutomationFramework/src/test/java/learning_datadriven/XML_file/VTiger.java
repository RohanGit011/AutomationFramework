package learning_datadriven.XML_file;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class VTiger {
	static WebDriver driver;
	
	@Test
	public void sampleTest(XmlTest test) {
		String browser=test.getParameter("browser");
		String url=test.getParameter("url");
		String username=test.getParameter("username");
		String password=test.getParameter("password");
		String name="QAQA";
		
		Random r = new Random();
		int rand=r.nextInt(100,1000);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver(); 
		}
		else
			driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		
		driver.findElement(By.name("user_password")).sendKeys(password);
		
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[contains(@href, 'index.php?module=Accounts&action=i')]/ancestor::td[@class='tabUnSelected']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//td[text()='Organization Name 			']/ancestor::tr[@style='height:25px']/descendant::input[@name='accountname']")).sendKeys(name+rand);
	
		driver.findElement(By.name("button")).click();
		
		 WebElement orgname = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
		 
		 System.out.println(orgname.getText());
		 
		 
	}

}
