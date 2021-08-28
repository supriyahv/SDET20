package VitegerGenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.viteger.comcast.pomrepositylib.ITestListner;

import VitegerGenericUtility.BaseClass;

public class Listner implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		String TestscriptName =result.getMethod().getMethodName();
		EventFiringWebDriver edriver =new EventFiringWebDriver(BaseClass.sdriver);
	    File srcFile=edriver.getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(srcFile, new File("./Screenshort"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
