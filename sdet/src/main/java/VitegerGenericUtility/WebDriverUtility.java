package VitegerGenericUtility;



	import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

	public class WebDriverUtility {
		/**
		 * this method wait for 20 sec for pageloading
		 * @author Latha
		 */

		public void waitUntillPageload(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		/**
		 * This method is used for Element to be visible
		 * @param driver
		 * @param element
		 */
		public void waitForElementVisibality(WebDriver driver,WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		/**
		 * This method is used to wait for the element to be clickable to avoid ElementClickInterceptedException
		 * @param element
		 * @throws ElementClickInterceptedException
		 * @throws Throwable 
		 */
		public void waitAndClick(WebElement element)throws ElementClickInterceptedException, Throwable
		{
			int count=0;
			while(count<20)
			{
				try {
					element.click();
					break;}
				catch(Exception e)
				{
					Thread.sleep(1000);
					count++;}
			}
				
		}
		/**
		 * /**
		 * It is used to select the WebElement with the help of value
		 * @param element
		 * @param index
		 */
		 
		public void select(WebElement element, String Option)
		{
			Select s=new Select(element);
			s.selectByValue(Option);
		}
		/**
		 * It is used to select the WebElement with the help of index
		 * @param element
		 * @param index
		 */
		public void select(WebElement element, int index)
		{
			Select s=new Select(element);
			s.selectByIndex(index);
		}
		/**
		 * It is used to move the mouse pointer by using actions class
		 * @param driver
		 * @param element
		 */
		
			public void mouseOver(WebDriver driver,WebElement element)
			{
				Actions actions =new Actions(driver);
				actions.moveToElement(element).perform();
		}
			/**
			 * It is used to RightClick  the element by using mouseover
			 * @param driver
			 * @param element
			 */
			public void RightClick(WebDriver driver,WebElement element)
			{
				Actions actions =new Actions(driver);
				actions.contextClick(element).perform();
			}
	/**
	 * It is used to accept the alert in webpage
	 * @param driver
	 */
			public void acceptAlert(WebDriver driver)
			{
				driver.switchTo().alert().accept();
			}
			/**
			 * It is used to cancel the alert in webpage
			 * @param driver
			 */
			public void CancelAlert(WebDriver driver)
			{
				driver.switchTo().alert().dismiss();
			}
			/**
			 * This method is usec to scrolling a action in webPage
			 * @param driver
			 * @param element
			 */
			public void scrollToWebElement(WebDriver driver, WebElement element)
			{
				JavascriptExecutor jse=(JavascriptExecutor)driver;
				int Y=element.getLocation().getY();
				jse.executeScript("window.scrollBy(0,"+Y+")", element);
			}
			/**
			 * It is used to switch the driver control to frame by Index
			 * @param driver
			 * @param Index
			 */
			public void SwitchtoFrame(WebDriver driver, int Index)
			{
				driver.switchTo().frame(Index);
			}
			/**
			 * It is used to switch the driver control to frame by name or id
			 * @param driver
			 * @param nameorid
			 */
			public void SwitchtoFrame(WebDriver driver, String nameorid)
			{
				driver.switchTo().frame(nameorid);
			}
			/**
			 * It is used to switch the driver control to frame by element
			 * @param driver
			 * @param element
			 */
			public void SwitchtoFrame(WebDriver driver, WebElement element)
			{
				driver.switchTo().frame(element);
			}
			/**
			 * It is used to take screenShot 
			 * @param driver
			 * @param ScreenshotName
			 * @throws Throwable 
			 */
			public void getScreenShot(WebDriver driver,String ScreenshotName) throws Throwable
			{
				TakesScreenshot ts =(TakesScreenshot)driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				File dest=new File("./Screenshot"+ScreenshotName+".PNG");
				Files.copy(src, dest);
			}
			/**
			 * It is used to Enter key in browser
			 * @param driver
			 */
			public void passEnterKey(WebDriver driver)
			{
				Actions actions=new Actions(driver);
				actions.sendKeys(Keys.ENTER);
			}
			

			public void switchToWindow(WebDriver driver, String partialTilte) {
				Set<String> windowIds = driver.getWindowHandles();
				Iterator<String> it = windowIds.iterator();
				while(it.hasNext()) {
					String wId = it.next();
					String title = driver.switchTo().window(wId).getTitle();
					if(title.contains(partialTilte)) {
						break;
					}
				}
			}
				
			
			
			}


