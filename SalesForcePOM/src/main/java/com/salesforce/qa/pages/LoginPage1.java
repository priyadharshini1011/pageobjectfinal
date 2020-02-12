package com.salesforce.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.qa.base.BaseCLass;
import com.salesforce.qa.util.Resuability1;



public class LoginPage1 extends BaseCLass{
	Resuability1 reuse = new Resuability1();
public LoginPage1(){
		PageFactory.initElements(driver, this);
	}
By login = By.xpath("//a[contains(text(),'Login')]");
WebElement r = driver.findElement(login);
@FindBy(xpath="//a[contains(text(),'Login')]")
WebElement login1;
public HomePage1 loginsales() {
	reuse.click1(login1,"login");
	return new HomePage1();
}
}
