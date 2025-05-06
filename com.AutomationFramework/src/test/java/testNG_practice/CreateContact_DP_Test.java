package testNG_practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName,String lastName,String location)
	{
		System.out.println("The Firstname: "+firstName+","+"Lastname: "+lastName+","+"Location: "+location);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[4][3];
		
		objArr[0][0] = "Madhav";
		objArr[0][1] = "Das";
		objArr[0][2] = "Vrindavan";
		
		objArr[1][0] = "Krihna";
		objArr[1][1] = "Das";
		objArr[1][2] = "Vrindavan";
		
		objArr[2][0] = "Govind";
		objArr[2][1] = "Das";
		objArr[2][2] = "Vrindavan";
		
		objArr[3][0] = "Radha";
		objArr[3][1] = "Das";
		objArr[3][2] = "Vrindavan";
		
		return objArr;
		
	}

}
