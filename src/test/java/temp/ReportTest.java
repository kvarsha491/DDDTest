package temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTest {
	
	public static WebDriver wd;
    public static ExtentReports report;
    public static ExtentTest log;
	@Test (priority=1)
	public void googleTest()
	{
		report =new ExtentReports("C:\\SeleniumWorkspace\\DDDFramework\\reports\\sampleTest.html");
		log=report.startTest("googleTest");
		wd=new FirefoxDriver();
		wd.get("https://www.google.com");
	}
	@Test(priority=2)
	public void yahooTest()
	{
		log=report.startTest("yahooTest");
		wd.get("https://in.yahoo.com/");
		
	}
	@Test(priority=3)
	public void bingTest(){
		log=report.startTest("bingTest");
		wd.get("https://www.bing.com/");
	}
	
	@AfterMethod
	public void teardown(ITestResult it) throws IOException
	{
		if(it.isSuccess())//pass screenshot
		{
			String path=createscreenshot(it.getName());
			log.addScreenCapture(path);
			log.log(LogStatus.PASS, "Test case pass", path);
		}
		else {
			String path=createscreenshot(it.getName());
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
