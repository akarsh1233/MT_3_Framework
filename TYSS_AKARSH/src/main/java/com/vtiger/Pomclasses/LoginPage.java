package com.vtiger.Pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.vTigerGenericlib.propertyfiles;

import org.openqa.selenium.support.FindAll;

public class LoginPage {
	
	WebDriver driver ;
	public LoginPage(WebDriver driver) {
		this.driver =driver;
	}
	@FindBy (name="user_name")	private WebElement userTextbox;
	
	@FindBys({@FindBy(name="user_password"),@FindBy(xpath="//input[@type= 'password'")})
	private WebElement passwordTextbox;
	
	@FindAll ({@FindBy(id ="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginbtn ;
	

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getUserTextbox() {
		return userTextbox;
	}

	

	public WebElement getPasswordTextbox() {
		return passwordTextbox;
	}
	
	propertyfiles prop = new propertyfiles();
	
	public void loginToAPp() throws Throwable {
		userTextbox.sendKeys(prop.readpropertyfile("username"));
		passwordTextbox.sendKeys(prop.readpropertyfile("password"));
		loginbtn.click();
		
		
	}
	
	

}
