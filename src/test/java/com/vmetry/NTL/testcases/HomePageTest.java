package com.vmetry.NTL.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vmetry.NLT.Util.ScreenshotGenerator;
import com.vmetry.NLT.inputreader.inputReader;
import com.vmetry.NLT.pages.TestHomepage;
import com.vmetry.NTL.intializer.InitializerTest;

public class HomePageTest extends InitializerTest {

@BeforeTest	public void setup() throws IOException
	{
		intialize();
	}
	@Test(dataProvider="HomePageTest",priority=1)	
	public void TestHomepage(String data,String Username ,String address,String place,String basic,String testing) throws IOException
	{
		log=report.startTest(data);
		
		wd.get(envprop.getProperty("URL"));
		TestHomepage.enterusername(Username);
		TestHomepage.adress(address);
		TestHomepage.place(place);
		TestHomepage.basic(basic);
		TestHomepage.dropdown();
	}
		@DataProvider(name="HomePageTest")
	public static Object[][] getdata() throws Exception
		{
			if(inputReader.runModeVerification("HomePageTest"))
			{
				
			
			
			Object[][] data =inputReader.selectSingleDataOrMulitiData("HomePageTest");
			return data;
			
			}
//		Object[][] data =new Object[2][5];//[3]is iteration [2] is column
//			//First data set
//			
//			data[0][0]="HomePageTest_dataset1";		
//		data[0][1]="Testa";
//		data[0][2]="abc";
//		data[0][3]="ADYAR";
//		data[0][4]="CHEPAUK";
//		//2nd data set
//		data[1][0]="HomePageTest_dataset2";
//		data[1][1]="Testb";
//		data[1][2]="bcd";
//		data[1][3]="ALWARPET";
//		data[1][4]="chennai";
//		
		return null;


		}
@AfterMethod
public void teardown(ITestResult it) throws IOException
{
	ScreenshotGenerator.getscreenshot(it);
}
}
	

