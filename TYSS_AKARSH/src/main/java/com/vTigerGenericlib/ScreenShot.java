package com.vTigerGenericlib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {
	
	@Test
	
	public void vtigerscreenshot() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http:localhost:8888");
		
		TakesScreenshot ts = (TakesScreenshot)(driver);
		File fl = ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C://Users/akarsh/asdf.png");
		Files.copy(fl, dest);
		
	}
	
	
	

}
