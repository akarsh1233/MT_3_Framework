package com.vTigerGenericlib;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vtiger.Pomclasses.HomePage;
import com.vtiger.Pomclasses.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public propertyfiles proppertyFiles= new propertyfiles();

	
	@BeforeClass
	public void launchBrowser() throws Throwable 
	{
		String BROWSER=proppertyFiles.readpropertyfile("browser");

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("Invalid input");
		}

		driver.get(proppertyFiles.readpropertyfile("url"));
		WebDriverUtil webDriverUtil = new WebDriverUtil(driver);
		webDriverUtil.maxwindow();
		webDriverUtil.pageloadtimeout();

	}

	@BeforeMethod
	public void login() throws Throwable 
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToAPp();

	}
	@AfterMethod
	public void logout() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.logoutfromApp();
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(10000);
		driver.close();

	}

}