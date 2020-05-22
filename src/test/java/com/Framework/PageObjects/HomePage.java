package com.Framework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver ldriver;
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//inspect email field
	@FindBy(id="email")
	WebElement txtEmail;
	
	//inspect password field
	@FindBy(id="pass")
	WebElement txtPassword;
	
	//inspect submit button field
	@FindBy(id="u_0_b")
	WebElement btnSubmit;
		
	//public void setEmail(String email)	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	//public void setPassword(String passwrd)
	public void setPassword(String passwrd)
	{
		txtPassword.sendKeys(passwrd);
	}
	
	public void clickButton()
	{
		btnSubmit.click();
	}
	
	/*
	static WebElement element;
	
	//create object of phone field
	public static WebElement phone_text(WebDriver driver)
	{
		element=driver.findElement(By.id("customer_phone"));
		return element;
	}
	
	//create object of email field
	public static WebElement email_text(WebDriver driver)
	{
		element= driver.findElement(By.id("customer_email"));
		
		return element;
	}*/
	
}
