package com.viteger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	

	WebDriver driver;
	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;

	@FindBy(linkText = "Products")
	private WebElement productLnk;
	
	@FindBy(linkText = "contacts")
	private WebElement contactLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstatorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement singOutLnk;
	
     
     public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}
	public WebElement getProductLnk() {
		return productLnk;
	}
	public WebElement getContactLnk() {
		return contactLnk;
	}
	public WebElement getAdminstatorImg() {
		return adminstatorImg;
	}
	public WebElement getSingOutLnk() {
		return singOutLnk;
	}

     public void logout() {
    	 Actions act = new Actions(driver);
    	 act.moveToElement(adminstatorImg).perform();
    	 singOutLnk.click();
     }
	
	


}
