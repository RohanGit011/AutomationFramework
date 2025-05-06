package learning_datadriven.XML_file;

import java.io.File;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Program2 {
	
	@Test
	public void readDataTest(XmlTest test)
	{
		System.out.println("This a read data test method");
		String browser=test.getParameter("browser");
		String url=test.getParameter("url");
		String userName=test.getParameter("username");
		String pass=test.getParameter("password");
		
		System.out.print("System info are: "+browser+"\t"+url+"\t"+userName+"\t"+pass);
	
	}

}
