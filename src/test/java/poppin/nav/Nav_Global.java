package poppin.nav;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;












import poppin.base.Base;
import poppin.pages.Global;
import poppin.pages.ProductDetailPage;
import poppin.pages.ProductListPage;


public class Nav_Global extends Base {
	
	Global global;
	ProductDetailPage pdp;
	ProductListPage plp;
	Actions action ;
	
	@BeforeMethod
	public void pageSetup() throws Exception {
		global = new Global(driver);
		pdp = new ProductDetailPage(driver);
		plp = new ProductListPage(driver);
		action = new  Actions(driver);
		closeModalIfExist();
		}
	
	

	@Test(enabled= false, priority=0, groups = {"Nav: Category Flyout"}, // Linked Pages require update from ecommerce
			description= "Check all Category Level links on global nav and verify pages")
	public void navCategory() throws Exception {
		
		int catTotal = driver.findElements(By.xpath("//li[1]/div/div/ul/li")).size(); //Find Total Categories
		for (int c=1; c<=catTotal; c++){
			action.moveToElement(driver.findElement(By.xpath("//div[@id='navigation']/nav/ul/li[1]/a"))).perform();  //Hover over "Category" link
			driver.findElement(By.xpath("//div[@id='navigation']/nav/ul/li[1]/a")).click();  //Click "Category" link
			action.moveToElement(driver.findElement(By.xpath("//li[1]/div/div/ul/li["+ c + "]/a"))).perform();
			String keyWord = driver.findElement(By.xpath("//li[1]/div/div/ul/li[" + c + "]/a/span")).getText();
			driver.findElement(By.xpath("//li[1]/div/div/ul/li[" + c + "]/a")).click();
			System.out.println("ACT :" + keyWord);
			System.out.println("EXP : " + pdp.pageCategoryText());
				Assert.assertEquals(pdp.pageCategoryUpperCaseText(), keyWord);
			}
		}
	

	@Test(enabled= false, priority=0, groups = {"Nav: Category Flyout"}, 
			description= "Check all Subcategory level links on global nav and verify pages")
	public void navSubCategory() throws Exception {
			
		int catTotal = driver.findElements(By.xpath("//li[1]/div/div/ul/li")).size(); //Find Total Categories
		for (int c=1; c<=catTotal; c++){
			int subCatTotal = driver.findElements(By.xpath("//li[1]/div/div/ul/li[" + c + "]/div/ul/li")).size(); //Find total SubCategories 

			for (int sC=1; sC<=subCatTotal; sC++){
				action.moveToElement(driver.findElement(By.xpath("//div[@id='navigation']/nav/ul/li[1]/a"))).perform();  //Hover over SubCategory link
				driver.findElement(By.xpath("//div[@id='navigation']/nav/ul/li[1]/a")).click();  //Click SubCategory link
				action.moveToElement(driver.findElement(By.xpath("//li[1]/div/div/ul/li["+ c + "]/a"))).perform();
				String keyWord = driver.findElement(By.xpath("//li[1]/div/div/ul/li[" + c + "]/div/ul/li[" + sC + "]/a/span")).getText();
				System.out.println(keyWord);
				driver.findElement(By.xpath("//li[1]/div/div/ul/li[" + c + "]/div/ul/li[" + sC + "]/a")).click();
				Assert.assertEquals(pdp.pageCategoryText(), keyWord);
			}
		}}
	
	
	
	
	@Test(enabled= false, priority=0, groups = {"Nav: Color Flyout"}, 
			description= "Check all Color links on global nav and verify pages")
	public void navColorFlyout() throws Exception {
		
		int catTotal = driver.findElements(By.xpath("//li[2]/div/div/ul/li")).size();		
		for (int c=1; c<=catTotal; c++){
			action.moveToElement(driver.findElement(By.xpath("//div[@id='navigation']/nav/ul/li[2]/a"))).perform();  //Hover over "Color" Flyout Link
			driver.findElement(By.xpath("//div[@id='navigation']/nav/ul/li[2]/a")).click();  //Click "Color" Flyout Link
			action.moveToElement(driver.findElement(By.xpath("//li[2]/div/div/ul/li["+ c + "]/a"))).perform();
			String keyWord = driver.findElement(By.xpath("//li[2]/div/div/ul/li[" + c + "]/a/span")).getText().toUpperCase();
			driver.findElement(By.xpath("//li[2]/div/div/ul/li[" + c + "]/a")).click();
			Assert.assertEquals(pdp.pageCategoryUpperCaseText(), keyWord);
			plp.searchContentVerify(keyWord);
					
			}
		}
	
	
	@Test(enabled= false, priority=0, groups = {"Global Nav: ColorBar"}, 
			description= "Check all Color bar buttons and verify pages")
	public void navColorBar() throws Exception {
		
		int colorTotal = driver.findElements(By.xpath("//div[2]/div/div[2]/ul/li")).size();
		for (int c=1; c<=colorTotal; c++){
			
			String expColor = driver.findElement(By.xpath("//div[2]/div/div[2]/ul/li[" + c + "]/a")).getAttribute("title").toUpperCase();
			driver.findElement(By.xpath("//div[2]/div/div[2]/ul/li[" + c + "]/a")).click();  //Click Color button 
			plp.searchContentVerify(expColor);
			
			}
	
	
	}
}
	






	
	
	
	
	
	


    













	

