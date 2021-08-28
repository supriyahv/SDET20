package com.viteger.comcast.Organization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {
	WebDriver driver;
	   public ExtentHtmlReporter reporter;
	   public ExtentReports reports;
	   public ExtentTest test;
	   
	   
			
		@BeforeSuite
		public void Setup()
		{
			reporter=new ExtentHtmlReporter("../sdet/ExtentReport/SDET.html");
			System.out.println("Before suit executed");
			reporter.config().setDocumentTitle("SDET");
			reporter.config().setTheme(Theme.DARK);
			reports=new ExtentReports();
		    reports.attachReporter(reporter);
			
			
		}
		@BeforeClass
		public void configBc()
		{
			
		driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		}
		@BeforeMethod()
		
		public void CongiBM() {
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
		}
		@Test
		public void home() {
			test=reports.createTest("home");
			String hometitle = driver.getTitle();
			String expected="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
			System.out.println(hometitle);
			Assert.assertEquals(hometitle,expected);
		}
		@Test
		public void organization() {
			test=reports.createTest("organization");
			driver.findElement(By.linkText("Organizations")).click();
			String orgtitle = driver.getTitle();
			 String  expected1="Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";
			System.out.println(orgtitle);
			Assert.assertEquals(orgtitle,expected1);
		}
		 @AfterMethod
		   public void configAM()
		   {
			 Actions actions=new Actions(driver);
			  WebElement Administratorlink = driver.findElement(By.xpath("//img[@Src='themes/softed/images/user.PNG']"));
				actions.moveToElement(Administratorlink).perform();
			   driver.findElement(By.linkText("Sign Out")).click();
		   }
		   @AfterClass
		   public void confifAc()
		   {
			   driver.close();
		   }
		   @AfterSuite
		   public void configAS() {
			   reports.flush();
			  System.out.println("close DB");
		   }

}
