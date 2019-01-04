package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	LoginPage loginPage;
	TestUtil testUtil;
	DealsPage dealsPage;
	HomePage homePage;
	
	String sheetName = "deals";
	
	DealsPageTest(){
		
		super();
	}
	
	
	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		dealsPage = new DealsPage();
		homePage = new HomePage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
		
	}
	
	@Test(priority=1)
	
	public void verifyShowFullFormTest() {
		Assert.assertTrue(dealsPage.verifyShowFullFormLink(), "Show Full Form Label is missing on Deals Page");
	}
	
	
	@DataProvider
	 public Object[][] getPOMModelTestData(){
		Object [][] data = testUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getPOMModelTestData")
	
	public void creatNewDealsTest(String title, String company, String amount, String commission) {
		homePage.clickOnNewDealsLink();
		dealsPage.enterNewDealsInfo(title, company, amount, commission);
		
	}
	
	
	@AfterMethod

	public void tearDown(){

		driver.quit();

	}
	
	

}
