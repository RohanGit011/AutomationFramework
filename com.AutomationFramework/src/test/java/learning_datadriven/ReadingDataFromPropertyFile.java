package learning_datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingDataFromPropertyFile {
	
	static String path="./src/main/resources/file.properties";
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		//Create the object of FileInputStream
		FileInputStream file=new FileInputStream(path);
		
		//create the properties class
		Properties p = new Properties();
		
		//load all the keys from property file
		p.load(file);
		
		String browser = p.getProperty("browser");
		System.out.println(browser);
		
		String url = p.getProperty("url");
		System.out.println(url);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

}
