package com.salesfoce.qa.testcase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.qa.base.BaseCLass;
import com.salesforce.qa.extentReport.ExtentReport1;
import com.salesforce.qa.pages.HomePage1;
import com.salesforce.qa.pages.MainPage1;
import com.salesforrce.qa.excelSheet.Exceldata;

public class MainPageTest extends BaseCLass{
	HomePage1 hm;
	MainPage1 mp;
	  String [][] recData;
	 
@BeforeMethod
public void setup() throws IOException {
	driver=initialisation();
	driver.get("https://login.salesforce.com/");
	ExtentReport1.extentRep("Select user menu for username drop down");
	hm = new HomePage1();
	recData = Exceldata.getDataInput("C:\\Users\\auhum\\Desktop\\salesForcexcel","loginerror.xls","Sheet1"); 
	
	hm.verifytitle(recData[1][4]);
	  hm.enteringData(recData[1][2]);
	  hm.validateDataEnetered(recData[1][2]);
	  hm.enteringPassword(recData[1][3]);
	  hm.validateDataEnteredPassword(recData[1][3]);
	  mp=  hm.login();
}
@Test
public void dropDown() throws InterruptedException {
	  Thread.sleep(7000);
	  mp.verifytitleMain(recData[1][6]);
	mp.loginNameClick();
	  List<String> lm = new ArrayList<String>();
	    lm.add("My Profile");
	    lm.add("My Settings");
	    lm.add("Developer Console");
	    lm.add("Switch to Lightning Experience");
	    lm.add("Logout");
	mp.validate(lm);
}
@AfterMethod
public void tearDown() throws IOException {
	ExtentReport1.reports.endTest(ExtentReport1.logger);
	ExtentReport1.reports.flush();
	driver.quit();
}
}
