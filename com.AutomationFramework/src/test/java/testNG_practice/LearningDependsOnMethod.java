package testNG_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LearningDependsOnMethod {
	
	@Test
	public void createAccount()
	{
		Assert.fail();
	}

	@Test(dependsOnMethods = "createAccount")
	public void deleteAccount()
	{
		System.out.println("This is delete account method");
	}

}
