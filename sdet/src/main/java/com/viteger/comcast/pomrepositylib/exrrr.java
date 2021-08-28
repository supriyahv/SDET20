package com.viteger.comcast.pomrepositylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class exrrr {

}



public WebElement getUserNameEdt() {
	 return userNameEdt;
}
public WebElement getLoginBtn() {
	return loginBtn;
}
public WebElement getUserPasswordEdt() {
	 return userPasswordEdt;
}
public WebElement getLoginEdt() {
	 return loginBtn;
}
public void loginToApp(String userName , String password) {
	 /* step 1 : login*/
	 userNameEdt.sendKeys(userName);
	 userPasswordEdt.sendKeys(password);
	 loginBtn.click();
}




/*step 1 : login */
Login loginPage = new Login(driver);
loginPage.loginToApp("admin", "admin");

driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();

/*step 2 : navigate to Organization*/
driver.findElement(By.linkText("Organizations")).click();

/*step 3 : navigate to "Create new Organization"page by click on "+" image*/
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

/*step 4 : create Organization*/
driver.findElement(By.name("accountname")).sendKeys("Comcast");
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

/*step 5 : verify the successful msg with org name*/
String actMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(actMsg.contains(orgName)) {
	System.out.println("org is created successfuly==>PASS");
}else {
	System.out.println("org is not created successfuly==>FAIL");
}

/*step 6 : logout*/
WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
Actions act =new Actions(driver);
act.moveToElement(wb).perform();
driver.findElement(By.linkText("Sign Out")).click();




}

}





public WebElement getOrganizationLnk() {
	 return organizationLnk;
}
public WebElement getProductLnk() {
	 return productLnk;
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



public WebElement getSuccesfullMsg() {
	return succesfullMsg;





















