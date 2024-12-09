package com.multi.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerMutli {
	
	public WebDriver driver;
	
	
	public WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }   

}
