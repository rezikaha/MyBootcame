package com.ninja.qa.testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ninja.qa.utils.Utilities;

public class TestBase {
	
	public static ChromeOptions options;
	 public static WebDriver driver;
	 public Properties prop;
	 public Properties dataprop;
	 public FileInputStream ip;
	 public TestBase () throws Exception { 
		  prop = new Properties();
		 ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ninja\\qa\\config\\config.properties");
		 prop.load(ip);
		 dataprop = new Properties();
		 ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\ninja\\qa\\test\\data\\testData.properties");
		 prop.load(ip);
	 }
public WebDriver intialiceBrowserAndOpenApplication(String browserName) {
	if (browserName.equalsIgnoreCase("chrome")) {
		
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}else if (browserName.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	}else if (browserName.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
}
	
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implicitlyWait));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageloadTimeout));
	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utilities.scriptTimeout));
	driver.get(prop.getProperty("url"));
	return driver;
}
}
