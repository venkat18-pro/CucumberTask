package com.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Report {

	public static void getReport(String jsonFile) {
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports");
		
		Configuration con = new Configuration(f, "Adactin");
		con.addClassifications("OS", "Windows");
		con.addClassifications("Browser", "Chrome");
		con.addClassifications("Verison", "10");
		con.addClassifications("Sprint", "45");
		
		List<String> l = new ArrayList<String>();
		l.add(jsonFile);
		
		ReportBuilder rb = new ReportBuilder(l, con);
		rb.generateReports();
	}
	
}
