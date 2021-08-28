package com.viteger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {   //Rule :1 Create a separate java class for every page in a application
	
	public Login(WebDriver driver) {   //Rule 3 : Execute all the elements & initialize the elements PageFactory.initElements [initialization]
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")               //Rule 2 : Identify all the elements using @findBy & findAll , findBy (Declaration)
	 private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	 private WebElement userPasswordEdt;
	
	@FindAll({@FindBy(id = "submitButton"), @FindBy(xpath="//input[@id='submitButton']")})
	 private WebElement loginBtn;
	//Rule 4 : Declare all the elements as private & provide getters method , business method for (Utilization)

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	public void loginToApp(String userName , String password) {
		 /* step 1 : login*/
		 userNameEdt.sendKeys(userName);
		 userPasswordEdt.sendKeys(password);
		 loginBtn.click();
	}


}
