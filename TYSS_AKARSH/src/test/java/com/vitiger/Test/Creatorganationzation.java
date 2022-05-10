package com.vitiger.Test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vTigerGenericlib.Browser;
import com.vTigerGenericlib.FakerData;
import com.vTigerGenericlib.WebDriverUtil;
import com.vTigerGenericlib.propertyfiles;

public class Creatorganationzation extends Browser {
	@Test
	
	public  void org () throws Throwable {
		
//		Browser  b = new Browser();
//		b.openBrowser();
		
		WebDriverUtil w=new WebDriverUtil(driver);
		w.maxwindow();
		propertyfiles pf = new propertyfiles();
		String url = pf.readpropertyfile("url");
		driver.get(url);
		String un = pf.readpropertyfile("username");
		String pw = pf.readpropertyfile("password");
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		FakerData FD =new FakerData();
		String ln = FD.getlastName();
		driver.findElement(By.name("lastname")).sendKeys(ln);
		driver.findElement(By.id("submitButton")).click();
		
	 	Set<String> whs = driver.getWindowHandles();
	 	Iterator<String> handles = whs.iterator();
	 	String parent = handles.next();
	 	String child = handles.next();
	 	
	 	System.out.println(parent);
	 	System.out.println(child);
	 	
	 	
		
		
		
		
	}

}
