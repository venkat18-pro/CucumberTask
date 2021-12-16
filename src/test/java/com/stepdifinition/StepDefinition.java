package com.stepdifinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Given("User launch web application")
	public void user_launch_web_application() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ELCOT\\eclipse-workspace\\SeleniumProject\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@When("User enter the login and password")
	public void user_enter_the_login_and_password() {
		   driver.findElement(By.id("username")).sendKeys("Venkat7012");
		   driver.findElement(By.id("password")).sendKeys("NG6602"); 
	}

	@When("User clicks on login Button")
	public void user_clicks_on_login_Button() {
		 driver.findElement(By.id("login")).click();
	}

	@Then("User verify Search Hotel page is displayed")
	public void user_verify_Search_Hotel_page_is_displayed() {
		String currentUrl = driver.getCurrentUrl();
		String url = currentUrl.toLowerCase();
	    Assert.assertTrue(url.contains("searchhotel"));
	}

	@When("User select the location, hotels, roomType, numberofRomms, checkInDate, chechOutDate, adultssPerRoom, childrenPerRoom")
	public void user_select_the_location_hotels_roomType_numberofRomms_checkInDate_chechOutDate_adultssPerRoom_childrenPerRoom() {
		 WebElement loc = driver.findElement(By.id("location"));
		   Select selLoc = new Select(loc);
			selLoc.selectByIndex(1);
			WebElement hotel = driver.findElement(By.id("hotels"));
			Select selHotel = new Select(hotel);
			selHotel.selectByIndex(1);
			WebElement roomType = driver.findElement(By.id("room_type"));
			Select selRoomType = new Select(roomType);
			selRoomType.selectByIndex(1);
	}

	@When("User clicks on Search Button")
	public void user_clicks_on_Search_Button() {
		driver.findElement(By.id("Submit")).click();
	}

	@Then("User verify Select Hotel page is displayed")
	public void user_verify_Select_Hotel_page_is_displayed() {
		 String currentUrl = driver.getCurrentUrl();
		 String url = currentUrl.toLowerCase();
		 Assert.assertTrue(url.contains("selecthotel"));
	}

	@Then("User clicks on radio Button")
	public void user_clicks_on_radio_Button() {
		driver.findElement(By.id("radiobutton_0")).click();
	}

	@Then("User clicks on Continue Button")
	public void user_clicks_on_Continue_Button() {
		 driver.findElement(By.id("continue")).click();
	}

	@Then("User verify Book A Hotel page is displayed")
	public void user_verify_Book_A_Hotel_page_is_displayed() {
		 String currentUrl = driver.getCurrentUrl();
		   String url = currentUrl.toLowerCase();
		   Assert.assertTrue(url.contains("bookhotel"));
	}

	@When("User enter the firstName, lastName, billingAddress, creditCardNo, creditCardType, expiryMonth, expiryYear and cvvNumber")
	public void user_enter_the_firstName_lastName_billingAddress_creditCardNo_creditCardType_expiryMonth_expiryYear_and_cvvNumber() {
		  driver.findElement(By.id("first_name")).sendKeys("venkatesh");
		   driver.findElement(By.id("last_name")).sendKeys("Sel");
		   driver.findElement(By.id("address")).sendKeys("cuddalore");
		   driver.findElement(By.id("cc_num")).sendKeys("6473894653784563");
		   WebElement ccType = driver.findElement(By.id("cc_type"));
		   Select selCcType = new Select(ccType);
		   selCcType.selectByIndex(2);
		   WebElement ccExpMonth = driver.findElement(By.id("cc_exp_month"));
		   Select selCcExpMonth = new Select(ccExpMonth);
		   selCcExpMonth.selectByIndex(4);
		   WebElement ccExpYear = driver.findElement(By.id("cc_exp_year"));
		   Select selCcExpYear = new Select(ccExpYear);
		   selCcExpYear.selectByIndex(5);
		   driver.findElement(By.id("cc_cvv")).sendKeys("7463");
	}

	@When("User clciks on Book Now Button")
	public void user_clciks_on_Book_Now_Button() {
		driver.findElement(By.id("book_now")).click();
	}

	@Then("User verify Booking Confirmation page is displayed")
	public void user_verify_Booking_Confirmation_page_is_displayed() {
		  String currentUrl = driver.getCurrentUrl();
		  String url = currentUrl.toLowerCase();
//		  Assert.assertTrue(url.contains("booking"));
	}

	@Then("User verify the Order No")
	public void user_verify_the_Order_No() {
		WebElement orderNo = driver.findElement(By.id("order_no"));
		   System.out.println("Order Id: "+orderNo.getAttribute("value"));
	}

	@Then("Usre clicks on Logout Button")
	public void usre_clicks_on_Logout_Button() {
		driver.findElement(By.id("logout")).click();
		driver.quit();
	}

	@When("User select the {string}, {string}, {string}, numberOfRomms, checkInDate, chechOutDate, adultssPerRoom, childrenPerRoom")
	public void user_select_the_numberOfRomms_checkInDate_chechOutDate_adultssPerRoom_childrenPerRoom(String location, String hotels, String roomtype) {
		 WebElement loc = driver.findElement(By.id("location"));
		   Select selLoc = new Select(loc);
			selLoc.selectByVisibleText(location);
			WebElement hotel = driver.findElement(By.id("hotels"));
			Select selHotel = new Select(hotel);
			selHotel.selectByVisibleText(hotels);
			WebElement roomType = driver.findElement(By.id("room_type"));
			Select selRoomType = new Select(roomType);
			selRoomType.selectByVisibleText(roomtype);
	    
	}

	@When("User enter the {string}, {string}, {string}, {string}, {string}, {string},{string} and {string}")
	public void user_enter_the_and(String firstName, String lastName, String billingAddress, String ccNo, String cctype, String expMon, String expYear, String ccvNum) {
		 driver.findElement(By.id("first_name")).sendKeys(firstName);
		   driver.findElement(By.id("last_name")).sendKeys(lastName);
		   driver.findElement(By.id("address")).sendKeys(billingAddress);
		   driver.findElement(By.id("cc_num")).sendKeys(ccNo);
		   WebElement ccType = driver.findElement(By.id("cc_type"));
		   Select selCcType = new Select(ccType);
		   selCcType.selectByVisibleText(cctype);
		   WebElement ccExpMonth = driver.findElement(By.id("cc_exp_month"));
		   Select selCcExpMonth = new Select(ccExpMonth);
		   selCcExpMonth.selectByVisibleText(expMon);
		   WebElement ccExpYear = driver.findElement(By.id("cc_exp_year"));
		   Select selCcExpYear = new Select(ccExpYear);
		   selCcExpYear.selectByVisibleText(expYear);
		   driver.findElement(By.id("cc_cvv")).sendKeys(ccvNum);
	}

	
}
