package com.salesforce.qa.extentReport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.salesforce.qa.base.BaseCLass;


public class ExtentReport1 extends BaseCLass{
	  public static ExtentReports reports;
public static ExtentTest logger;
public static   void extentRep(String TcName) throws IOException {
	//driver=bm.initialisation();
	SimpleDateFormat simpledateformatter = new SimpleDateFormat("'sampledemo_'yyyyMMddHHmm'.html'");
	Date currentDate =new Date();
	String filename = simpledateformatter.format(currentDate);
	String path = prop.getProperty("path")+filename;
	reports = new ExtentReports(path);
	 logger = reports.startTest("SalesForce "+TcName);
}
}
