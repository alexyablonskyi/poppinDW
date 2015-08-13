package poppin.pages;


import org.testng.Assert;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import poppin.utilities.Utilities;
import poppin.values.Values;


public class Netsuite extends Utilities {

	WebDriver driver;
	
	public Netsuite(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    
	

	
	/*
     *  Sign In Elements
     */
	
    @FindBy(xpath = "//input[@id='userName']")
    public WebElement nsUserName_Field; 
    
    @FindBy(xpath = "//input[@type='password']")
    public WebElement nsPassword_Field; 
    
    @FindBy(xpath = "//input[@class='submitButton']")
    public WebElement nsSignIn_Button; 

    
  

	/*
     *  Account Elements
     */
    
    @FindBy(xpath = "//input[@id='_searchstring']")
    public WebElement nsSearch_Field; 
    
    @FindBy(xpath = "(//tr[starts-with(@id, 'row')][last()]/td/a[2])[1]")
    public WebElement nsViewNewestProfile;
    
    @FindBy(xpath = "(//tr[3]/td/div/span[2])[1]")
    public WebElement nsCustomerName;
    
    @FindBy(xpath = "(//tr[5]/td/div/span[2]/span)[1]")
    public WebElement nSCustomerSegment;
    
    @FindBy(xpath = "(//tr[5]/td/div/span[2])[1]")
    public WebElement nSCustomerCompany;
    
    

	/*
     *   Methods
     */
    
    @FindBy(xpath ="//input[@name='answer']")
    public WebElement nSSecurityAnswer_Field;
    public void setNSAnswer(){
    	nSSecurityAnswer_Field.sendKeys("Naser");
    	nSSecurityAnswer_Field.sendKeys(Keys.ENTER);
    }
    
    
    public void netSuiteSignIn(){
    	driver.get(Values.NETSUITE_COM);
    	nsUserName_Field.sendKeys(Values.ID_EMAIL_NETSUITE);
    	nsPassword_Field.sendKeys(Values.PASS_NETSUITE);
    	nsSignIn_Button.click();
    	boolean secAnswer = nSSecurityAnswer_Field.isDisplayed();
		if (secAnswer == true) {
			setNSAnswer();	}
	}
    
    public void netSuiteCustomerSearch(String eMail){
    	nsSearch_Field.sendKeys(eMail);
    	nsSearch_Field.sendKeys(Keys.ENTER);
    	nsViewNewestProfile.click();
    }
    
    public void verifyCustomer(String cName) throws Exception{
		String nSCustomerField = nsCustomerName.getText();
		Assert.assertTrue(nSCustomerField.contains(cName));		
    }

    public void verifySegment(String cSegment) throws Exception{
    	String nSSegmentField = nSCustomerSegment.getText();
    	Assert.assertTrue(nSSegmentField.contains(cSegment));		
    }
    
    public void verifyCompany(String cCompany) throws Exception{
    	String nSCompanyField = nSCustomerCompany.getText();
    	Assert.assertTrue(nSCompanyField.contains(cCompany));		
    }
    

		
}

        
    
    
    
    
    

