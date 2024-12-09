package com.QATesting.Stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.QATesting.pageObjects.WebDriverManager1;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebbookMulti3 {
	
	WebDriver driver;
	
	@Before
	public void openurl() {
		driver = WebDriverManager1.getDriver();
	}
	
	@After
	public void teardown()
	{
		WebDriverManager1.quitDriver();
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

}
