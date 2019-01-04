package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class TasksPage extends TestBase {
	
	
	@FindBy(xpath= "//em[text() = 'Showing all tasks']")
	WebElement showingAllTasksLabel;
	
	@FindBy(id = "title")
	WebElement titleField;
	
	
	//Deadline calendar xpath
	//@findBy(xpath ="//img[@id='f_trigger_c_deadline' and @title = 'Date selector']")
	
	@FindBy(name = "completion")
	WebElement completionField;
	
	public TasksPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyShowingAllTaksLabel() {
		
		return showingAllTasksLabel.isDisplayed();
	}
	
	public void createNewTask(String title , String stat, String complet, String typ, String prty) throws InterruptedException {
		
		
		
		titleField.sendKeys(title);
		
		Thread.sleep(200);
		
		Select select = new Select(driver.findElement(By.name("status")));//Select is used for drop selection

		select.selectByVisibleText(stat);
		
		
		
		completionField.sendKeys(complet);
		
		Thread.sleep(200);
		
		Select select1 = new Select(driver.findElement(By.name("task_type")));//Select is used for drop selection

		select1.selectByVisibleText(typ);
		
		Thread.sleep(200);
		
		Select select2 = new Select(driver.findElement(By.name("priority")));//Select is used for drop selection

		select2.selectByVisibleText(prty);
		
		
	}
	
	
	
	
	
	
	
	
	

}
