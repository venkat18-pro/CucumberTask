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
	driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
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

@When("User select the Location, Hotels, Room Type, Number of Romms, Check in date, chech out date, adultss per room, children per room")
public void user_select_the_Location_Hotels_Room_Type_Number_of_Romms_Check_in_date_chech_out_date_adultss_per_room_children_per_room() {
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
   Assert.assertTrue(url.contains("bookahotel"));
}

@When("User enter the firstName, lastName, Billing address, Credit Card No, Credit Card Type, Expiry date, and cvv Number")
public void user_enter_the_firstName_lastName_Billing_address_Credit_Card_No_Credit_Card_Type_Expiry_date_and_cvv_Number() {
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
  Assert.assertTrue(url.contains("bookingconfirma"));
}

@Then("User verify the Order No")
public void user_verify_the_Order_No() {
   WebElement orderNo = driver.findElement(By.id("order_no"));
   System.out.println(orderNo);
}

@Then("Usre clicks on Logout Button")
public void usre_clicks_on_Logout_Button() {
  driver.findElement(By.id("logout")).click();
}

	
}
