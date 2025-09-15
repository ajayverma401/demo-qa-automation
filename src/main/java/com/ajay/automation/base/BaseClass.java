package com.ajay.automation.base;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ajay.automation.utils.ConfiReaderUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	private static WebDriver driver;
	
//	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	

	
	public void browserSetup() {
		
		String browserName = ConfiReaderUtils.get("browser");
		String headLessValue = ConfiReaderUtils.get("headless");
		
//		WebDriver localDriver = null;
		
		switch (browserName.toLowerCase())
		{
		case "chrome" :
			ChromeOptions chromeOptions = new ChromeOptions();
			if(headLessValue.equalsIgnoreCase("true")) {
				chromeOptions.addArguments("--headless=new");
				chromeOptions.addArguments("--window-size=1920,1080");

			}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
//			localDriver = new ChromeDriver(chromeOptions);
//			driver.set(new ChromeDriver(chromeOptions));
			break;
		
			
		case "edge" :
			EdgeOptions edgeOptions = new EdgeOptions();
			if(headLessValue.equalsIgnoreCase("true")) {
				edgeOptions.addArguments("--headless=new");
				edgeOptions.addArguments("--window-size=1920,1080");

			}
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeOptions);
//			 localDriver = new EdgeDriver(edgeOptions);
//			 driver.set(new EdgeDriver(edgeOptions));
			break;
			
		case "firefox" :
			if(headLessValue.equalsIgnoreCase("true")) {
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--headless");
				firefoxOptions.addArguments("--window-size=1920,1080");
			}
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions);
//			localDriver = new FirefoxDriver(firefoxOptions);
//			 driver.set(new FirefoxDriver(firefoxOptions));
			break;
			
			
		default :
			System.out.println("invalid browser, please select a valid browser");
			

		}
		
//		driver.set(localDriver);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		/* getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  */
		
	}
	
	
	public void browserTearDown() {
		if(driver != null) {
			driver.quit();
			driver = null;  // critical: remove stale reference
			
		} 
	} 
	
	/* public void browserTearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    } */
	
	 /* public void browserTearDown() {
	        if (getDriver() != null) {
	            getDriver().quit();
	            driver.remove();  //  critical: remove stale reference
	        }
	    } */
	
	 public static WebDriver getDriver() {
		return driver;
	} 
	
	/* public static WebDriver getDriver() {
        return driver.get();
    }*/

}
