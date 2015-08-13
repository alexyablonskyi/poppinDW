package poppin.nav;

import poppin.pages.Global;
import poppin.pages.ProductListPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poppin.base.Base;


public class Nav_Search extends Base {
	
	Global global;
	ProductListPage plp;
	
	@BeforeMethod
	public void pageSetup() throws Exception {
		global = new Global(driver);
		plp = new ProductListPage(driver);
		closeModalIfExist();
		}
	
	
	
	@Test(enabled= true, priority=0, groups = {"Nav Search"}, 
			description= "Verify user is able to search using search bar and that the appropriate page laods")
	public void searchTest() throws Exception {

		for (int i=2; i<=xl.getRowCount("Search"); i++){
			String sheetName = "Search";
			global.search(xl.getCellData(sheetName, "SearchWords", i));
			String resultsWord = xl.getCellData(sheetName, "ResultWords", i).toUpperCase();
			plp.searchContentVerify(resultsWord);
		}
		
		

	}
		}





	
	
	
	
	
	
	


    













	

