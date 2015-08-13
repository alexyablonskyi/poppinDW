package poppin.exp;

import poppin.pages.Global;
import poppin.pages.Login;
import poppin.pages.ProductDetailPage;
import poppin.pages.ProductListPage;
import poppin.values.Values;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import poppin.base.Base;


public class NavRail_Exp extends Base {
	
	Global global;
	ProductListPage sR;
	ProductDetailPage pDP;
	Login loginPage;

	
	//INCOMPLETE
	@Test(enabled= false, priority=0, groups = {"Color Search"}, 
			description= "Verify all color links navigate to correct pages and that the search term exists in search results page")
	public void colorNav() throws Exception {
		global = new Global(driver);
		sR = new ProductListPage(driver);
		pDP = new ProductDetailPage(driver);
		

		pDP.refineBy("Price");
	}

	
	@Test(enabled= true, priority=0, groups = {"Sign Out"}, 
			description= "test SignOUt If Statement")
	public void testSignOut() throws Exception {
		global = new Global(driver);
		
	//	global.hoverSignIn();
	//	loginPage = new Login(driver);
	//	loginPage.loginAsReturningCustomer(Values.ID_EMAIL_QA_TEST, Values.PASS_QA_TEST);
		global.userSignOut();


		
	}
	
	
	
	
	
	
}




	
	
	
	
	
	
	


    













	

