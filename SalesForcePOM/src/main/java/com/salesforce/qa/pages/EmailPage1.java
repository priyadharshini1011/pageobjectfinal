package com.salesforce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.qa.base.BaseCLass;
import com.salesforce.qa.util.Resuability1;



public class EmailPage1 extends BaseCLass {
	Resuability1 reuse = new Resuability1();
	@FindBy(xpath="//p[contains(text(),'We’ve sent you an email with a link to finish resetting your password.')]")
	WebElement msg;	
	public EmailPage1() {
		PageFactory.initElements(driver, this);
	}
		public void Emailtitle(String input) {
			reuse.validateTitle(input, "emailtitle");
		}
		public void textGiven(String input) {
			reuse.ValidateErrorMsg(msg, input);
		}
	}

