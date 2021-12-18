package com.stepdifinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pojo.ConformPojo;
import com.pojo.LoginPojo;
import com.pojo.PaymentPojo;
import com.pojo.SelectLocationPojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{	
	LoginPojo loginPo;
	SelectLocationPojo selPo;
	ConformPojo conPo;
	PaymentPojo payPo;
	
	@Given("User launch web application")
	public void user_launch_web_application() {
	}

	@When("User enter the login and password")
	public void user_enter_the_login_and_password() {
		loginPo = new LoginPojo();
//		   driver.findElement(By.id("username")).sendKeys("Venkat7012");
//		   driver.findElement(By.id("password")).sendKeys("NG6602"); 
			input(loginPo.getTxtUser(), "Venkat7012");
			input(loginPo.getTxtPass(), "NG6602");
	}

	@When("User clicks on login Button")
	public void user_clicks_on_login_Button() {
//		 driver.findElement(By.id("login")).click();
		clickBtn(loginPo.getBtnLogin());
	}

	@Then("User verify Search Hotel page is displayed")
	public void user_verify_Search_Hotel_page_is_displayed() {
//		String currentUrl = driver.getCurrentUrl();
//		String url = currentUrl.toLowerCase();
//	    Assert.assertTrue(url.contains("searchhotel"));
		verifyPage("searchhotel");
	}

	@When("User select the location, hotels, roomType, numberofRomms, checkInDate, chechOutDate, adultssPerRoom, childrenPerRoom")
	public void user_select_the_location_hotels_roomType_numberofRomms_checkInDate_chechOutDate_adultssPerRoom_childrenPerRoom() {
		selPo = new SelectLocationPojo();
//		 WebElement loc = driver.findElement(By.id("location"));
//		   Select selLoc = new Select(loc);
//			selLoc.selectByIndex(1);
		selectElement(selPo.getLoc(), "Sydney");
//			WebElement hotel = driver.findElement(By.id("hotels"));
//			Select selHotel = new Select(hotel);
//			selHotel.selectByIndex(1);
		selectElement(selPo.getHotel(), "Hotel Sunshine");
//			WebElement roomType = driver.findElement(By.id("room_type"));
//			Select selRoomType = new Select(roomType);
//			selRoomType.selectByIndex(1);
		selectElement(selPo.getRoomType(), "Standard");
	}

	@When("User clicks on Search Button")
	public void user_clicks_on_Search_Button() {
//		driver.findElement(By.id("Submit")).click();
		clickBtn(selPo.getBtnSubmit());
	}

	@Then("User verify Select Hotel page is displayed")
	public void user_verify_Select_Hotel_page_is_displayed() {
//		 String currentUrl = driver.getCurrentUrl();
//		 String url = currentUrl.toLowerCase();
//		 Assert.assertTrue(url.contains("selecthotel"));
		verifyPage("selecthotel");
	}

	@Then("User clicks on radio Button")
	public void user_clicks_on_radio_Button() {
		conPo = new ConformPojo();
//		driver.findElement(By.id("radiobutton_0")).click();
		clickBtn(conPo.getSelRadio());
	}

	@Then("User clicks on Continue Button")
	public void user_clicks_on_Continue_Button() {
//		 driver.findElement(By.id("continue")).click();
		clickBtn(conPo.getBtnContinue());
	}

	@Then("User verify Book A Hotel page is displayed")
	public void user_verify_Book_A_Hotel_page_is_displayed() {
//		 String currentUrl = driver.getCurrentUrl();
//		   String url = currentUrl.toLowerCase();
//		   Assert.assertTrue(url.contains("bookhotel"));
		verifyPage("bookhotel");
	}

	@When("User enter the firstName, lastName, billingAddress, creditCardNo, creditCardType, expiryMonth, expiryYear and cvvNumber")
	public void user_enter_the_firstName_lastName_billingAddress_creditCardNo_creditCardType_expiryMonth_expiryYear_and_cvvNumber() {
		payPo = new PaymentPojo();
//		  driver.findElement(By.id("first_name")).sendKeys("venkatesh");
		input(payPo.getFirstName(), "venkatesh");
//		   driver.findElement(By.id("last_name")).sendKeys("Sel");
		input(payPo.getLastName(), "Sel");
//		   driver.findElement(By.id("address")).sendKeys("cuddalore");
		input(payPo.getAddr(), "cuddalore");
//		   driver.findElement(By.id("cc_num")).sendKeys("6473894653784563");
		input(payPo.getCcNum(), "6473894653784563");
//		   WebElement ccType = driver.findElement(By.id("cc_type"));
//		   Select selCcType = new Select(ccType);
//		   selCcType.selectByIndex(2);
		selectElement(payPo.getCctype(), "VISA");
//		   WebElement ccExpMonth = driver.findElement(By.id("cc_exp_month"));
//		   Select selCcExpMonth = new Select(ccExpMonth);
//		   selCcExpMonth.selectByIndex(4);
		selectElement(payPo.getCcExpMonth(), "February");
//		   WebElement ccExpYear = driver.findElement(By.id("cc_exp_year"));
//		   Select selCcExpYear = new Select(ccExpYear);
//		   selCcExpYear.selectByIndex(5);
		selectElement(payPo.getCcExpYear(), "2022");
//		   driver.findElement(By.id("cc_cvv")).sendKeys("7463");
		input(payPo.getCcCvv(), "7463");
	}

	@When("User clciks on Book Now Button")
	public void user_clciks_on_Book_Now_Button() {
//		driver.findElement(By.id("book_now")).click();
		clickBtn(payPo.getBtnBookNow());
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
	}

	@When("User select the {string}, {string}, {string}, numberOfRomms, checkInDate, chechOutDate, adultssPerRoom, childrenPerRoom")
	public void user_select_the_numberOfRomms_checkInDate_chechOutDate_adultssPerRoom_childrenPerRoom(String location, String hotels, String roomtype) {
		selPo = new SelectLocationPojo();
//		 WebElement loc = driver.findElement(By.id("location"));
//		   Select selLoc = new Select(loc);
//			selLoc.selectByVisibleText(location);
			selectElement(selPo.getLoc(), location);
//			WebElement hotel = driver.findElement(By.id("hotels"));
//			Select selHotel = new Select(hotel);
//			selHotel.selectByVisibleText(hotels);
			selectElement(selPo.getHotel(), hotels);
//			WebElement roomType = driver.findElement(By.id("room_type"));
//			Select selRoomType = new Select(roomType);
//			selRoomType.selectByVisibleText(roomtype);
			selectElement(selPo.getRoomType(), roomtype);
	    
	}

	@When("User enter the {string}, {string}, {string}, {string}, {string}, {string},{string} and {string}")
	public void user_enter_the_and(String firstName, String lastName, String billingAddress, String ccNo, String cctype, String expMon, String expYear, String ccvNum) {
		payPo = new PaymentPojo();
//		 driver.findElement(By.id("first_name")).sendKeys(firstName);
		input(payPo.getFirstName(), firstName);
//		   driver.findElement(By.id("last_name")).sendKeys(lastName);
		input(payPo.getLastName(), lastName);
//		   driver.findElement(By.id("address")).sendKeys(billingAddress);
		input(payPo.getAddr(), billingAddress);
//		   driver.findElement(By.id("cc_num")).sendKeys(ccNo);
		input(payPo.getCcNum(), ccNo);
//		   WebElement ccType = driver.findElement(By.id("cc_type"));
//		   Select selCcType = new Select(ccType);
//		   selCcType.selectByVisibleText(cctype);
		selectElement(payPo.getCctype(), cctype);
//		   WebElement ccExpMonth = driver.findElement(By.id("cc_exp_month"));
//		   Select selCcExpMonth = new Select(ccExpMonth);
//		   selCcExpMonth.selectByVisibleText(expMon);
		selectElement(payPo.getCcExpMonth(), expMon);
//		   WebElement ccExpYear = driver.findElement(By.id("cc_exp_year"));
//		   Select selCcExpYear = new Select(ccExpYear);
//		   selCcExpYear.selectByVisibleText(expYear);
		selectElement(payPo.getCcExpYear(), expYear);
//		   driver.findElement(By.id("cc_cvv")).sendKeys(ccvNum);
		input(payPo.getCcCvv(), ccvNum);
	}

	
}
