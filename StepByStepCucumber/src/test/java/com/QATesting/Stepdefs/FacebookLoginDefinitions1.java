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

public class FacebookLoginDefinitions1 {
	
	private WebDriver driver;
	public FacebookLoginPageObjects1 obj = new FacebookLoginPageObjects1(driver);
	
	@Before(order = 1)
    public void setup(){
        //driver = new ChromeDriver();
		driver = WebDriverManager1.getDriver();
		System.out.println("Before 1");
    }
	

	@Before(order = 2)
    public void setup2(){
        //driver = new ChromeDriver();
		System.out.println("Before 2");
    }
    @After(order = 1)
    public void tearDown(){
        WebDriverManager1.quitDriver();
        System.out.println("After 1");
    }
    
    @After(order = 2)
    public void tearDown2(){
    	System.out.println("After 2");
    }
    
    
	@Given("Open the facebook home page")
    public void Open_the_facebook_home_page()
	{
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		obj = new FacebookLoginPageObjects1(driver);
				
	}
	
	@When("Enter the valid username")
	public void enter_the_valid_username()
	{
		//driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']")).sendKeys("amresh.arya23@gmail.com");
		obj.getFacebookUserName();
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
	
	@Then("Verify the entered password")
	public void verify_the_entered_password()
	{
		String password = driver.findElement(By.xpath("//input[@type='password']")).getAttribute("value");
		System.out.println("Password: " + password);
		Assert.assertTrue(password.equals("Testing1234"),"Entered password is not correct");
	}
	
	/*
	 * @When("Click on login button") public void click_on_login_button() {
	 * driver.findElement(By.xpath("//button[@name='login']")).click(); }
	 * 
	 * @Then("Verify the login error message") public void
	 * verify_the_login_error_message() { String alertMessage =
	 * driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
	 * Assert.assertTrue(alertMessage.
	 * contains("The password that you've entered is incorrect."
	 * ),"Wrong message is displayed"); }
	 */
}
