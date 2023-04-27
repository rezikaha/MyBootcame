package com.ninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ninja.qa.testbase.TestBase;

public class Search extends TestBase {
	public Search() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	public 	SoftAssert softassert = new SoftAssert();
	public static ChromeOptions options;
	 public static WebDriver driver;
	 @BeforeMethod 
	 public void setUp() {
		 driver = intialiceBrowserAndOpenApplication("chrome");
	 }
	 @Test(priority=1)
		public void VerifySearchingWithanExistingProductName() {
		 
		 driver.findElement(By.name("search")).sendKeys("HP");
			driver.findElement(By.xpath("//span[@class= 'input-group-btn']/button")).click();
			softassert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(), "Valid product HP is not displayed in the search results");
			softassert.assertAll();
	}
	 @Test(priority=2)
		public void VerifysearchingwithanonexistingProductName() {
			driver.findElement(By.name("search")).sendKeys("Home");
			driver.findElement(By.xpath("//span[@class= 'input-group-btn']/button")).click();
			
			String actualresult = driver.findElement(By.xpath("//input[@id = 'button-search']/following ::h2")).getText();
			softassert.assertTrue(actualresult.contains(actualresult),"No product message in search results is not displayed");
			softassert.assertAll();
	 }
	 @Test(priority=3)
		public void VerifysearchingwithoutprovidinganyProductName() {
			
		 driver.findElement(By.xpath("//span[@class= 'input-group-btn']/button")).click();
			

			String actualresult = driver.findElement(By.xpath("//input[@id = 'button-search']/following ::h2")).getText();
			softassert.assertTrue(actualresult.contains(actualresult),"No product message in search results is not displayed");
			softassert.assertAll();
			}


	 @AfterMethod
	 public void quite() {
	 	driver.quit();
	 }
}

