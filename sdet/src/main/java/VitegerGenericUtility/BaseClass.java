package VitegerGenericUtility;

	import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.viteger.comcast.pomrepositylib.Home;
import com.viteger.comcast.pomrepositylib.Login;
	
	public class BaseClass {
		public static WebDriver sdriver;
		public WebDriver driver;
		public Home homepageObj;
		public WebDriverUtility wlib=new WebDriverUtility();
		public ExcelUtility elib=new ExcelUtility();
		public FileUtility flib=new FileUtility();
		public JavaUtility jlib=new JavaUtility();
		@BeforeSuite(groups= {"RegressionTesting","smokeTest"})
		public void configBS()
		{
			
		}
			
		@BeforeClass
		public void configBC() throws Throwable
		{
			//Get the values from The FileUtility
			String Browser=flib.getValuePropertykeyValue("Browser");
			if(Browser.equals("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(Browser.equals("Firefox") )
			{
				driver=new FirefoxDriver();
				
			}
			else if(Browser.equals("IE"))
			{
			driver=new InternetExplorerDriver();
			}
		  
			driver.manage().window().maximize();
		wlib.waitUntillPageload(driver);
			
			 sdriver=driver;
		}
			@BeforeMethod
		public void configBM() throws Throwable
		{
			String url=flib.getValuePropertykeyValue("url");
			String username=flib.getValuePropertykeyValue("Username");
			String password=flib.getValuePropertykeyValue("Password");
            driver.get(url);
			Login lp=new Login(driver);
			lp.loginToApp(username, password);
		}
		
		@AfterMethod
		public void configAM()
		{
			homepageObj.logout();
		}
		
		@AfterClass
		public void configAC()
		{
			driver.quit();
		}
		@AfterSuite
		public void configAS()
		{
			
		}
		}
