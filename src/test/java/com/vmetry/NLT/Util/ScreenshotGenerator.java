package com.vmetry.NLT.Util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.NTL.intializer.InitializerTest;

public class ScreenshotGenerator extends InitializerTest {

	@AfterMethod
	public static void getscreenshot(ITestResult it) throws IOException
	{
		Object [] data =it.getParameters();
		if(it.isSuccess())//pass screenshot
		{
			String path=createscreenshot(data[0].toString());
			log.addScreenCapture(path);
			log.log(LogStatus.PASS, "Test case pass", path);
		}
		else {
			String path=createscreenshot(data[0].toString());
			log.addScreenCapture(path);
			log.log(LogStatus.FAIL, "Test case fail", path);
		}
		report.endTest(log);//report. close we wont give that
		report.flush();  // memory space and not to add unwanted screenshot
	}
	public static String createscreenshot(String name) throws IOException
	{
	File src= ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
	File dst=new  File("C:\\SeleniumWorkspace\\DDDFramework\\Screenshot\\"+name+".jpg");
		FileUtils.copyFile(src, dst);
		return dst.toString();
	}
}
