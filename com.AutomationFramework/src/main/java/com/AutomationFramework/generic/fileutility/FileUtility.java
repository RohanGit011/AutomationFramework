package com.AutomationFramework.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;


public class FileUtility {

	public String getDataFromPropertyFile(String value) throws Throwable 
	{
		FileInputStream file = new FileInputStream("./src/main/resources/file.properties");
		 Properties p = new Properties();
		 p.load(file);
			
			return p.getProperty(value);
		
		
		
		
	}

}
