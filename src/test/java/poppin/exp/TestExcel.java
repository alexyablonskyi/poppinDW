package poppin.exp;

import org.testng.Assert;
import org.testng.annotations.Test;

import poppin.base.Base;
import poppin.utilities.ExcelReader;




public class TestExcel extends Base {

	@Test(enabled= true) 
	public static void main1 (){
	ExcelReader excel = new ExcelReader ("C:/Users/Sage Ashique/workspace/PoppinWebShop/src/main/data/testData.xlsx");
		
	for (int i = 2; i < 4; i++){
		String sheetName = "colors";
		driver.get(excel.getCellData(sheetName, "URL", i));
		String actPageTitle = driver.getTitle();
		System.out.println("-------" + actPageTitle);
		System.out.println("+++++++" + excel.getCellData(sheetName, "pageTitle", i));
        Assert.assertEquals(actPageTitle, excel.getCellData(sheetName, "pageTitle", i));
	}

	}
	
	
	@Test(enabled= false) 
	public static void main2 (){
	ExcelReader excel = new ExcelReader ("C:/Users/Sage Ashique/workspace/PoppinWebShop/src/main/data/testData.xlsx");

		driver.get("www.google.com");
	for (int i = 2; i < 3; i++){
		String sheetName = "color";
		driver.get(excel.getCellData(sheetName, "URL", i));
		String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, excel.getCellData(sheetName, "pageTitle", i));
	}
	
}}
