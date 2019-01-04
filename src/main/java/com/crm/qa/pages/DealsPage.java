package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	
	@FindBy(xpath = ("//input[@name='cs_submit' and @value='Show Full Form']"))
	WebElement showFullFormLink;
	
	@FindBy(id="title")
	WebElement titleLink;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(id="amount")
	WebElement amount;
	
	@FindBy(id="commission")
	WebElement commission;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")

	WebElement saveBtn;
	
	
	public DealsPage() {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	public boolean verifyShowFullFormLink() {
		return showFullFormLink.isDisplayed();
	}
	
	public void enterNewDealsInfo(String title, String cltlkup, String amt, String commsn) {
		
		titleLink.sendKeys(title);
		company.sendKeys(cltlkup);
		amount.sendKeys(amt);
		commission.sendKeys(commsn);
		saveBtn.click();
		
	}
}
