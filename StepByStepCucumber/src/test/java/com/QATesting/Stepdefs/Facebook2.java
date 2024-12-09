package com.QATesting.Stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.QATesting.pageObjects.FacebookLoginPageObjects1;
import com.QATesting.pageObjects.WebDriverManager1;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Facebook2 {
	
	WebDriver driver;
	FacebookLoginPageObjects1 obj;
	
	@Before
    public void setup(){
        //driver = new ChromeDriver();
		driver = WebDriverManager1.getDriver();
    }
    @After
    public void tearDown(){
        WebDriverManager1.quitDriver();
    }
    
	/*
	 * @Given("Open the facebook home page") public void
	 * Open_the_facebook_home_page() { driver.get("https://www.facebook.com");
	 * driver.manage().window().maximize(); obj = new
	 * FacebookLoginPageObjects1(driver);
	 * 
	 * }
	 */
    @When("Enter the invalid {string} username")
    public void enter_the_invalid_username(String username)
    {
    	driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']")).sendKeys(username);
    }

    @Then("Verify the entered invalid {string} username")
	public void verify_the_entered_invalid_username(String username)
	{
		String usernameActual = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']")).getAttribute("value");
		//String username = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']")).getText();
		System.out.println("Username: " + username);
		System.out.println("usernameActual: " + usernameActual);
		Assert.assertTrue(usernameActual.equals(username),"Entered username is not correct");
	}
    
        
    @Then("Verify the alert message")
    public void verify_the_alert_message()
    {
    	String message = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
    	Assert.assertTrue(message.contains("The email address you entered isn't connected to an account"),"Alert message is not correct");
    	
    }
}

