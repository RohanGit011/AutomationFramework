package learning_datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VTiger {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\KIIT\\OneDrive\\Desktop\\Proprties\\VTiger.properties");
		
		Properties p = new Properties();
		
		p.load(file);
		
		Random r = new Random();
		int rand=r.nextInt(100,1000);
		
		String browser=p.getProperty("browser");
		
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
		
		driver.get(p.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.name("user_name")).sendKeys(p.getProperty("username"));
		
		driver.findElement(By.name("user_password")).sendKeys(p.getProperty("password"));
		
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[contains(@href, 'index.php?module=Accounts&action=i')]/ancestor::td[@class='tabUnSelected']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		String name= p.getProperty("orgname")+rand;
		
		driver.findElement(By.xpath("//td[text()='Organization Name 			']/ancestor::tr[@style='height:25px']/descendant::input[@name='accountname']")).sendKeys(p.getProperty("orgname")+rand);
	
		driver.findElement(By.name("button")).click();
		
		 WebElement orgname = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
		 
		 System.out.println(orgname.getText());
		 
		 
	}

}
