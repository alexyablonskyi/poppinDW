package poppin.endToEnd;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poppin.pages.Billing;
import poppin.pages.Global;
import poppin.pages.Login;
import poppin.pages.ProductListPage;
import poppin.pages.Shipping;
import poppin.values.ShippingNames;
import poppin.values.Values;
import poppin.base.Base;

public class End_To_end extends Base {
	Global global;
	ProductListPage plp;
	Shipping shipping;
	Login loginPage;
	Billing billing;
	
		@BeforeMethod
		public void checkout() throws Exception {
		global = new Global(driver);
		plp = new ProductListPage(driver);
		shipping = new Shipping(driver);
		loginPage = new Login(driver);
		billing = new Billing(driver);
						
		closeModalIfExist();
		global.search("File Cabinet");
		plp.chooseSearchItem("3");
	    shipping.clickAddToCartButton();
	    shipping.clickMiniCartButton();
	    shipping.clickCheckoutButton(); 
	    loginPage.loginAsReturningCustomer(Values.ID_EMAIL_QA_TEST, Values.PASS_QA_TEST); 	
	    
		}

		
		@Test(enabled= true, priority=0, groups = {"Checkout"},
				description= "Verify user is able to do a basic checkout [Using Visa Card]")
		public void checkoutVisa() throws Exception {
			Thread.sleep(4000);
			shipping.setShippingAddress(Values.NAME_FIRST, Values.NAME_LAST, Values.ID_EMAIL_QA_TEST, Values.PHONE_NUM, Values.ADDRESS, Values.ADDRESS2, "New York", Values.LOC_NEWYORK, Values.ZIP_CODE_NY);
			shipping.continueToShippingMethod_Button.click();
			shipping.setShippingMethod(ShippingNames.NEXT_BUSINESS_DAY);
			
			billing.setBillingAddress(Values.NAME_FIRST, Values.NAME_LAST, Values.ID_EMAIL_QA_TEST, Values.PHONE_NUM, Values.ADDRESS, Values.ADDRESS2, "New York", Values.LOC_NEWYORK, Values.ZIP_CODE_NY);
			billing.setPaymentInformation(Values.NAME_FULL, Values.CC_VISA_NUM, "Visa", "January", "2019", "123");
			billing.clickPlaceOrderButton();
		
			Assert.assertEquals(billing.ordConfMSGText(), "Thank you for your order!");
			
		}

		
		
}
