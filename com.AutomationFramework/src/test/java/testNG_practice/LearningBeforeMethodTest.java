package testNG_practice;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearningBeforeMethodTest {
	
	@Test
	public void demoTest()
	{
		System.out.println("This is demo test method");
	}
	
	@BeforeMethod
	public void zeroMethodTest()
	{
		System.out.println("This is zero method");
	}

}
