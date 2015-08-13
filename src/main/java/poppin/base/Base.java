package poppin.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import poppin.utilities.Utilities;

public class Base extends Utilities {
	public String baseURL = "https://storefront:pop2015@dwdev.poppin.com";
	public String eraserURL = "https://storefront:pop2015@dwdev.poppin.com/pebble-eraser-846692.html";

/* 	@BeforeClass
	public void driverSetup(){
 		automationProfile();
 	}*/
 	
 	@BeforeMethod
	public void browserLaunch(){
 		automationProfile();
 		driver.get(baseURL);
	}

	
	
	@AfterMethod
 	public void verifyIfLogin(){
 	//	isUserLoggin();
 		driver.close();
 	}
 	
 	
	@AfterClass
	public void tearDown(){
		driver.quit();	
		
	} 
	}
	

	
	
	

