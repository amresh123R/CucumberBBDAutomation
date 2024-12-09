package com.QA.DD.test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.QATesting.pageObjects.WebDriverManager1;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookDataDrivenDefs {
	
	WebDriver driver;
	
	
	@Before
	public void start() 
	{
		driver = WebDriverManager1.getDriver();
	}
	
	@After
	public void closeBrowser()
	{
		WebDriverManager1.quitDriver();
	}
	
	@Given("Open the facebook website")
	public void open_the_facebook_website()
	{
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		
	}
	
	@Given("Enter the invalid {string} and {string}")
	public void enter_the_invalid_username_and_password(String username, String password)
	{
		driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	}
	
	@When("Click on login button")
	public void click_on_login_button()
	{
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}
	
	@Then("Verify the alert message {string}")
	public void verify_the_alert_message(String alert_message_Expected) 
	{
		String alertMessageActual = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText(); 
		Assert.assertTrue(alertMessageActual.contains(alert_message_Expected), "Wrong alert message is displayed");
	}

}
