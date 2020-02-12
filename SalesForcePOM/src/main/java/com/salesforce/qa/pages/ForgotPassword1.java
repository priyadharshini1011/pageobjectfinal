package com.salesforce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.qa.base.BaseCLass;
import com.salesforce.qa.util.Resuability1;



public class ForgotPassword1 extends BaseCLass {
	Resuability1 reuse = new Resuability1();
	@FindBy(id="un")
	WebElement UserNameForgot;
	@FindBy(id="continue")
	WebElement clickContinue;
	public ForgotPassword1(){
		PageFactory.initElements(driver, this);
	}
	public EmailPage1 clickContinue() {
		reuse.click1(clickContinue, "continue");
		return new EmailPage1();
	}
	public void userForgot(String input) {
		reuse.sendkeys(UserNameForgot, "UserName", input);
	}
	public void userIDValidate(String input) {
		reuse.validateData(UserNameForgot, "emailId", input);
	}
	public void validatePage(String arg1)
	{

reuse.validateTitle(arg1, "Page");
	}
}
