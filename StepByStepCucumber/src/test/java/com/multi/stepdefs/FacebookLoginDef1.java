package com.multi.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.QATesting.pageObjects.FacebookLoginPageObjects1;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookLoginDef1 {
	
	WebDriver driver;
	
	
	public FacebookLoginDef1(DriverManagerMutli dmm)
	{
		
        driver = dmm.getDriver();
    }
	
	@Given("Open the facebook home page")
    public void Open_the_facebook_home_page()
	{
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		
				
	}
	
	@When("Enter the valid username")
	public void enter_the_valid_username()
	{
		driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']")).sendKeys("amresh.arya23@gmail.com");
		
	}

	@Then("Verify the entered username")
	public void verify_the_entered_username()
	{
		String username = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']")).getAttribute("value");
		//String username = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']")).getText();
		System.out.println("Username: " + username);
		Assert.assertTrue(username.equals("amresh.arya23@gmail.com"),"Entered username is not correct");
	}
	
	@When("Enter the invalid password")
	public void enter_the_invalid_password()
	{
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Testing1234");
	}

	@After
	public void closeurl() 
	
	{
		DriverManagerMutli obj = new DriverManagerMutli();
		obj.quitDriver();
	}

	
}
