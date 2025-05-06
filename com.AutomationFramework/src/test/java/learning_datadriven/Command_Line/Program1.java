package learning_datadriven.Command_Line;

import org.testng.annotations.Test;

public class Program1 {
	
	@Test
	public void readFirstDataFromCMD()
	{
		System.out.println("This is first JUnit test method");
		String browser=System.getProperty("browser");
		String url=System.getProperty("url");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		
		System.out.println("The following data are: \n"+browser+"\n"+url+"\n"+username+"\n"+password);          
	}
	@Test
	public void readSecondDataFromCMD()
	{
		System.out.println("This is second JUnit test method");
		String browser1=System.getProperty("browser1");
		String url1=System.getProperty("url1");
		String username1=System.getProperty("username1");
		String password1=System.getProperty("password1");
		
		System.out.println("The following data are: \n"+browser1+"\n"+url1+"\n"+username1+"\n"+password1);
	}

}
