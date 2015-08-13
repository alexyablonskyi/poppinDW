package poppin.pages;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {

	WebDriver driver;
	
	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    
	
	
	
	
	/*
     *  RETURNING CUSTOMER SECTION
     */
    
    @FindBy(xpath = "//input[starts-with(@id, 'dwfrm_login_username_')]")
    public WebElement returnCustomerEmail_Field; 
    public void setEmailForReturningCustomer(String email){
    	returnCustomerEmail_Field.clear();
    	returnCustomerEmail_Field.sendKeys(email);
    }
    
    @FindBy(xpath = "//input[@id='dwfrm_login_password']")
    public WebElement returnCustomerPassword_Field;
    public void setPasswordForReturningCustomer(String password){
    	returnCustomerPassword_Field.clear();
    	returnCustomerPassword_Field.sendKeys(password);
    }
    
    @FindBy(xpath = "//button[@name='dwfrm_login_login']")
    public WebElement returnCustomerLogin_Button;    
    public void clickSubmitButtonForReturnCustomer(){
    	returnCustomerLogin_Button.click();
    }

    
    //Get error message for Returning customer 
    @FindBy(xpath = "//form[@id='dwfrm_login']/div")
    public WebElement passwordErrorMessage;
    public String passErrorMsg_Returning(){
    	return passwordErrorMessage.getText();
    }

    @FindBy(xpath = "(//li[@class='required'])[1]")
    public WebElement singleBlankErrorMessage;
    public String firstMissingFieldText(){
    	return singleBlankErrorMessage.getText();
    }
    
    @FindBy(xpath = "(//li[@class='required'])[2]")
    public WebElement doubleBlankErrorMessage;
    public String secondMissingFieldText(){
    	return doubleBlankErrorMessage.getText();
    }
    
    
    /* 
     * NEW CUSTOMER SECTION
     */
	
    //Fields to fill in New Customer
    String randomNumbers = RandomStringUtils.randomNumeric(9);
    String emailForNewIndUser = "PoppinQA" + randomNumbers + "@gmail.com";
    
    public String getRandomEmailForNewInduvidualCustomer(){
    	return emailForNewIndUser;
    }
    
    String emailForNewBusUser = "PoppinQA" + randomNumbers + "@gmail.com";
    
    public String getRandomEmailForNewBusinessCustomer(){
    	return emailForNewBusUser;
    }
    
    String companyForNewUser = "QA Company" + randomNumbers; 
    
    public String getRandomCompanyForNewBusinessCustomer(){
    	return companyForNewUser;
    }
    
    /* 
     * MY ACCOUNT ELEMENTS
     */
    
	public String userNameSignedIn() {
		return driver.findElement(By.xpath("(//a[@class='user-account flyout-trigger level-1 has-children'])[2]")).getText().replaceAll("Hi ", "").replaceAll("!","");
		
	}
    
    @FindBy(xpath = "//a[@title='Logout']")
    public WebElement getSignOutLink;
    
    
    // All fields on New customer section
    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_firstname']")
    public WebElement newCustomerFName_Field;    

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_lastname']")
    public WebElement newCustomerLName_Field;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_email']")
    public WebElement newCustomerEmail_Field;   

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_emailconfirm']")
    public WebElement newCustomerEmailConfirm_Field;  
    
    @FindBy(xpath = "//input[@id='dwfrm_profile_login_password']")
    public WebElement newCustomerPassword_Field;
    
    @FindBy(xpath = "//input[@id='dwfrm_profile_login_passwordconfirm']")
    public WebElement newCustomerPasswordConfirm_Field;
    
    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_addtoemaillist']")
    public WebElement signUpForNewsletter_Checkbox;    

    @FindBy(xpath = "//button[@name='dwfrm_profile_confirm']")
    public WebElement newCustomerSubmit_Button;    

    
    
    //Create new INDIVIDUAL customer
    public void createNewIndividualCustomer(String firstName, String lastName, String emailForNewIndUser, String password){
    	newCustomerFName_Field.sendKeys(firstName);
    	newCustomerLName_Field.sendKeys(lastName);
    	newCustomerEmail_Field.sendKeys(emailForNewIndUser);
    	newCustomerEmailConfirm_Field.sendKeys(emailForNewIndUser);
    	newCustomerPassword_Field.sendKeys(password);
    	newCustomerPasswordConfirm_Field.sendKeys(password);
    	newCustomerSubmit_Button.click();
    }
    

    public void loginAsReturningCustomer(String email,String password){
	    boolean exist = returnCustomerPassword_Field.isDisplayed();
	    if (exist == true){
    	returnCustomerEmail_Field.sendKeys(email);
    	returnCustomerPassword_Field.sendKeys(password);
    	returnCustomerLogin_Button.click();	
	}}
    
    
    
}
