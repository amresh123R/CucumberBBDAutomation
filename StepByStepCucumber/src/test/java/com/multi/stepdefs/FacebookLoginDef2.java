package com.multi.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookLoginDef2 {
	
	public WebDriver driver;
	
	public FacebookLoginDef2(DriverManagerMutli dmm)
	{
		driver = dmm.getDriver();
	}
	
	@Then("Verify the entered password")
	public void verify_the_entered_password()
	{
		String password = driver.findElement(By.xpath("//input[@type='password']")).getAttribute("value");
		System.out.println("Password: " + password);
		Assert.assertTrue(password.equals("Testing1234"),"Entered password is not correct");
	}
	
	@When("Click on login button")
	public void click_on_login_button()
	{
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}
	
	@Then("Verify the login error message")
	public void verify_the_login_error_message()
	{
		String alertMessage = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
		Assert.assertTrue(alertMessage.contains("The password that you've entered is incorrect."),"Wrong message is displayed");
	}

	@After
	public void closeurl() 
	
	{
		DriverManagerMutli obj = new DriverManagerMutli();
		obj.quitDriver();
	}

}
