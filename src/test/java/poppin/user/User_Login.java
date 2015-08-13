package poppin.user;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poppin.base.Base;
import poppin.pages.Global;
import poppin.pages.Login;
import poppin.pages.Netsuite;
import poppin.values.Values;




public class User_Login extends Base {

	Login loginPage;
	Global global;
	Netsuite nS;

	@BeforeMethod
	public void pageSetup() throws Exception {
		global = new Global(driver);
		loginPage = new Login(driver);
		closeModalIfExist();
		}
	
	
	//Add Assertion
	@Test(enabled= true, priority=0, groups = {"Login/Creating customer"}, 
			description= "Verify system allows user to log in using existing credentials") 
    public void loginAsReturningCustomer() throws Exception{

		global.hoverSignIn();
		loginPage.loginAsReturningCustomer(Values.ID_EMAIL_QA_TEST, Values.PASS_QA_TEST);
		
		Assert.assertEquals(loginPage.userNameSignedIn(), Values.NAME_FIRST);
		}
	
	//Add Assertion	
	@Test(enabled= true, priority=3, groups = {"Login/Creating customer"}, 
			description= "Verify system allows user to create a new personal account")
    public void createNewIndividualCustomer() throws Exception{

		global.hoverRegister();
		loginPage.createNewIndividualCustomer(Values.NAME_FIRST, Values.NAME_LAST, loginPage.getRandomEmailForNewInduvidualCustomer(), Values.PASS_QA_TEST);
    }

	@Test(enabled= true, priority=1, groups = {"Verifying error messages for RETURNING customer"}, 
    		description= "Verify system error when logging in with incorrect password")
    public void loginUsingIncorrectPassword() throws Exception{

		global.hoverSignIn();
		loginPage.loginAsReturningCustomer(Values.ID_EMAIL_QA_TEST, Values.PASS_INCORRECT);
        
        Assert.assertEquals(loginPage.passErrorMsg_Returning(), "Sorry, this does not match our records. Check your spelling and try again.");
        }

    
    @Test(enabled= true, priority=2, groups = {"Verifying error messages for RETURNING customer"}, 
    		description= "Verify system error when logging in with unregistered email")
    public void loginUsingUnregisteredEmail() throws Exception{

    	global.hoverSignIn();
		loginPage.loginAsReturningCustomer("Poppin123456789@gmail.com", Values.PASS_QA_TEST);
        
        Assert.assertEquals(loginPage.passErrorMsg_Returning(), "Sorry, this does not match our records. Check your spelling and try again.");
        }
    
    @Test(enabled= true, priority=2, groups = {"Verifying error messages for RETURNING customer"}, 
    		description= "Verify system error when logging in with invalid email")
    public void loginUsingInvalidEmail() throws Exception{


		global.hoverSignIn();
		loginPage.loginAsReturningCustomer("Poppin123456789@gmail.com", Values.PASS_QA_TEST);
        
        Assert.assertEquals(loginPage.passErrorMsg_Returning(), "Sorry, this does not match our records. Check your spelling and try again.");
    }
    
    
    @Test(enabled= true, priority=2, groups = {"Verifying error messages for RETURNING customer"}, 
    		description= "Verify system error when logging in with no Password")
    public void loginUsingBlankEmail() throws Exception{

		global.hoverSignIn();
		loginPage.loginAsReturningCustomer("", Values.PASS_QA_TEST);
        
        Assert.assertEquals(loginPage.firstMissingFieldText(), "This value is required.");
    }
	
	
    @Test(enabled= true, priority=2, groups = {"Verifying error messages for RETURNING customer"}, 
    		description= "Verify system error when logging in with no User Id")
    public void loginUsingBlankPassword() throws Exception{

		global.hoverSignIn();
		loginPage.loginAsReturningCustomer(Values.ID_EMAIL_QA_TEST, "");
        
        Assert.assertEquals(loginPage.firstMissingFieldText(), "This value is required.");
    }
	
    
    @Test(enabled= true, priority=2, groups = {"Verifying error messages for RETURNING customer"}, 
    		description= "Verify system error when logging in with no User ID or Password")
    public void loginUsingBlankFields() throws Exception{

		global.hoverSignIn();
		loginPage.loginAsReturningCustomer("", "");
        
        Assert.assertEquals(loginPage.firstMissingFieldText(), "This value is required.");
        Assert.assertEquals(loginPage.secondMissingFieldText(), "This value is required.");
    }
    
  
}



/*
Create Customer with Company Name
Create Customer No Selection
Create New Individual Customer
Create New Business Customer
Create custoer existing email

Login with invalid email

New Customer field validation
New Customer Blank field validation

Forgot password success
Forgot password failure
*/
