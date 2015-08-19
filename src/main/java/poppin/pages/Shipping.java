package poppin.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import poppin.utilities.Utilities;
import poppin.values.ShippingNames;


public class Shipping extends Utilities {

	WebDriver driver;
	
	public Shipping(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    
	

	
	/*
     *  Checkout Elements
     */
	
    @FindBy(xpath = "//a[@title='View Cart']")
    public WebElement miniCart_Button; 
	public void clickMiniCartButton(){
		waitForElementClickableX(miniCart_Button);
		miniCart_Button.click();
	}
    
    @FindBy(xpath = "//button[@id='add-to-cart']")
    public WebElement addToCart_Button; 
	public void clickAddToCartButton(){
		waitForElementVisibleX(addToCart_Button);
		addToCart_Button.click();
	}

    @FindBy(xpath = "//button[@name='dwfrm_cart_checkoutCart']")
    public WebElement checkout_Button; 
	public void clickCheckoutButton(){
		waitForElementVisibleX(checkout_Button);
		checkout_Button.click();		
	}

	
	/*
     *  Shipping Elements
     */
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']")
    public WebElement shippingFName_Field; 
    public void setShippingFName(String fName){
    	shippingFName_Field.clear();
    	shippingFName_Field.sendKeys(fName);
    }
    
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_lastName']")
    public WebElement shippingLName_Field;
    public void setShippingLName(String lName){
    	shippingLName_Field.clear();
    	shippingLName_Field.sendKeys(lName);
    }
    
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_email_emailAddress']")
    public WebElement shippingEmail_Field;
    public void setShippingEmail(String eMail){
    	shippingEmail_Field.clear();
    	shippingEmail_Field.sendKeys(eMail);
    }
    
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_phone']")
    public WebElement shippingPhone_Field;
    public void setShippingPhone(String phone){
    	shippingPhone_Field.clear();
    	shippingPhone_Field.sendKeys(phone);
    }
    
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address1']")
    public WebElement shippingAddress1_Field;
    public void setShippingAddress1(String address1){
    	shippingAddress1_Field.clear();
    	shippingAddress1_Field.sendKeys(address1);
    }
    
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address2']")
    public WebElement shippingAddress2_Field;
    public void setShippingAddress2(String address2){
    	shippingAddress2_Field.clear();
    	shippingAddress2_Field.sendKeys(address2);
    }        
    
    @FindBy(xpath = "(.//*[@class='button icon-pop-arrow-down'])[3]")
    public WebElement shippingState_DD;
    
	/*
    public void setShippingState(String state){
		shippingState_DD.sendKeys(state);
		   //select.deselectAll();
	}
	*/
    /*
	public void setShippingState(String state){
		Select dropdown = new Select(driver.findElement(By.id("(.//div[@class='selectric'])[3]")));
		dropdown.selectByValue(state);
	}
    */
  
    
    public void selectStateForShipping(String state){
    	driver.findElement(By.xpath(".//li[contains(text(), '"+state+"')]")).click();
    }
    
    
	public void setShippingState(String state) throws InterruptedException {
		shippingState_DD.click();
		Thread.sleep(500);
		selectStateForShipping(state);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_city']")
    public WebElement shippingCity_Field;
    public void setShippingCity(String city){
    	shippingCity_Field.clear();
    	shippingCity_Field.sendKeys(city);
    }
    
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_postal']")
    public WebElement shippingZipCode_Field;
    public void setShippingZipCode(String zipCode){
    	shippingZipCode_Field.clear();
    	shippingZipCode_Field.sendKeys(zipCode);
    	shippingZipCode_Field.sendKeys(Keys.TAB);
    }
    
	@FindBy(xpath = "//input[@name='dwfrm_singleshipping_shippingAddress_useAsBillingAddress']")
	public WebElement matchAddressesShipping_CheckBox;
    
    @FindBy(xpath = "//button[@name='dwfrm_singleshipping_shippingAddress_save']")
    public WebElement continueToShippingMethod_Button; 
/*	public void clickShippingAddressComplete() throws InterruptedException{
		waitForElementVisibleX(continueToShippingMethod_Button);
		Thread.sleep(1500);
		continueToShippingMethod_Button.click();		
		continueToShippingMethod_Button.click();		
	}*/

        
	/*
     *   Shipping Methods
     */ 

    @FindBy(xpath = "//a[@class='dd-selected']")
    public WebElement shippingMethod_DD;
    
    @FindBy(xpath = "//button[@name='dwfrm_shippingmethodselect_continue']")
    public WebElement continueToBillingInfo_Button;
    
  
    
	/*
     *   Methods
     */
    
    public void setShippingAddress(String firstName, String lastName, String eMail, String phone, String address1, String address2, String state, String city, String zipCode) throws InterruptedException{
    	setShippingFName(firstName);
    	setShippingLName(lastName);
    	setShippingEmail(eMail);
    	setShippingPhone(phone);
    	setShippingAddress1(address1);
    	setShippingAddress2(address2);
    	setShippingState(state);
    	setShippingCity(city);
    	setShippingZipCode(zipCode);
    	
    }
	
    public void setShippingMethod(ShippingNames i){
    	shippingMethod_DD.click();
    	driver.findElement(By.xpath("(//a[starts-with(@class, 'dd-option')])[" + i.getValue() + "]")).click();
    	continueToBillingInfo_Button.click();
    	}
    
    
    
    
    
}
