package learning_datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropData {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		FileInputStream file =new FileInputStream("C:\\Users\\KIIT\\OneDrive\\Desktop\\CommonData.properties");
	
		Properties p = new Properties();
		
		p.load(file);
		
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("username"));
		System.out.println(p.getProperty("password"));

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
		
		driver.get(p.getProperty("url"));
		
	}

}
