package com.salesfoce.qa.testcase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.salesforce.qa.base.BaseCLass;
import com.salesforce.qa.extentReport.ExtentReport1;
import com.salesforce.qa.pages.HomePage1;
import com.salesforce.qa.pages.LoginPage1;
import com.salesforce.qa.pages.MainPage1;
import com.salesforrce.qa.excelSheet.Exceldata;

public class LoginTest extends BaseCLass {
	HomePage1 hm;
	MainPage1 mp;
	  String [][] recData;
	
@BeforeMethod
public void setup() throws IOException {
	driver=initialisation();
	driver.get("https://login.salesforce.com/");
	hm = new HomePage1();
}
@Test(priority=1)
public void NavigatetoSFDC() throws IOException, InterruptedException {

	ExtentReport1.extentRep("NavigateToSFDC");
	recData = Exceldata.getDataInput("C:\\Users\\auhum\\Desktop\\salesForcexcel","loginerror.xls","Sheet1"); 

	  hm.verifytitle(recData[1][4]);
	  hm.enteringData(recData[1][2]);
	  hm.validateDataEnetered(recData[1][2]);
	  hm.clearpassword();
	  mp=  hm.login();
	  Thread.sleep(7000);
	  hm.cerdentialError(recData[1][5]);
}
@Test(enabled =false)
public void LogintoSFDCC() throws IOException, InterruptedException {
	
	ExtentReport1.extentRep("LogintoSFDCC");
	recData = Exceldata.getDataInput("C:\\Users\\auhum\\Desktop\\salesForcexcel","loginerror.xls","Sheet1"); 

	  hm.verifytitle(recData[1][4]);
	  hm.enteringData(recData[1][2]);
	  hm.validateDataEnetered(recData[1][2]);
	  hm.enteringPassword(recData[1][3]);
	  hm.validateDataEnteredPassword(recData[1][3]);
	  mp=  hm.login();
	  Thread.sleep(7000);
	  mp.verifytitleMain(recData[1][6]);
	 
}
@Test(enabled =false)
public void CheckRemeberMe3() throws IOException, InterruptedException {
	
	ExtentReport1.extentRep("CheckRemeberMe3");
	recData = Exceldata.getDataInput("C:\\Users\\auhum\\Desktop\\salesForcexcel","loginerror.xls","Sheet1"); 

	  hm.verifytitle(recData[1][4]);
	  hm.enteringData(recData[1][2]);
	  hm.validateDataEnetered(recData[1][2]);
	  hm.enteringPassword(recData[1][3]);
	  hm.validateDataEnteredPassword(recData[1][3]);
	  hm.rememberMe();
	  hm.ValidateRememberMe();
	  mp = hm.login();
	  Thread.sleep(7000);
	  mp.verifytitleMain(recData[1][6]);
	  mp.loginNameClick();
	  mp.logout();
	  Thread.sleep(7000);
	  hm.verifytitle(recData[1][4]);
	  hm.validateDataEnetered(recData[1][2]);
	 
}
@Test(enabled =false)
public void ForgotPassword4B() throws IOException {
	ExtentReport1.extentRep("ForgotPassword4B");
	recData = Exceldata.getDataInput("C:\\Users\\auhum\\Desktop\\salesForcexcel","loginerror.xls","Sheet1"); 
	  hm.verifytitle(recData[1][4]);
	  hm.enteringData(recData[3][3]);
	  hm.validateDataEnetered(recData[3][3]);
	  hm.enteringPassword(recData[3][4]);
	  hm.validateDataEnteredPassword(recData[3][4]);
	  mp = hm.login();
	  hm.cerdentialError(recData[3][5]);
}
@AfterMethod
public void tearDown() throws IOException {
	ExtentReport1.reports.endTest(ExtentReport1.logger);
	ExtentReport1.reports.flush();
	driver.quit();
}
}
