package learning_datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomatingFlipkart {
	
	static String excelPath="./src/main/resources/names_emails.xlsx";

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.name("q")).sendKeys("jeans",Keys.ENTER);
		
		FileInputStream file = new FileInputStream(excelPath);
		
		Workbook book = WorkbookFactory.create(file);
		
		Sheet sheet= book.createSheet("Jeans");
		
		Row row;
		
		int row1=0;
		
		List<WebElement> allJeans = driver.findElements(By.xpath("//a[@class='WKTcLC BwBZTg']"));
		
		for(WebElement jeans:allJeans)
		{
			row=sheet.createRow(row1++);
			row.createCell(0).setCellValue(jeans.getText());
		}
		
		FileOutputStream f=new FileOutputStream(excelPath);
		book.write(f);
		book.close();
		System.out.println("Data entered");
	}

}
