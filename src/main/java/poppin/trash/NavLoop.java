package poppin.trash;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import poppin.base.Base;
import poppin.pages.Global;
import poppin.pages.ProductDetailPage;
import poppin.pages.ProductListPage;


public class NavLoop extends Base {
	
	Global global;
	ProductDetailPage pdp;
	ProductListPage sR;


	@Test(enabled= false, priority=0, groups = {"Nav: Category"}, 
			description= "Check all Category Level links and verify pages")
	public void categoryNav() throws Exception {
		global = new Global(driver);
		pdp = new ProductDetailPage(driver);
		
		Actions action = new  Actions(driver);
		int catTotal = driver.findElements(By.xpath("//li[1]/div/div/ul/li")).size();
		
		for (int c=1; c<=catTotal; c++){
			action.moveToElement(driver.findElement(By.xpath("//div[@id='navigation']/nav/ul/li/a"))).perform();  //Hover over "Category" link
			driver.findElement(By.xpath("//div[@id='navigation']/nav/ul/li/a")).click();  //Click "Category" link
			action.moveToElement(driver.findElement(By.xpath("//li[1]/div/div/ul/li["+ c + "]/a"))).perform();
			String expTitle = driver.findElement(By.xpath("//li[1]/div/div/ul/li[" + c + "]/a/span")).getText();
			driver.findElement(By.xpath("//li[1]/div/div/ul/li[" + c + "]/a")).click();
			System.out.println("ACT :" + expTitle);
			System.out.println("EXP : " + pdp.pageCategoryText());
				Assert.assertEquals(pdp.pageCategoryUpperCaseText(), expTitle);
			}
		}
	

	@Test(enabled= false, priority=0, groups = {"Nav: Category"}, 
			description= "Check all Subcategory level links and verify pages")
	public void subCategoryNav() throws Exception {
		global = new Global(driver);
		pdp = new ProductDetailPage(driver);
		
		
		Actions action = new  Actions(driver);
		int catTotal = driver.findElements(By.xpath("//li[1]/div/div/ul/li")).size();
		
		for (int c=1; c<=catTotal; c++){
			int subCatTotal = driver.findElements(By.xpath("//li[1]/div/div/ul/li[" + c + "]/div/ul/li")).size(); //Find total Categories under Link

			for (int sC=1; sC<=subCatTotal; sC++){
				action.moveToElement(driver.findElement(By.xpath("//div[@id='navigation']/nav/ul/li/a"))).perform();  //Hover over "Category" link
				driver.findElement(By.xpath("//div[@id='navigation']/nav/ul/li/a")).click();  //Click "Category" link
				action.moveToElement(driver.findElement(By.xpath("//li[1]/div/div/ul/li["+ c + "]/a"))).perform();
				String expTitle = driver.findElement(By.xpath("//li[1]/div/div/ul/li[" + c + "]/div/ul/li[" + sC + "]/a/span")).getText();
				driver.findElement(By.xpath("//li[1]/div/div/ul/li[" + c + "]/div/ul/li[" + sC + "]/a")).click();
				Assert.assertEquals(pdp.pageCategoryText(), expTitle);
			}
		}}
	
	
	
	@Test(enabled= true, priority=0, groups = {"Color Search"}, 
			description= "Verify all color links navigate to correct pages and that the search term exists in search results page")
	public void colorBar() throws Exception {
		global = new Global(driver);
		sR = new ProductListPage(driver);
		
		for (int i=2; i<=xl.getRowCount("Colors"); i++){
			String sheetName = "Colors";
			driver.findElement(By.xpath("//a[contains(@class, '" + xl.getCellData(sheetName, "navColor", i) + "-swatch')]")).click();
			String actPageTitle = driver.getTitle();
	        Assert.assertEquals("Page title Error: ", actPageTitle, xl.getCellData(sheetName, "pageTitle", i));
	        String resultsWord = xl.getCellData(sheetName, "navColor", i).toUpperCase().replaceAll("-", " ");
	        sR.searchContentVerify(resultsWord);
		}	
		}

}
	






	
	
	
	
	
	


    













	

