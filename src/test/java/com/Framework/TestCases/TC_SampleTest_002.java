package com.Framework.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Framework.PageObjects.HomePage;
import com.Framework.Utilities.ExcelUtils;

public class TC_SampleTest_002 extends BaseClass{
	
	HomePage hp=new HomePage(driver);
	
	@Test(dataProvider="LoginData")
	public void loginDDT()
	{
		System.out.println(email+ " | " +password);
		
		hp.setEmail(email);
		
		hp.setPassword(password);
		
		hp.clickButton();
	}
	
	@DataProvider(name="LoginData")
	public static Object[][] getData()
	{
		Object data[][]=testData();
		
		return data;
	}
	
	
	public static Object[][] testData()
	{
		ExcelUtils excel=new ExcelUtils();
		/*
		String path=System.getProperty("user.dir")+"src\\test\\java\\com\\Framework\\TestData\\LoginData.xlsx";
		
		int rowCount1=ExcelUtils.getRowCount(path, "Sheet1");
		int colCount1=ExcelUtils.getColCount(path, "Sheet1");
		*/
		
		int rowCount=excel.getRowCount();
		int colCount=excel.getColCount();
		
				
		Object data[][]=new Object[rowCount-1][colCount];
	
		for (int i=1; i<rowCount; i++)
		{
			for (int j=0; j<colCount; j++)
			{
				String cellData=excel.getCellDataString(i, j);
				System.out.print(cellData+ "  |  ");
				
				data[i-1][j]=cellData;
			}
			System.out.println();
		}
		return data;
	
	}

}
