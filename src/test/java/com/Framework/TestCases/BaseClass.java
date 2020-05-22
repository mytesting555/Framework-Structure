package com.Framework.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Framework.Utilities.ReadConfig;

public class BaseClass {
	
	//Object created to call the methods defined in the ReadConfig class file and the values captured in those method will
	//be passed in the base class
	ReadConfig rc=new ReadConfig();
	
	public String baseURL=rc.getApplicationURL();
	public String email=rc.getEmail();
	public String password=rc.getPassword();
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		//Logger logger=Logger.getLogger("Facebook");
		
		//PropertyConfigurator.configure("log4j2.properties");
		
		//System.getProperty("user.dir")-- this will give the project home directory
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\geckodriver-v0.21.0-win32\\geckodriver.exe");

		if(br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver",rc.getfirefoxPath()); //firefox path set in config file is called using method
			
		driver=new FirefoxDriver();
		}
		else if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",rc.getChromePath()); //chrome path set in config file is called using method
			
			driver=new ChromeDriver();
		}
		
		else if (br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",rc.getIEpath()); //chrome path set in config file is called using method
			
			driver=new InternetExplorerDriver();
		}
		
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		File target=new File(System.getProperty("user.dir")+ "\\Screenshots" +tname+".png");
		
		FileUtils.copyFile(source, target);
		
		System.out.println("Screenshot taken");
	}
	

}
