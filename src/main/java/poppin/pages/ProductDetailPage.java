package poppin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import poppin.utilities.Utilities;

public class ProductDetailPage extends Utilities {

	WebDriver driver;

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	/*
     *  Left Rail
     */
		
    @FindBy(xpath = "//div[@id='secondary']/div/h4")
    public WebElement pageCategory; 
	public String pageCategoryText(){
		return pageCategory.getText();
	}
	public String pageCategoryUpperCaseText(){
		return pageCategory.getText().toUpperCase();
	}	

	@FindBy(xpath = "//*[@id='secondary']/div[2]/div[contains(@class, 'price')]/h4")
	public WebElement refineByPrice;
	
	@FindBy(xpath = "//*[@id='secondary']/div[2]/div[contains(@class, 'type')]")
	public WebElement refineByType;
	
	@FindBy(xpath = "//*[@id='secondary']/div[2]/div[contains(@class, 'numberOfDrawers')]")
	public WebElement refineByNoOfDrawers;
	
	@FindBy(xpath = "//*[@id='secondary']/div[2]/div[contains(@class, 'color')]")
	public WebElement refineByColor;
	
	@FindBy(xpath = "//*[@id='secondary']/div[2]/div[contains(@class, 'option')]")
	public WebElement refineByOption;
	

	public void refineBy(String keyWord){
		//Method to allow user to open side rail refinement option via name
		keyWord = keyWord.toLowerCase();
		WebElement refineLocation = driver.findElement(By.xpath("//*[@id='secondary']/div[2]/div[contains(@class, '" + keyWord + "')]/h4/span"));
		refineLocation.click();
		}
	
}
