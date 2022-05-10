package com.vitiger.Test;



import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vTigerGenericlib.BaseClass;
import com.vTigerGenericlib.JavaUtli;
import com.vTigerGenericlib.Testdata;
import com.vtiger.Pomclasses.CreateNewOrgPage;
import com.vtiger.Pomclasses.HomePage;



public class TC01_CreateOrg  extends BaseClass{
	@Parameters("Orgname")
	@Test
	public void createorg (String Orgname) throws Throwable
	{
		HomePage homePage = new HomePage(driver);

		homePage.getOrglink().click();

		OrgInfoPage orgInfoPage= new OrgInfoPage(driver);
		orgInfoPage.getCreateorgbtn().click();

		Testdata testData= new Testdata();
		JavaUtli javaUtil = new JavaUtli();
	//	String orgname=testData.getOrgname()+javaUtil.createRandomnumber();

		CreateNewOrgPage createNewOrgPage = new CreateNewOrgPage(driver);

		createNewOrgPage.getOrgname().sendKeys(Orgname);
		createNewOrgPage.getSaveorgbtn().click();

		Thread.sleep(4000);
		driver.navigate().refresh();

		homePage.getOrglink().click();

		orgInfoPage.searchforOrg(Orgname, "accountname");

		Thread.sleep(3000);

		String actualorgname=orgInfoPage.getfirstOrg().getText();

		if (Orgname.equals(actualorgname)) 
		{
			System.out.println("Tc Passes");
		}
		else {
			System.out.println("TC Fail");
		}
	}

}
