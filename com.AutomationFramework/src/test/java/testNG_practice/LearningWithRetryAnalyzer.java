package testNG_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LearningWithRetryAnalyzer extends BaseClassTest{

	
	@Test(retryAnalyzer = com.AutomationFramework.Listenerutility.RetryListenerImplementation.class)
	public void createInvoiceTest()
	{
		System.out.println("Execute create invoice");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
}
