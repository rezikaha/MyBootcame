package com.ninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ninja.qa.testbase.TestBase;
import com.ninja.qa.utils.Utilities;

public class CreatAcountTest extends TestBase{


public CreatAcountTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
public 	SoftAssert softassert = new SoftAssert();
public static ChromeOptions options;
 public static WebDriver driver;
 @BeforeMethod 
 public void setUp() {
	 driver = intialiceBrowserAndOpenApplication("chrome");
	 
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click(); 
 }
@Test (priority =1)
public void verifyNinjaRegesterWithValideUsernameAndPassword() {
    driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("name"));
    driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastname"));
    driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
    driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
    driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validePassword"));
    driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validePassword"));
    driver.findElement(By.name("agree")).click();
    driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
    driver.findElement(By.linkText("Continue")).click();
    
	
	softassert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	softassert.assertAll();
	 
	 
		

}
@Test(priority=2)
public void VerifyRegisteringanAccountbyprovidingallthefields() {
	driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("name"));
    driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastname"));
    driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
    driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
    driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validePassword"));
    driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validePassword"));
    driver.findElement(By.xpath("//label[@class='radio-inline']/input")).click();
    driver.findElement(By.name("agree")).click();
    driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
    driver.findElement(By.linkText("Continue")).click();
    
	
	softassert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	softassert.assertAll();
	 
	 
   	 
}
@Test(priority=3)
public void VerifyRegisteringanAccountbyprovidingtheexistingaccount() {
	driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("name"));
    driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastname"));
   driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
    driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
    driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validePassword"));
    driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validePassword"));
    driver.findElement(By.xpath("//label[@class='radio-inline']/input")).click();
    driver.findElement(By.name("agree")).click();
    driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
 
	
    String actualWarning = driver.findElement(By.xpath("//div[@class= 'row']/preceding-sibling:: div")).getText();
    
	softassert.assertTrue(actualWarning.contains(dataprop.getProperty("creatingWarningMessage")),"Warning massage is not displyed");
   	softassert.assertAll();
   	 
    }
@Test(priority=4)
public void VerifyRegistereingAccountWithoutFillingAnyDetails() {
	
    driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
    
    String actualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible']")).getText();
    softassert.assertTrue(actualPrivacyPolicyWarning.contains(actualPrivacyPolicyWarning),"Warning massage is not displyed");
 
   	 
    String actualFirstNameWarning = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
    softassert.assertTrue(actualFirstNameWarning.contains(actualFirstNameWarning),"First Name Message Warning is not displayed");
    
    String actualLastNameWarning = driver.findElement(By.xpath("//input[@id='input-laststname']/following-sibling::div")).getText();
    softassert.assertTrue(actualLastNameWarning.contains(actualLastNameWarning),"Last Name Message Warning is not displayed");
    
    String actualEmailWarning = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
    softassert.assertTrue(actualEmailWarning.contains(actualEmailWarning) ,"Email Message Warning is not displayed");
    
    String actualTelephoneWarning = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
    softassert.assertTrue(actualTelephoneWarning.contains(actualTelephoneWarning),"Telephone Message Warning is not displayed");
    
    String actualPasswordWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
    softassert.assertTrue(actualPasswordWarning.contains(actualPasswordWarning),"Password Message Warning is not displayed");
    	softassert.assertAll();
}

@AfterMethod
public void quite() {
	driver.quit();
}
}