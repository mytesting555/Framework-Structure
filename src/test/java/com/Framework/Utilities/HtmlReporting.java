package com.Framework.Utilities;

// It is a listener class used to generate extent report
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class HtmlReporting extends TestListenerAdapter
{
	public ExtentHtmlReporter report;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{/*
		report=new ExtentHtmlReporter("demo-website1.html");

		extent=new ExtentReports();

		extent.attachReporter(report);
		
		test=extent.createTest("My first test", "Test extent reports on testng");
		*/
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName="Test-Report-"+timeStamp+".html";	
		report=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+reportName);
		report.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	
		extent =new ExtentReports();
		
		extent.attachReporter(report);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "karan");
		
		report.config().setDocumentTitle("Sample Framework Structure");
		report.config().setReportName("Functional Test Report");
		//report.config().setTe
		report.config().setTheme(Theme.DARK);
	}
		public  void onTestSuccess(ITestResult tr)
		{
			test=extent.createTest(tr.getName());	//create new entry in the report
			test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		}
		
		public  void onTestFailure(ITestResult tr)
		{
			test=extent.createTest(tr.getName());	//create new entry in the report
			test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		//on test failure it will capture the screenshot and it will store on the below location
		String screenshotPath=System.getProperty("user.dir\\Screenshots\\")+tr.getName()+".png";
		
		File f=new File(screenshotPath);
		
		if(f.exists())
		{
			try{
				test.fail("Screenshot is below :"+test.addScreenCaptureFromPath(screenshotPath));
			}
			
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
		
		}
		
		public void onTestSkipped(ITestResult tr)
		{
			test=extent.createTest(tr.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		}
	
		public void onFinish(ITestContext testContext)
		{
			extent.flush();
		}
		
		
	}

