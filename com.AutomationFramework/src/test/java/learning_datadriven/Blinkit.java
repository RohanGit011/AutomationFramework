package learning_datadriven;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Blinkit {
    
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        driver.get("https://blinkit.com/");
        driver.findElement(By.xpath("//button[text()='Detect my location']")).click();
        JavascriptExecutor j = (JavascriptExecutor) driver;

        int maxScrolls = 50;  // Prevent infinite loop
        int scrollCount = 0;

        while (scrollCount < maxScrolls) {
            try {
                WebElement xyz = driver.findElement(By.xpath("//div[text()='Cold Drinks & Juices']"));
                
                // Wait for element to be clickable
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                xyz = wait.until(ExpectedConditions.elementToBeClickable(xyz));

                xyz.click();
                System.out.println("Clicked on 'Cold Drinks & Juices'!");
                break;
            } catch (Exception e) {
                j.executeScript("window.scrollBy(0, 100)");  // Scroll more
                Thread.sleep(500);
                scrollCount++;
            }
        }

        if (scrollCount == maxScrolls) {
            System.out.println("Element not found after scrolling.");
        }

        driver.quit();
    }
}
