package poppin.checkout;

import poppin.pages.Billing;
import poppin.pages.Shipping;
import poppin.pages.Global;
import poppin.pages.Login;
import poppin.pages.ProductListPage;
import poppin.pages.model.BillingModel;
import poppin.values.Values;

import org.testng.Assert;
import org.testng.annotations.Test;

import poppin.base.Base;


public class Checkout_AddressCopyOver extends Base {
	
	Global global;
	ProductListPage plp;
	Shipping shipping;
	Login loginPage;
	Billing billing;
	

	public void checkout() throws Exception {
		global = new Global(driver);
		plp = new ProductListPage(driver);
		shipping = new Shipping(driver);
		loginPage = new Login(driver);
		billing = new Billing(driver);
						
		driver.get(eraserURL);
	    shipping.clickAddToCartButton();
	    shipping.clickMiniCartButton();
	    shipping.clickCheckoutButton(); 
	    loginPage.loginAsReturningCustomer(Values.ID_EMAIL_QA_TEST, Values.PASS_QA_TEST); 	
		shipping.setShippingAddress(Values.NAME_FIRST, Values.NAME_LAST, Values.ID_EMAIL_QA_TEST, Values.PHONE_NUM, Values.ADDRESS, Values.ADDRESS2, Values.LOC_NEWYORK, Values.LOC_NEWYORK, Values.ZIP_CODE_NY);

		}
	
	
	@Test(enabled= true, priority=0, groups = {"Checkout"},
			description= "Verify 'Use Address for Billing' Checkbox")
	public void coShippingAddressCopyover() throws Exception {
		checkout();

		shipping.matchAddressesShipping_CheckBox.click();
		shipping.continueToShippingMethod_Button.click();	
		shipping.continueToShippingMethod_Button.click();	
		shipping.continueToBillingInfo_Button.click();
		
		BillingModel billingModel = billing.getPaymentInformation();
		Assert.assertEquals(billingModel.getActFname(), Values.NAME_FIRST);	
		Assert.assertEquals(billingModel.getActLname(), Values.NAME_LAST);	
		Assert.assertEquals(billingModel.getActEmail(), Values.ID_EMAIL_QA_TEST);	
		Assert.assertEquals(billingModel.getActPhone(), Values.PHONE_NUM);	
		Assert.assertEquals(billingModel.getActAdd1(), Values.ADDRESS);	
		Assert.assertEquals(billingModel.getActAdd2(), Values.ADDRESS2);	
		Assert.assertEquals(billingModel.getActState(), Values.LOC_NEWYORK);	
		Assert.assertEquals(billingModel.getActCity(), Values.LOC_NEWYORK);	
		Assert.assertEquals(billingModel.getActZipCode(), Values.ZIP_CODE_NY);	
		
	}
	
	@Test(enabled= true, priority=0, groups = {"Checkout"},
			description= "Verify 'Use My Shipping Address' Checkbox")
	public void coBillingAddressCopyOver() throws Exception {
		checkout();
		shipping.continueToShippingMethod_Button.click();	
		shipping.continueToShippingMethod_Button.click();	
		shipping.continueToBillingInfo_Button.click();
		
		billing.matchAddressesBilling_CheckBox.click();
				
		BillingModel billingModel = billing.getPaymentInformation();
		Assert.assertEquals(billingModel.getActFname(), Values.NAME_FIRST);	
		Assert.assertEquals(billingModel.getActLname(), Values.NAME_LAST);	
		Assert.assertEquals(billingModel.getActEmail(), Values.ID_EMAIL_QA_TEST);	
		Assert.assertEquals(billingModel.getActPhone(), Values.PHONE_NUM);	
		Assert.assertEquals(billingModel.getActAdd1(), Values.ADDRESS);	
		Assert.assertEquals(billingModel.getActAdd2(), Values.ADDRESS2);	
		Assert.assertEquals(billingModel.getActState(), Values.LOC_NEWYORK);	
		Assert.assertEquals(billingModel.getActCity(), Values.LOC_NEWYORK);	
		Assert.assertEquals(billingModel.getActZipCode(), Values.ZIP_CODE_NY);	
		
	}




}
		





	
	
	
	
	
	
	


    













	

