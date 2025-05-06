package com.AutomationFramework.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int rand=r.nextInt(999999999);
		
		return rand;
	}
	
	public String getDate()
	{
		Date d = new Date();
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		
		String date = sd.format(d);
		
		return date;
		
	}
	public String getFutureDate()
	{
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar c = Calendar.getInstance();
		
		c.add(Calendar.DAY_OF_MONTH, 30);
		
		String requiredDate = sd.format(c.getTime());
		
		return requiredDate;
	}
}
