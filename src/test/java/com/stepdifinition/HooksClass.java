package com.stepdifinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass extends BaseClass{

	@Before
	public void beforeExection() {
		laungBrowser();
		laungUrl("http://adactinhotelapp.com/");
	}
	
	@After
	public void afterExection(Scenario s) {
		
		TakesScreenshot tk =(TakesScreenshot)driver;
		byte[] ss = tk.getScreenshotAs(OutputType.BYTES);
		s.embed(ss, "img/png");
		closeBrowser();
	}
	
}
