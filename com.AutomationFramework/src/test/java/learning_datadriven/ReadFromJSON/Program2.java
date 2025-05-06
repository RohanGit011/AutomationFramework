package learning_datadriven.ReadFromJSON;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Program2 {
	static WebDriver driver;
	static String excelPath="C:\\Users\\KIIT\\OneDrive\\Desktop\\New folder\\sample_employee_data 1.xlsx";
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("C:\\Users\\KIIT\\OneDrive\\Desktop\\New folder\\commdata.json"));
		
		JSONObject map = (JSONObject) obj;
		
		FileInputStream file=new FileInputStream(excelPath);
		
		//create the properties class
		Properties p = new Properties();
		
		//load all the keys from property file
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
		
		String url=p.getProperty("url");
		driver.get(url);
		
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


