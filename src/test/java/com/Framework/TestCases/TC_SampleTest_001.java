package com.Framework.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Framework.PageObjects.HomePage;

public class TC_SampleTest_001 extends BaseClass
{	
	
	
	@Test
	public void firstTest() throws IOException
	{
		driver.get(baseURL);
		
		
		/*Methods defined in the page object class should be class in this class. So to call those methods create a 
		object of the page object class
		*/
		HomePage hp=new HomePage(driver);
		
		hp.setEmail(email);
		
		hp.setPassword(password);
		
		hp.clickButton();
/*
		if(driver.getTitle().equals("Facebook – log in or sign "))
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			captureScreen( driver, "firstTest");
			Assert.assertTrue(false);
		}
		
		//assert.assertTrue(condition);
		
	*/			
	}
}
