package crm_automation.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.AutomationFramework.generic.fileutility.ExcelUtility;
import com.AutomationFramework.generic.webdriverutility.JavaUtility;
import com.AutomationFramework.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganisation extends BaseClassTest{
	
	 @Test
	 public void createOrganisationWithOrgName() throws EncryptedDocumentException, IOException {
		
		ExcelUtility eu = new ExcelUtility();
		
		String orgname = eu.getDataFromExcel("org",1, 2);
		
		
		driver.manage().window().maximize();
		
		HomePage hp = new HomePage(driver);
		OrganizationsPage op = new OrganizationsPage(driver);
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		JavaUtility ju = new JavaUtility();
	
		
		hp.getOrgLink().click();
		
		op.getCreateOrgBtn().click();
		
		int rand = ju.getRandomNumber();
		String name=orgname+rand;
		
		
		cop.getOrgNameEdt().sendKeys(name);
		
		cop.getSaveBtn().click();
		
		String orgname1 = oip.getOrgInfoHeader().getText();
		 
		 if(orgname1.contains(name))
			 System.out.println((name)+" verification is=====> pass");
	}
	 
	 @Test
		public void createAndDelete() throws InterruptedException, EncryptedDocumentException, IOException
		{
		JavaUtility ju = new JavaUtility();
		ExcelUtility eu = new ExcelUtility();
				
		int rand=ju.getRandomNumber();
		
		String orgname = eu.getDataFromExcel("org",1, 2);
		
		String name=orgname+rand;
			
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//wLib.waitForPageToLoad(20);
		
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		OrganizationsPage op = new OrganizationsPage(driver);
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		
		//driver.findElement(By.xpath("//a[contains(@href, 'index.php?module=Accounts&action=i')]/ancestor::td[@class='tabUnSelected']")).click();
		hp.getOrgLink().click();
		
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		op.getCreateOrgBtn().click();
		
		//driver.findElement(By.xpath("//td[text()='Organization Name 			']/ancestor::tr[@style='height:25px']/descendant::input[@name='accountname']")).sendKeys(orgname+rand);
		cop.getOrgNameEdt().sendKeys(name);
		
		//driver.findElement(By.name("button")).click();
		cop.getSaveBtn().click();
		
		Thread.sleep(5000);
		
		oip.getOrganizationLink().click();
		
		hp.getSearchEdt().click();
		
		hp.getSearchEdt().sendKeys(name);
		
		hp.getInDD().click();
		wu.selectFromDropdown(hp.getInDD(), "accountname");
		
		hp.getSearchBtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+name+"']/../../td[8]/a[text()='del']")).click();
		
		wu.switchAlertAndAccept(driver);
	}
	 
	 @Test
		public void createOrgWithIndustry() throws InterruptedException, EncryptedDocumentException, IOException
		{
		
		
		JavaUtility ju = new JavaUtility();	
		ExcelUtility eu = new ExcelUtility();
		HomePage hp = new HomePage(driver);
		LoginPage lp =new LoginPage(driver);
		OrganizationsPage op = new OrganizationsPage(driver);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		
		String orgname = eu.getDataFromExcel("org", 4, 2);
		String indus = eu.getDataFromExcel("org", 4, 3);
		String type = eu.getDataFromExcel("org", 4, 4);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		hp.getOrgLink().click();
		
		op.getCreateOrgBtn().click();
		
		String name= orgname+ju.getRandomNumber();
		
		cnop.getOrgNameEdt().sendKeys(name);
		
		cnop.getIndustryDD().click();
		cnop.getIndustryDD().sendKeys(indus);
		
		cnop.getTypeDD().click();
		cnop.getTypeDD().sendKeys(type);
		
		cnop.getSaveBtn().click();
		
		//verify industry
		
		Thread.sleep(2000);
		
		if(oip.getIndustryOption().getText().equalsIgnoreCase(indus))
			System.out.println("Energy is pass");
		
		//verify type
		if(oip.getTypeOption().getText().equalsIgnoreCase(type))
			System.out.println("Type is pass");
	}
	 
	 @Test
		public void createOrgWithPhoneNumber() throws EncryptedDocumentException, IOException{
			
			JavaUtility ju = new JavaUtility();
			WebDriverUtility wLib= new WebDriverUtility();
			ExcelUtility eu = new ExcelUtility();
			LoginPage lp = new LoginPage(driver);
			HomePage hp = new HomePage(driver);
			OrganizationsPage op = new OrganizationsPage(driver);
			CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			
			int rand=ju.getRandomNumber();
			
			String orgname = eu.getDataFromExcel("org",1, 2);
			
			String name=orgname+rand;
			
			wLib.waitForElementToLoad(driver,20);
			
			hp.getOrgLink().click();
			
			op.getCreateOrgBtn().click();
			
			cop.getOrgNameEdt().sendKeys(name);
			
			cop.getPhoneNumberEdt().sendKeys(Integer.toString(rand));
			
			cop.getSaveBtn().click();
			
			if(oip.getPhone().getText().equals(Integer.toString(rand)))
				System.out.println(rand+" phone number is pass");
		}


}
