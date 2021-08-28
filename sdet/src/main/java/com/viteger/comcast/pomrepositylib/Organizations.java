package com.viteger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	
	public Organizations(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgImg;
	
	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}

}
