package com.base;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	   public static WebDriver driver;
		
		public void laungBrowser() {
//			System.setProperty("webdriver.chrome.driver", 
//					"C:\\Users\\ELCOT\\eclipse-workspace\\SeleniumProject\\Drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		@SuppressWarnings("deprecation")
		public void laungUrl(String url) {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
			
		public void clickBtn(WebElement ele) {
			ele.click();

		}
		
		public void input(WebElement ele, String value) {
			ele.sendKeys(value);
		}
		
		public void selectElement(WebElement loc, String value) {
			Select selLoc = new Select(loc);
			selLoc.selectByVisibleText(value);	
		}
		
		public String eleAttriValue(WebElement ele, String value) {
			String attribute = ele.getAttribute(value);
			return attribute;
		}
	
		public void verifyPage(String str) {
			String currentUrl = driver.getCurrentUrl();
			String url = currentUrl.toLowerCase();
		    Assert.assertTrue(url.contains(str));
		}
		
		public void closeBrowser() {
			driver.quit();
		}
}
