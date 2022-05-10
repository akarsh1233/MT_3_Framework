package com.vitiger.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.Pomclasses.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AsssertTestNg {
	
	@Test
	
	public void Hardandsofassert() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
	
		
		
		driver.get("http:localhost:8888");
		LoginPage ln = new LoginPage(driver);
		WebElement un = ln.getUserTextbox();
		boolean di = un.isDisplayed();
		un.sendKeys("admin");

		
		Assert.assertEquals(di, true);
		
		
		WebElement pwd = driver.findElement(By.name("user_password"));
		boolean pwdvalve = un.isDisplayed();
		
		Assert.assertEquals(pwdvalve, true);
		pwd.sendKeys("admin");
		
		
		
		 
	}

}
