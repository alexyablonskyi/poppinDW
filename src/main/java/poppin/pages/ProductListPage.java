package poppin.pages;


import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductListPage {

	WebDriver driver;
	
	public ProductListPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    
	
	
	
	
	/*
     *  Search Items
     */
    
    @FindBy(xpath = "//input[starts-with(@id, 'dwfrm_login_username_')]")
    WebElement emailFieldForReturnCustomer; 

    public void chooseSearchItem(String itemNum) {
		driver.findElement(By.xpath("//ul[@id='search-result-items']/li["+ itemNum +"]/div[3]/a")).click();
	}
    

    
	/*
     *  Search Items
     */
    public void searchContentVerify(String searchWord){
	String allResultsContent = "";
	List<WebElement> resultsContent = driver.findElements(By.className("search-result-content"));
	for (WebElement eachElement:resultsContent){  //eacheElement represents each element from within the fullList	
		allResultsContent = allResultsContent + " " + eachElement.getText().toUpperCase();  //Will loop around and keep adding to allItems
	}	
	Assert.assertThat("Search Word Not Found on results Page: ", allResultsContent, CoreMatchers.containsString(searchWord));	
    }
    
    
    
    
}
