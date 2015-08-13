package poppin.exp;

import org.testng.Assert;
import org.testng.annotations.Test;

import poppin.base.Base;
import poppin.pages.Global;
import poppin.pages.Login;
import poppin.pages.Netsuite;
import poppin.values.Values;




public class NewCustomerNetSuite extends Base {

	Login loginPage;
	Global global;
	Netsuite nS;

	//passed
	@Test(enabled= false, priority=3, groups = {"Login/Creating customer"}, 
			description= "Verify netsuite access and segment check ")
    public void netSuiteTest() throws Exception{
		nS = new Netsuite(driver);
		
		
		nS.netSuiteSignIn();
		nS.netSuiteCustomerSearch(Values.ID_EMAIL_QA_TEST);
		Assert.assertTrue(nS.nsCustomerName.getText().contains(Values.NAME_FIRST), "Customer Name does not Match");
		Assert.assertTrue(nS.nSCustomerSegment.getText().contains("B2B"));        
    }
	
	@Test(enabled= true, priority=3, groups = {"Login/Creating customer"}, 
			description= "Verify netsuite access and segment check ")
    public void netSuiteCheck() throws Exception{
		nS = new Netsuite(driver);
				
		nS.netSuiteSignIn();
		nS.netSuiteCustomerSearch("qa.test@poppin.com");
		nS.verifyCustomer("Poppin");
		nS.verifyCompany("Test Company");
	

        
    }

 
}




