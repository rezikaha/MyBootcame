package com.ninja.qa.testcases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ninja.qa.test.data.SupplyTestData;
import com.ninja.qa.testbase.TestBase;
import com.ninja.qa.utils.Utilities;



public class LoginTest extends TestBase {
	
	public LoginTest() throws Exception {
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
			driver.findElement(By.linkText("Login")).click(); 
	 }
@Test (priority =1, dataProvider= "tutorialsninjaExelDataProvider", dataProviderClass = SupplyTestData.class )
public void verifyNinjaLoginWithValideUsernameAndPassword(String username, String password) {
	
	driver.findElement(By.id("input-email")).sendKeys(username);
	driver.findElement(By.id("input-password")).sendKeys(password);
	driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	
	
	softassert.assertTrue(driver.findElement(By.className("content")).isDisplayed());
	softassert.assertAll();

	
}
@Test (priority =2)
public void verifyNinjaLoginWithInvalideUsernameAndPassword() {
	
	driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
	driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
	driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

	String actualWarningMessage = driver.findElement(By.xpath("//ul[@class='breadcrumb']/following-sibling :: div")).getText();
	String expectedWarningMessage = (dataprop.getProperty("temptWarningMessage"));
	softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning Message is Not correct");
	softassert.assertAll();
	
	
}
@Test (priority =3)
public void verifyNinjaLoginWithValideUsernameAndInvalidePassword() {
	
	driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
	driver.findElement(By.id("input-password")).sendKeys("Rezika@1234");
	driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	
	String actualWarningMessage = driver.findElement(By.xpath("//ul[@class='breadcrumb']/following-sibling :: div")).getText();
	String expectedWarningMessage = (dataprop.getProperty("temptWarningMessage"));
	softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning Message is Not correct");
	softassert.assertAll();
	
}
@Test (priority =4)
public void verifyNinjaLoginWithEmptyUsernameAndCorrectPassword() {
	
	driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validePassword"));
	driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

	String actualWarningMessage = driver.findElement(By.xpath("//ul[@class='breadcrumb']/following-sibling :: div")).getText();
	String expectedWarningMessage = dataprop.getProperty("temptWarningMessage");
	softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning Message is Not correct");
	softassert.assertAll();

}
@Test (priority =5)
public void verifyNinjaLoginWithValideUsernameAndEmptyPassword() {
	
	driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
	
	driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	

	softassert.assertTrue(driver.findElement(By.className("list-group-item")).isDisplayed());
	softassert.assertAll();
	
}
@AfterMethod
public void quite() {
	driver.quit();
}
}