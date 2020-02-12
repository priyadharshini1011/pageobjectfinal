package com.salesfoce.qa.testcase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.qa.base.BaseCLass;
import com.salesforce.qa.extentReport.ExtentReport1;
import com.salesforce.qa.pages.EmailPage1;
import com.salesforce.qa.pages.ForgotPassword1;
import com.salesforce.qa.pages.HomePage1;
import com.salesforce.qa.pages.MainPage1;
import com.salesforrce.qa.excelSheet.Exceldata;

public class ForgotPAssword extends BaseCLass {
	HomePage1 hm;
	MainPage1 mp;
	ForgotPassword1 fp;
	EmailPage1 ep;
	  String [][] recData;
	
@BeforeMethod
public void setup() throws IOException {
	driver=initialisation();
	driver.get("https://login.salesforce.com/");
	ExtentReport1.extentRep("ForgotPassword4A");
	hm = new HomePage1();
	recData = Exceldata.getDataInput("C:\\Users\\auhum\\Desktop\\salesForcexcel","loginerror.xls","Sheet1"); 
	hm.verifytitle(recData[1][4]);
	fp = hm.forgotPassword();
}
@Test
public void ForgotPassword4A() throws IOException, InterruptedException {
	
	fp.validatePage(recData[3][0]);
	  fp.userForgot(recData[1][2]);
	  fp.userIDValidate(recData[1][2]);
	  ep=fp.clickContinue();
	  ep.Emailtitle(recData[3][1]);
	  ep.textGiven(recData[3][2]);
	  
}
@AfterMethod
public void tearDown() throws IOException {
	ExtentReport1.reports.endTest(ExtentReport1.logger);
	ExtentReport1.reports.flush();
	driver.quit();
}

}
