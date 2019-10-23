package com.wd.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
		public static WebDriver driver;
	//	public static WebDriverWait w;
		public static WebDriver getdriverfor(String brName) {
			switch (brName.toLowerCase()) {
			
			case "chrome":
				System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Downloads\\chromedriver.exe");
				ChromeOptions co=new  ChromeOptions();
				co.addArguments("--disable-notifications");
				//w=new WebDriverWait(driver, 30);
			    return new ChromeDriver(co);
		
				
				
			case "firefox":
	           System.setProperty("webdriver.gecko.driver","F:\\Drivers\\geckodriver.exe");
		    return new FirefoxDriver();
	          
		    
			case "ie":
				System.setProperty("webdriver.ie.driver","F:\\Drivers\\IEDriverServer.exe");
				return new InternetExplorerDriver();
				
			default:
				System.out.println("browser not valid");
				return null;
			}
		}
		
		
		
	}


