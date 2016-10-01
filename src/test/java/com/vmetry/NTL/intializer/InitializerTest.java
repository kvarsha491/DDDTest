package com.vmetry.NTL.intializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.Spring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import temp.ReportTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vmetry.NLT.Util.ReportGenerator;


public class InitializerTest {
	//Extends declaration
	
    public static ExtentReports report;
    public static ExtentTest log;
	// properties for environment 

	public static FileInputStream envfis=null; 
	public static Properties envprop=null;
	public static FileInputStream locfis=null;
	public static Properties locprop=null;
	//Webdriver declaration
	public static WebDriver wd=null;
 public static boolean isarchieve=true;

	public static void intialize() throws IOException
	{
		
		ReportGenerator.archievefiles();
		
		report =new ExtentReports("C:\\SeleniumWorkspace\\DDDFramework\\reports\\sampleTest.html");
  envfis=new FileInputStream(new File("C:"+File.separator+"SeleniumWorkspace"+File.separator+"DDDFramework"+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"env.properties"));
          envprop=new Properties();
         envprop.load(envfis);	
         locfis=new FileInputStream(new File("C:"+File.separator+"SeleniumWorkspace"+File.separator+"DDDFramework"+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"Locator.properties"));
     	locprop=new Properties();
     	locprop.load(locfis);
	//System.out.println(envprop.getProperty("URL"));
	if(envprop.getProperty("BROWSER").equals("firefox"))
	{
	   wd =new FirefoxDriver();
	  
	}
	wd.manage().window().maximize();
	wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wd.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
public static WebElement getEebElementByXpath(String xpath)
{
	return wd.findElement(By.xpath(locprop.getProperty(xpath)));
	
}

}
