package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.Report;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", glue = "com.stepdifinition", dryRun = false, plugin = {"pretty",
		"json:src\\test\\resources\\Reports\\adactin.json", "html:src\\test\\resources\\Reports"}, monochrome=true)
public class TestRunner {

	@AfterClass
	public static void JVMReport() {
		Report.getReport(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\adactin.json");
	}
	
}
