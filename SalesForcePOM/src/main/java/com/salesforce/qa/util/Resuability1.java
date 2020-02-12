package com.salesforce.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.salesforce.qa.extentReport.ExtentReport1;





public class Resuability1 extends ExtentReport1 {

public boolean  click1(WebElement obj,String ObjName) {
	if(obj.isEnabled()) {
		obj.click();
		 ExtentReport1.logger.log(LogStatus.PASS, ObjName+" element clicked");
	return true;
	}
	else
		 ExtentReport1.logger.log(LogStatus.FAIL,ObjName+" element not clicked");
	return false;
}
public boolean sendkeys(WebElement obj,String ObjName,String input) {
	if(obj.isDisplayed()) {
		obj.sendKeys(input);
		 ExtentReport1.logger.log(LogStatus.PASS, ObjName+" data enetered");
	return true;	
	}
		else
			 ExtentReport1.logger.log(LogStatus.FAIL, ObjName+" data not enetered");
return false;
}
public void validateTitle(String input,String ObjName) {
	
String title =driver.getTitle();

Assert.assertEquals(title, input);
ExtentReport1.logger.log(LogStatus.PASS,ObjName+" title verified");
}
public void validateData(WebElement obj, String objName, String input) {
	System.out.println("reuse"+input);
	String textboxValue=obj.getAttribute("value");
	Assert.assertEquals(textboxValue, input);
	 ExtentReport1.logger.log(LogStatus.PASS,objName+ " validated data enetered");
	
}
public void ValidateErrorMsg(WebElement errorMsg, String msg) {
	String EMsg = errorMsg.getText();
	Assert.assertEquals(EMsg, msg);
	 ExtentReport1.logger.log(LogStatus.PASS, " validated error msg");
	
}
public void validatecheckbox(WebElement obj) {
	//obj.isSelected();
	Assert.assertTrue(obj.isSelected());
	 ExtentReport1.logger.log(LogStatus.PASS, " validated check box selected");
}
}
