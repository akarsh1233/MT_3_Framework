package com.vitiger.Test;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import com.vTigerGenericlib.WebDriverUtil;

	public class Organizations {
		WebDriver driver;
		public Organizations(WebDriver driver)
		{
			this.driver=driver;
		}
		@FindBy(xpath="//a[text()='Organizations']")
		  private WebElement orglink;
		
		@FindBy(xpath="//img[@title='Create Organization...']")
		private WebElement orgimage;
		
	 @FindBy(name="search_text")
	   private WebElement searchbox;
	 
	 @FindBy(name="search_field")
	 private WebElement orgdd;
	 
	 @FindBy(name="submit")
	 private WebElement searchbtn;
	 
	 @FindBy(name="accountname")
	 private WebElement orgnametb;
	 
	 @FindBy(xpath="//input[@title='Save [Alt+S]']")
	 private WebElement savebtn;
	 

	public WebElement getOrglink() {
		return orglink;
	}
	public WebElement getOrgimage() {
		return orgimage;
	}
	public WebElement getSearchbox() {
		return searchbox;
	}
	public WebElement getOrgdd() {
		return orgdd;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public WebElement getOrgnametb() {
		return orgnametb;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	com.vTigerGenericlib.WebDriverUtil wdu=new com.vTigerGenericlib.WebDriverUtil(driver);
	 public void searchOrg(String orgname,String value) throws Throwable
	 {
		 orglink.click();
		 searchbox.sendKeys(orgname);
		 wdu.selectValuefromdd(orgdd,value);
		 Thread.sleep(2000);
		 searchbox.click();
		  
	 }
	 public void createOrg(String orgname)
	 {
		 orglink.click();
		 orgimage.click();
		 orgnametb.sendKeys(orgname);
		 savebtn.click();
		 
		 
		 
	 }
	}


