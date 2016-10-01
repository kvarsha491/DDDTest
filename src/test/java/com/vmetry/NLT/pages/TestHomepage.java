package com.vmetry.NLT.pages;

import com.vmetry.NTL.intializer.InitializerTest;

public class TestHomepage extends InitializerTest{

	public static void enterusername(String name){
		getEebElementByXpath("HOMEPAGE_TYPE_USERNAME_XPATH").sendKeys(name);
		
		}
	public static void adress(String address){
		getEebElementByXpath("HOMEPAGE_TYPE_ADDRESS_XPATH").sendKeys(address);
		
		}
	public static void place(String place){
		getEebElementByXpath("HOMEPAGE_TYPE_PLACE_XPATH").sendKeys(place);
		
		}
	public static void basic(String basic){
		getEebElementByXpath("HOMEPAGE_TYPE_BASIC_XPATH").sendKeys(basic);
		
		}
	public static void dropdown(){
		getEebElementByXpath("HOMEPAGE_TYPE_DROPDOWN_XPATH").click();
		
		}
}
