package com.viteger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VitegerGenericUtility.WebDriverUtility;



public class CreateNewOrganization {
	WebDriver driver;
	
	public CreateNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement clickEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		 clickEdt.click();
		 saveBtn.click();
		
	}

	
	}
	

