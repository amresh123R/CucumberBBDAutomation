package com.QATesting.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLoginPageObjects1 {
	
	WebDriver driver;
	
	public FacebookLoginPageObjects1(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public By facebookUserName = By.xpath("//input[@class='inputtext _55r1 _6luy']");
	
	public void getFacebookUserName() {
		driver.findElement(facebookUserName).sendKeys("amresh.arya23@gmail.com");
	}
	

}
