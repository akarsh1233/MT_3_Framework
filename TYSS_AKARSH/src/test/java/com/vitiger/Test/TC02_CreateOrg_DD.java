package com.vitiger.Test;



import org.testng.annotations.Test;

import com.vTigerGenericlib.JavaUtli;
import com.vTigerGenericlib.Testdata;
import com.vTigerGenericlib.WebDriverUtil;
import com.vtiger.Pomclasses.CreateNewOrgPage;
import com.vtiger.Pomclasses.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class TC02_CreateOrg_DD  extends com.vTigerGenericlib.BaseClass{

		@Test
		public void createorg_dd () throws Throwable {
			HomePage homePage= new HomePage(driver);
			homePage.getOrglink().click();

			OrgInfoPage orgInfoPage = new OrgInfoPage(driver);
			orgInfoPage.getCreateorgbtn().click();

			Testdata testData= new Testdata();
			JavaUtli javaUtil = new JavaUtli();
			String orgname=testData.getCompanyname()+javaUtil.createRandomnumber();
			CreateNewOrgPage createNewOrgPage= new CreateNewOrgPage(driver);

			createNewOrgPage.getOrgname().sendKeys(orgname);
			WebDriverUtil webDriverUtil= new WebDriverUtil(driver);

			webDriverUtil.selectValuefromdd("Active", createNewOrgPage.getRating());

			webDriverUtil.selectValuefromdd(createNewOrgPage.getIndustry(), "Education");

			webDriverUtil.selectValuefromdd(createNewOrgPage.getType(), 3);

			createNewOrgPage.getSaveorgbtn().click();

			Thread.sleep(4000);
			driver.navigate().refresh();

			homePage.getOrglink().click();

			orgInfoPage.searchforOrg(orgname, "accountname");

			Thread.sleep(3000);

			String actualorgname=orgInfoPage.getfirstOrg().getText();

			if (orgname.equals(actualorgname)) 
			{
				System.out.println("Tc Passes");
			}
			else {
				System.out.println("TC Fail");
			}
		}
	
}
