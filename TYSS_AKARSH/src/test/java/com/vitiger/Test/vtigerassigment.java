package com.vitiger.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vTigerGenericlib.Browser;
import com.vTigerGenericlib.FakerData;
import com.vTigerGenericlib.WebDriverUtil;
import com.vTigerGenericlib.propertyfiles;


public class vtigerassigment extends Browser {
	
	@Test

	public void vtigerass() throws Throwable {
		
		Browser b=new Browser();
		b.openBrowser();
		
		propertyfiles pdata=new propertyfiles();
		
		String un=pdata.readpropertyfile("username");
		String pwd=pdata.readpropertyfile("password");
		
		String url = pdata.readpropertyfile("url");

		driver.get(url);
		WebDriverUtil web=new WebDriverUtil(driver);
	
		web.maxwindow();
		
		web.implicitlywaitForElement(15);
		
		driver.findElement(By.name("user_name")).sendKeys(un);
		
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		
		FakerData fd=new FakerData();
		String orgName = fd.getCompanyName();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
//		//driver.findElement(By.xpath("//option[@value='Banking']")).click();
//		WebElement dd = driver.findElement(By.name("industry"));
//		
//		System.out.println(dd.getText());
//		
//		Select sel=new Select(dd);
//		sel.selectByVisibleText("Banking");
//		
		driver.findElement(By.xpath("//input[@accesskey=\"S\"]")).click();
		
		Thread.sleep(3000);
		WebElement ele2 = driver.findElement(By.xpath("//span[contains(text(), 'Organization Information')]"));
		
		WebElement ele = driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[2]"));
		String orgId1=ele.getText();
		String orgIDis = orgId1.trim();
		
		String savedActual = ele2.getText();
//		System.out.println(savedActual);
		
		if(savedActual.contains(orgName))
		{
			System.out.println("Organisation Saved Successfully, PASS");
			
		}
		else
		{
			System.out.println("Organisation is NOT Saved Successfully, FAIL");
		}
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys(orgId1);
		
		WebElement dd = driver.findElement(By.id("bas_searchfield"));
		
		WebDriverUtil webu1=new WebDriverUtil(driver);		
		
		Select sel=new Select(dd);
		sel.selectByValue("account_no");
		
		driver.findElement(By.name("submit")).click();
		
		String xpat= orgIDis+" ";
		WebElement ele3 = driver.findElement(By.xpath("//td[text()='"+xpat+"']"));
		
		
		String orgId2 = ele3.getText();
		
		System.out.println("gettext OrgID is ------:"+orgIDis);
		System.out.println("OrgId to compare is ------:"+orgId2);
		
		if (orgId2.contains(orgIDis))
		{
			System.out.println("Organisation Created Successfully, And Available Search in Org List");
		}
		else
		{
			System.out.println("Organisation NOT created, NOT Available Through Search box in ORG List ");
		}
		
		Thread.sleep(3000);
		driver.close();
		
		
	}
}
