package poppin.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import poppin.base.Base;

public class Global extends Base{
	WebDriver driver;
	
	
	public Global(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Search

	@FindBy(xpath = "//span[@class='icon-pop-utility-search search-button']")
    public WebElement search_Button;
	
	@FindBy(xpath = "//input[@id='query' and @class='search-box form-control']")
    public WebElement search_Field;
	
	
		
	
	/* 
	 * Sign in/out page links
	 */
	
	@FindBy(xpath = "//*[@class='header-account header-flyout hidden-xs hidden-sm left-divider']")
    public WebElement myAccountHover;
	
	@FindBy(xpath = "//*[contains(@class, 'header-account header-flyout hidden-xs hidden-sm left-divider')]//a[@title='Sign In']")  //Using Contains because Active status is dynamic
    public WebElement signInLink;
	
	
	@FindBy(xpath = "//*[contains(@class, 'header-account header-flyout hidden-xs hidden-sm left-divider')]//a[@title='Sign Out']") //Using Contains because Active status is dynamic
    public WebElement signOutLink;
	
	
	
	//Delete
	public String LoginPageX(){
		return "//div[@id='header']/header/div/div/div[2]/div/div/div/ul/li[2]/a/span";
	}
	
	@FindBy(xpath = "(.//a[@class='level-2' and @title='Sign Out'])[1]")
    public WebElement signOutLinkOld;
	
	public String getSignOut(){
		return "//a[@title='Logout']";
	}
	
    public String getSignOutText(){
    	return signOutLinkOld.getText();
    }
    	
	public void clickSignOutLink(){
		signOutLinkOld.click();
	}
	
	
	
	/* 
	 * Registration Links
	 */
	
	@FindBy(xpath = "//li[@class='header-account header-flyout hidden-xs hidden-sm left-divider active']/div/ul/li[2]/a")
    public WebElement registerLink;
	
	public void openRegistrationPage(){
		registerLink.click();
	}
	
	public String registrationLink(){
		return "//div[@id='header']/header/div/div/div[2]/div/div/div/ul/li[2]/div/ul/li[2]/a/span";
	}
	
	public String registrationLink2 = "//div[@id='header']/header/div/div/div[2]/div/div/div/ul/li[2]/div/ul/li[2]/a/span";
	
		
	/*
	 * Slider section
	 */
	
	@FindBy(xpath=".//*[@id='slider-wrapper']")
	WebElement sliderWrapper;
	
	public String getSliderWrapperXpath(){
		return ".//*[@id='slider-wrapper']";
	}

	public void hoverSignIn() throws InterruptedException{
		Actions action = new  Actions(driver);	
		action.moveToElement(myAccountHover).perform();
		Thread.sleep(1000);
		action.moveToElement(signInLink);
		Thread.sleep(1000);
		signInLink.click();;

	}
	
	
	public void hoverSignOut() throws InterruptedException{
		Actions action = new  Actions(driver);	
		action.moveToElement(myAccountHover).perform();
		Thread.sleep(1000);
		action.moveToElement(signOutLink);
		Thread.sleep(1000);
		signOutLink.click();;

	}
	
	
	public void hoverRegister() throws InterruptedException{
		Actions action = new  Actions(driver);	
		action.moveToElement(myAccountHover).perform();
		Thread.sleep(1000);
		action.moveToElement(registerLink);
		Thread.sleep(1000);
		registerLink.click();;

	}
	
	
	public void hoverClick(WebElement topMenu, String subMenu){
		Actions builder = new Actions(driver);
		builder.moveToElement(topMenu).perform();
		driver.findElement(By.xpath(subMenu)).click();
	}

	
	public void userSignOut() throws InterruptedException{
		String acc = "//*[contains(@class, 'header-account header-flyout hidden-xs hidden-sm left-divider')]//a";
		int accountHoverSize = driver.findElements(By.xpath(acc)).size();
		for (int i=1; i<=accountHoverSize; i++){
			boolean signOutExist = driver.findElement(By.xpath("(" + acc + ")[" + i + "]")).getAttribute("title").equals("Sign Out");
			boolean signInExist = driver.findElement(By.xpath("(" + acc + ")[" + i + "]")).getAttribute("title").equals("Sign In");
			if (signOutExist == true){
				hoverSignOut();
				driver.get(baseURL);
			}else if (signInExist == true){
				driver.get(baseURL);
				break;}
		}}
	
	
	
	public void search(String searchWord) throws InterruptedException{
		search_Button.click();
		Thread.sleep(1000);
		search_Field.sendKeys(searchWord);
		Thread.sleep(1000);
		search_Button.click();

	}



}
