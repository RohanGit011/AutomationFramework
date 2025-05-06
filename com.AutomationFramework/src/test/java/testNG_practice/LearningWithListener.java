package testNG_practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.AutomationFramework.Listenerutility.BaseClassTest1;


//@Listeners(com.AutomationFramework.Listenerutility.ListenerImplementation.class)
public class LearningWithListener extends BaseClassTest1{
	
	@Test
	public void createInvoiceTest()
	{
		System.out.println("Execute create invoice");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	@Test
	public void createInvoiceWithContactTest()
	{
		System.out.println("Execute create invoice with contact");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

}
