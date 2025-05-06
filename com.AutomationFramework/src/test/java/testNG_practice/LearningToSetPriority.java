package testNG_practice;

import org.testng.annotations.Test;

public class LearningToSetPriority {
	
	@Test(priority = 1)
	public void createAccount()
	{
		System.out.println("This is create account method");
	}
	@Test(priority = 2)
	public void modifyAccount()
	{
		System.out.println("This is modify account method");
	}
	@Test(priority = 3)
	public void deleteAccount()
	{
		System.out.println("This is delete account method");
	}

}
