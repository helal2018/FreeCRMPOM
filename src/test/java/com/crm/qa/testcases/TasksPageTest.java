package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class TasksPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TasksPage tasksPage;
	TestUtil testUtil;
	
	String sheetName = "tasks";
	
	TasksPageTest(){
		super();
		
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage =new HomePage();
		tasksPage = new TasksPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		tasksPage = homePage.clickOnTasksLink();
		
			
	}
	
	@Test(priority=1)
	public void verifyShowingAllTaksLabelTest() {
		Assert.assertTrue(tasksPage.verifyShowingAllTaksLabel(), "Showing All Tasks is missing on tasks page");
	}
	
	
	@DataProvider
	public Object[][] getPOMModelTestData(){
		
		Object data[][]= testUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test (priority= 2, dataProvider="getPOMModelTestData")
	public void enterNewTasksInfoTest(String title, String status, String completion, String type, String priority)
			throws InterruptedException{
		homePage.clickOnNewTasksLink();
		tasksPage.createNewTask(title, status, completion, type, priority);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
