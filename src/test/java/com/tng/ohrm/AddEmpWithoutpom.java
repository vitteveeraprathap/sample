package com.tng.ohrm;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wd.utils.DriverFactory;

public class AddEmpWithoutpom {
	WebDriver driver;
	WebDriverWait w;
	@BeforeClass
//	@Parameters({  "browser" })
	
	public void openapp() {
		System.out.println("this is first commit");
	driver=DriverFactory.getdriverfor("chrome");
	driver.get("https://ravib-trials653.orangehrmlive.com/auth/login");
    driver.manage().window().maximize();
 }
	
	@Test
	public void Login() {
	driver.findElement(By.id("txtUsername")).sendKeys("_ohrmSysAdmin_");
	driver.findElement(By.id("txtPassword")).sendKeys("veera@123");
	driver.findElement(By.id("btnLogin")).click();
	}
	
	
	@Test(dependsOnMethods="Login")
	public void AddEmployee() throws InterruptedException {
	driver.findElement(By.xpath("//span[text()='PIM']")).click();
	Thread.sleep(1000);
	//driver.findElement(By.xpath("//span[text()='Employee List']")).click();
	driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
	
    w=new WebDriverWait(driver, 20);
	w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='firstName']")));
	driver.findElement(By.id("firstName")).sendKeys("veera");
	driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("veerareddy");
	
	driver.findElement(By.xpath("//div[@id='location_inputfileddiv']//input[@class='select-dropdown']")).click();
	
	WebElement ele =driver.findElement(By.xpath("//span[contains(text(),'Chinese Development Center')]"));
	
	JavascriptExecutor js =(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", ele);
	ele.click();
	driver.findElement(By.xpath("//a[@id='systemUserSaveBtn']")).click();
	}

}
