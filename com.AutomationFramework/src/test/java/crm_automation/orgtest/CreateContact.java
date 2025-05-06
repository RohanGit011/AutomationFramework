package crm_automation.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.AutomationFramework.generic.fileutility.ExcelUtility;
import com.AutomationFramework.generic.webdriverutility.JavaUtility;
import com.AutomationFramework.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContact extends BaseClassTest{

	@Test
	public void createContactWithMandatoryDetails() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		HomePage hp = new HomePage(driver);
		ContactsPage cp = new ContactsPage(driver);
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		ContactInfoPage cip = new ContactInfoPage(driver);
		
		
		//click on the contact link
		hp.getContactLink().click();
		
		//click on the create contact link
		cp.getCreateContactBtn().click();
		
		//getting the random number
		int rand=ju.getRandomNumber();
		
		//getting the random number attached to the last name
		String name=eu.getDataFromExcel("org", 1, 2)+rand;
		
		//send last name to the last name field
		cnp.getLastNameEdt().sendKeys(name);
		
		//click on the save button
		cnp.getsaveBtn().click();
		
		//verify the last name in info header
		if(cip.getContactInfo().getText().equalsIgnoreCase(name))
			System.out.println(name+" verification is pass");
	}

	@Test
	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		HomePage hp = new HomePage(driver);
		ContactsPage cp = new ContactsPage(driver);
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		ContactInfoPage cip = new ContactInfoPage(driver);
		
		//click on the contact link
		hp.getContactLink().click();
		
		//click on the create contact link
		cp.getCreateContactBtn().click();
		
		//getting the random number
		int rand=ju.getRandomNumber();
		
		//getting the random number attached to the last name
		String name=eu.getDataFromExcel("org", 1, 2)+rand;
		
		//send last name to the last name field
		cnp.getLastNameEdt().sendKeys(name);
		
		//send current date to start date field
		String tDate=ju.getDate();
		cnp.getSupportStartDateField().clear();
		cnp.getSupportStartDateField().sendKeys(tDate);
		
		//send future date to start date field
		String fDate=ju.getFutureDate();
		
		cnp.getSupportEndDateField().clear();
		cnp.getSupportEndDateField().sendKeys(fDate);
		
		//click on the save button
		cnp.getsaveBtn().click();
		
		//verify the last name in info header
		if(cip.getContactInfo().getText().contains(name))
			System.out.println(name+" verification is pass");
		
		//verify the starting date 
		if(cip.getSupportStartDate().getText().equalsIgnoreCase(tDate))
			System.out.println(tDate+"Verification is done");
		
		//verify the ending date
		if(cip.getSupportEndDate().getText().equalsIgnoreCase(fDate))
			System.out.println(fDate+"Verification is done");
	}
	
	@Test
	public void createContactWithOrganisation() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wu = new WebDriverUtility();
		HomePage hp = new HomePage(driver);
		ContactsPage cp = new ContactsPage(driver);
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		ContactInfoPage cip = new ContactInfoPage(driver);
		
		
		//click on the contact link
		hp.getContactLink().click();
		
		//click on the create contact link
		cp.getCreateContactBtn().click();
		
		//getting the random number
		int rand=ju.getRandomNumber();
		
		//getting the random number attached to the last name
		String name=eu.getDataFromExcel("org", 1, 2)+rand;
		
		//send last name to the last name field
		cnp.getLastNameEdt().sendKeys(name);
		
		cnp.getSelectImg().click();
		
		wu.switchtoWindowOrTab(driver, "http://49.249.28.218:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		
		driver.findElement(By.xpath("//a[text()='Titan1']")).click();
		
		wu.switchToParentWindow(driver,"http://49.249.28.218:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		//click on the save button
		cnp.getsaveBtn().click();
		
		//verify the last name in info header
		if(cip.getContactInfo().getText().contains(name))
			System.out.println(name+" verification is pass");
		
		if(driver.findElement(By.xpath("//a[text()='Titan1']")).getText().contains("Titan1"))
			System.out.println("Organization name is pass");

	}


}
