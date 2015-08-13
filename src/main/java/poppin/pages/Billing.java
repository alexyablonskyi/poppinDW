package poppin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import poppin.pages.model.BillingModel;
import poppin.utilities.Utilities;

public class Billing extends Utilities {

	WebDriver driver;

	public Billing(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	/*
     *  Checkout Elements
     */
		
    @FindBy(xpath = "//button[@name='dwfrm_billing_save']")
    public WebElement continueToReviewOrder_Button; 
	public void clickContinueToReviewOrderButton(){
		waitForElementVisibleX(continueToReviewOrder_Button);
		continueToReviewOrder_Button.click();
		continueToReviewOrder_Button.click();
	}

    @FindBy(xpath = "//div[@class='checkout-order-totals']//button[@name='submit']")
    public WebElement placeOrder_Button; 
	public void clickPlaceOrderButton(){
		waitForElementVisibleX(placeOrder_Button);
		placeOrder_Button.click();
	}
	
	
	/*
	 * Billing Elements
	 */

	@FindBy(xpath = "//input[@name='dwfrm_billing_billingAddress_useShippingAddress']")
	public WebElement matchAddressesBilling_CheckBox;

	
	@FindBy(xpath = "//input[@id='dwfrm_billing_billingAddress_addressFields_firstName']")
	public WebElement billingFName_Field;
	public void setBillingFName(String fName) {
		billingFName_Field.clear();
		billingFName_Field.sendKeys(fName);
	}

	@FindBy(xpath = "//input[@id='dwfrm_billing_billingAddress_addressFields_lastName']")
	public WebElement billingLName_Field;
	public void setBillingLName(String lName) {
		billingLName_Field.clear();
		billingLName_Field.sendKeys(lName);
	}

	@FindBy(xpath = "//input[@id='dwfrm_billing_billingAddress_email_emailAddress']")
	public WebElement billingEmail_Field;
	public void setBillingEmail(String eMail) {
		billingEmail_Field.clear();
		billingEmail_Field.sendKeys(eMail);
	}
	
	@FindBy(xpath = "//input[@id='dwfrm_billing_billingAddress_addressFields_phone']")
	public WebElement billingPhone_Field;
	public void setBillingPhone(String phone) {
		billingPhone_Field.clear();
		billingPhone_Field.sendKeys(phone);
	}
	
	@FindBy(xpath = "//input[@id='dwfrm_billing_billingAddress_addressFields_address1']")
	public WebElement billingAddress1_Field;
	public void setBillingAddress1(String address1) {
		billingAddress1_Field.clear();
		billingAddress1_Field.sendKeys(address1);
	}

	@FindBy(xpath = "//input[@id='dwfrm_billing_billingAddress_addressFields_address2']")
	public WebElement billingAddress2_Field;
	public void setBillingAddress2(String address2) {
		billingAddress2_Field.clear();
		billingAddress2_Field.sendKeys(address2);
	}


	@FindBy(xpath = "//div[@class='selectric']")
	public WebElement billingState_DD;
	public void setBillingState(String state) {
		billingState_DD.sendKeys(state);
	}

	
	@FindBy(xpath = "//input[@id='dwfrm_billing_billingAddress_addressFields_city']")
	public WebElement billingCity_Field;
	public void setBillingCity(String city) {
		billingCity_Field.clear();
		billingCity_Field.sendKeys(city);
	}

	@FindBy(xpath = "//input[@id='dwfrm_billing_billingAddress_addressFields_postal']")
	public WebElement billingZipCode_Field;
	public void setBillingZipCode(String zipCode) {
		billingZipCode_Field.clear();
		billingZipCode_Field.sendKeys(zipCode);
		billingZipCode_Field.sendKeys(Keys.TAB);
	
	}


	
	
	/*
	 * Gift Certificates and Coupon/Discount Codes
	 */

	@FindBy(xpath = "//input[@id='dwfrm_billing_couponCode']")
	public WebElement couponCode_Field;

	@FindBy(xpath = "//input[@id='add-coupon']")
	public WebElement applyCoupon_Button;

	@FindBy(xpath = "//input[@id='dwfrm_billing_giftCertCode']")
	public WebElement giftCertificate_Field;

	@FindBy(xpath = "//input[@id='add-giftcert']")
	public WebElement applyCertificate_Button;

	@FindBy(xpath = "//input[@id='check-giftcert']")
	public WebElement checkBalance_Link;


	
	/*
	 * Credit Card Info
	 */

	@FindBy(xpath = "//input[@id='dwfrm_billing_paymentMethods_creditCard_owner']")
	public WebElement ccFullName_Field;
	public void setCCFullName(String ccName) {
		ccFullName_Field.clear();
		ccFullName_Field.sendKeys(ccName);
	}
	
    @FindBy(xpath = "//select[@name='dwfrm_billing_paymentMethods_creditCard_type']")
    public WebElement ccType_DD;
	public void setCCType(String cardType){
		ccType_DD.sendKeys(cardType);
		 }	

	@FindBy(xpath = "//input[@id='dwfrm_billing_paymentMethods_creditCard_number']")
	public WebElement ccNumber_Field;
	public void setCCNumber(String ccNum) {
		ccNumber_Field.clear();
		ccNumber_Field.sendKeys(ccNum);
	}

    @FindBy(xpath = "//select[@name='dwfrm_billing_paymentMethods_creditCard_month']")
    public WebElement ccMonth_DD;
	public void setCCMonth(String expMonth){
		ccMonth_DD.sendKeys(expMonth);
		 }
	
    @FindBy(xpath = "//select[@name='dwfrm_billing_paymentMethods_creditCard_year']")
    public WebElement ccYear_DD;
	public void setCCYear(String expYear){
		ccYear_DD.sendKeys(expYear);
		 }
	
	@FindBy(xpath = "//input[@id='dwfrm_billing_paymentMethods_creditCard_cvn']")
	public WebElement ccSecCode_Field;
	public void setCCSecCode(String ccSec) {
		ccSecCode_Field.clear();
		ccSecCode_Field.sendKeys(ccSec);
		ccSecCode_Field.sendKeys(Keys.TAB);		
	}
	
	@FindBy(xpath = ".//*[@id='primary']//h3")
	public WebElement ordConfirmMSG;
	public String ordConfMSGText(){
		return ordConfirmMSG.getText();
	}
	
	/*
	 * Methods
	 */
	
	public void setCouponCode(String cCode) {
		couponCode_Field.clear();
		couponCode_Field.sendKeys(cCode);
		couponCode_Field.sendKeys(Keys.TAB);
		applyCoupon_Button.click();
	}
	
	public void setGiftCertificate(String gcCode) {
		couponCode_Field.clear();
		couponCode_Field.sendKeys(gcCode);
		couponCode_Field.sendKeys(Keys.TAB);
		applyCertificate_Button.click();
	}

	public void checkGiftCertificateBalance(String gcCode) {
		couponCode_Field.clear();
		couponCode_Field.sendKeys(gcCode);
		couponCode_Field.sendKeys(Keys.TAB);
		checkBalance_Link.click();
	}

    public void setBillingAddress(String firstName, String lastName, String eMail, String phone, String address1, String address2, String state, String city, String zipCode) throws InterruptedException{
    	setBillingFName(firstName);
    	setBillingLName(lastName);
    	setBillingEmail(eMail);
    	setBillingPhone(phone);
    	setBillingAddress1(address1);
    	setBillingAddress2(address2);
    	setBillingState(state);
    	setBillingCity(city);
    	setBillingZipCode(zipCode);
    }
	
	public void setPaymentInformation (String ccName, String ccNum, String cardType, String expMonth, String expYear, String ccSec){
		setCCFullName(ccName);
		setCCNumber(ccNum);
		setCCType(cardType);
		setCCMonth(expMonth);
		setCCYear(expYear);
		setCCSecCode(ccSec);
	}
	
	
	
	
	
	

	public BillingModel getPaymentInformation (){
		 Select stateDD = new Select(billingState_DD); //use this method in order to get the text value (New York) for DD because value=NY on dropdown
		 
		 String actFname = billingFName_Field.getAttribute("value");
		 String actLname = billingLName_Field.getAttribute("value");
		 String actEmail = billingEmail_Field.getAttribute("value");
		 String actPhone = billingPhone_Field.getAttribute("value");
		 String actAdd1 = billingAddress1_Field.getAttribute("value");
		 String actAdd2 = billingAddress2_Field.getAttribute("value");
		 String actState = stateDD.getFirstSelectedOption().getText();		 
		 String actCity = billingCity_Field.getAttribute("value");
		 String actZipCode = billingZipCode_Field.getAttribute("value");
			BillingModel billingValues = new BillingModel(actFname, actLname, actEmail, actPhone, actAdd1, actAdd2, actState, actCity, actZipCode);
		return billingValues;
	}
	
	
	
}
