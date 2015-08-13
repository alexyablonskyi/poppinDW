package poppin.trash;

import poppin.pages.Global;
import poppin.pages.ProductListPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import poppin.base.Base;


public class Nav_ColorBar_Test extends Base {
	
	Global global;
	ProductListPage plp;

	
	
	@Test(enabled= true, priority=0, groups = {"Color Search"}, 
			description= "Verify all color links navigate to correct pages and that the search term exists in search results page")
	public void colorNav() throws Exception {
		global = new Global(driver);
		plp = new ProductListPage(driver);
		
		for (int i=2; i<=xl.getRowCount("Colors"); i++){
			String sheetName = "Colors";
			driver.findElement(By.xpath("//a[contains(@class, '" + xl.getCellData(sheetName, "navColor", i) + "-swatch')]")).click();
			String actPageTitle = driver.getTitle();
	        Assert.assertEquals("Page title Error: ", actPageTitle, xl.getCellData(sheetName, "pageTitle", i));
	        String resultsWord = xl.getCellData(sheetName, "navColor", i).toUpperCase().replaceAll("-", " ");
	        plp.searchContentVerify(resultsWord);
		}
		
		

	}
		}





	
	
	
	
	
	
	


    













	

