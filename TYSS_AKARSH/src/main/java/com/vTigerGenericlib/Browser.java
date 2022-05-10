package com.vTigerGenericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public  WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	public void openBrowser(String browser) throws Throwable
	{
		propertyfiles prop=new propertyfiles();
		//String browser= prop.readpropertyfile("browser");

		if (browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("No proper browser detected, Opening Default Browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

}
}
