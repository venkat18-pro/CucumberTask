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
			input(loginPo.getTxtUser(), "Venkat7012");
			input(loginPo.getTxtPass(), "NG6602");
	}

	@When("User clicks on login Button")
	public void user_clicks_on_login_Button() {
		clickBtn(loginPo.getBtnLogin());
	}

	@Then("User verify Search Hotel page is displayed")
	public void user_verify_Search_Hotel_page_is_displayed() {
		verifyPage("searchhotel");
	}

	@When("User select the location, hotels, roomType, numberofRomms, checkInDate, chechOutDate, adultssPerRoom, childrenPerRoom")
	public void user_select_the_location_hotels_roomType_numberofRomms_checkInDate_chechOutDate_adultssPerRoom_childrenPerRoom() {
		selPo = new SelectLocationPojo();
		selectElement(selPo.getLoc(), "Sydney");
		selectElement(selPo.getHotel(), "Hotel Sunshine");
		selectElement(selPo.getRoomType(), "Standard");
	}

	@When("User clicks on Search Button")
	public void user_clicks_on_Search_Button() {
		clickBtn(selPo.getBtnSubmit());
	}

	@Then("User verify Select Hotel page is displayed")
	public void user_verify_Select_Hotel_page_is_displayed() {
		verifyPage("selecthotel");
	}

	@Then("User clicks on radio Button")
	public void user_clicks_on_radio_Button() {
		conPo = new ConformPojo();
		clickBtn(conPo.getSelRadio());
	}

	@Then("User clicks on Continue Button")
	public void user_clicks_on_Continue_Button() {
		clickBtn(conPo.getBtnContinue());
	}

	@Then("User verify Book A Hotel page is displayed")
	public void user_verify_Book_A_Hotel_page_is_displayed() {
		verifyPage("bookhotel");
	}

	@When("User enter the firstName, lastName, billingAddress, creditCardNo, creditCardType, expiryMonth, expiryYear and cvvNumber")
	public void user_enter_the_firstName_lastName_billingAddress_creditCardNo_creditCardType_expiryMonth_expiryYear_and_cvvNumber() {
		payPo = new PaymentPojo();
		input(payPo.getFirstName(), "venkatesh");
		input(payPo.getLastName(), "Sel");
		input(payPo.getAddr(), "cuddalore");
		input(payPo.getCcNum(), "6473894653784563");
		selectElement(payPo.getCctype(), "VISA");
		selectElement(payPo.getCcExpMonth(), "February");
		selectElement(payPo.getCcExpYear(), "2022");
		input(payPo.getCcCvv(), "7463");
	}

	@When("User clciks on Book Now Button")
	public void user_clciks_on_Book_Now_Button() {
		clickBtn(payPo.getBtnBookNow());
	}

	@Then("User verify Booking Confirmation page is displayed")
	public void user_verify_Booking_Confirmation_page_is_displayed() {
		  String currentUrl = driver.getCurrentUrl();
		  String url = currentUrl.toLowerCase();
		  System.out.println(url);
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
			selectElement(selPo.getLoc(), location);
			selectElement(selPo.getHotel(), hotels);
			selectElement(selPo.getRoomType(), roomtype);
	    
	}

	@When("User enter the {string}, {string}, {string}, {string}, {string}, {string},{string} and {string}")
	public void user_enter_the_and(String firstName, String lastName, String billingAddress, String ccNo, String cctype, String expMon, String expYear, String ccvNum) {
		payPo = new PaymentPojo();
		input(payPo.getFirstName(), firstName);
		input(payPo.getLastName(), lastName);
		input(payPo.getAddr(), billingAddress);
		input(payPo.getCcNum(), ccNo);
		selectElement(payPo.getCctype(), cctype);
		selectElement(payPo.getCcExpMonth(), expMon);
		selectElement(payPo.getCcExpYear(), expYear);
		input(payPo.getCcCvv(), ccvNum);
	}

	
}
