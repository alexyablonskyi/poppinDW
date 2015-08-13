package poppin.exp;

import poppin.pages.Global;
import poppin.pages.Login;
import poppin.values.Values;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import poppin.base.Base;


public class MyAccountRail_Exp extends Base {
	
	Login loginPage;
	Global global;

	
	//INCOMPLETE - Runs down the rail but stops at privacy (new Div) 
	@Test(enabled= true, priority=0, groups = {"Color Search"}, 
			description= "Check all left rail links on My account page")
	public void colorNav() throws Exception {
		global = new Global(driver);
		loginPage = new Login(driver);
		
		global.hoverSignIn();
		loginPage.loginAsReturningCustomer(Values.ID_EMAIL_QA_TEST, Values.PASS_QA_TEST);
		
		int sectionTotal = driver.findElements(By.xpath(".//*[@id='secondary']/nav/div/div[2]/ul")).size();
		System.out.println(sectionTotal);
		
		for (int s=1; s<=sectionTotal; s++){
			int subSectionTotal = driver.findElements(By.xpath(".//*[@id='secondary']/nav/div/div[2]/ul[" + s + "]/li")).size();
			for (int sS=1; sS<=subSectionTotal; sS++){
				driver.findElement(By.xpath(".//*[@id='secondary']/nav/div/div[2]/ul[" + s + "]/li[" + sS + "]/a")).click();
				
			}
		}

		
		
		

	}
		
}




	
	
	
	
	
	
	


    













	

