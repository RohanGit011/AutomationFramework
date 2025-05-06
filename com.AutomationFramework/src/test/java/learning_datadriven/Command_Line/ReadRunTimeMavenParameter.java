package learning_datadriven.Command_Line;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameter {
	
	@Test
	public void runTimeParameterTest()
	{
		System.out.println("Test ng Test");
		String url=System.getProperty("url");
		String password=System.getProperty("password");
		String username=System.getProperty("username");
		
		System.out.println("The URL is: "+url);
		System.out.println("The password is: "+password);
		System.out.println("The username is: "+username);
	}

}
