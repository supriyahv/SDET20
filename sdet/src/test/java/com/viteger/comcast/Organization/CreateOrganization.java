package com.viteger.comcast.Organization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.viteger.comcast.pomrepositylib.CreateNewOrganization;
import com.viteger.comcast.pomrepositylib.Home;
import com.viteger.comcast.pomrepositylib.Login; 
import com.viteger.comcast.pomrepositylib.OrganizationInfo;
import com.viteger.comcast.pomrepositylib.Organizations;

import VitegerGenericUtility.BaseClass;
@Listeners(VitegerGenericUtility.Listner.class)
public class CreateOrganization extends BaseClass {
	

	@Test
	public void  createOrganization()
	{
		String orgName = "Comcast";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8888");
		
		/*step 1 : login */
		Login loginPage = new Login(driver);
		loginPage.loginToApp("admin", "admin");
		
		
		/*step 2 : navigate to Organization*/
		Home homepage = new Home(driver);
		homepage.getOrganizationLnk().click();
		
		/*step 3 : navigate to "Create new Organization"page by click on "+" image*/
		Organizations orgPage = new Organizations(driver);
		orgPage.getCreateOrgImg().click();
		
		/*step 4 : create Organization*/
		CreateNewOrganization cno = new CreateNewOrganization(driver);
		cno.createOrg(orgName);
		
		/*step 5 : verify the successful msg with org name*/
		OrganizationInfo orginfoPage = new OrganizationInfo(driver);
		String actsSuccesfullMg = orginfoPage.getSuccesfullMsg().getText();
		boolean expectAlert = actsSuccesfullMg.contains(orgName);
		Assert.assertTrue(expectAlert);
		if(actsSuccesfullMg.contains(orgName)) {
			System.out.println(orgName + "===>created Successfully");
		}else {
			System.out.println(orgName + "===>notcreated Successfully");
		}
		
		
        /*step 6 : logout*/
			homepage.logout();
		
	

		
	}

}
