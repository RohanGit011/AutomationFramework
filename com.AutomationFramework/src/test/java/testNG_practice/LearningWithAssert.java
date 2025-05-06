package testNG_practice;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LearningWithAssert {
	
	@Test
	public void methodTest1(Method mtd)
	{
		System.out.println(mtd.getName());
		System.out.println("Step-1");
		System.out.println("Step-2");
		//Hard Assert
		Assert.assertEquals("Home", "Home1");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

	@Test
	public void methodTest2(Method mtd)
	{
		SoftAssert obj = new SoftAssert();
		System.out.println(mtd.getName());
		System.out.println("Step-5");
		System.out.println("Step-6");
		//Soft assert
		obj.assertEquals("Home", "Home1");
		System.out.println("Step-7");
		System.out.println("Step-8");
	}
	
	@Test
	public void methodTest3(Method mtd)
	{
		System.out.println(mtd.getName());
		System.out.println("Step-9");
		System.out.println("Step-10");
		//Hard assert
		Assert.assertTrue(false);
		System.out.println("Step-11");
		System.out.println("Step-12");
	}
}
