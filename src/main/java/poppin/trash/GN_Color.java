package poppin.trash;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import poppin.base.Base;
import poppin.pages.Global;
import poppin.pages.Login;




public class GN_Color extends Base {

	Login loginPage;
	Global homePage;

	//passed
	@Test(enabled= true, priority=0, groups = {"Login/Creating customer"}, 
			description= "Data Capture") 
    public void loginAsReturningCustomer() throws Exception{
		homePage = new Global(driver);
		List <WebElement> colors = driver.findElements(By.xpath(("//ul[@class='header-row-content color-swatches list-inline clearfix']/li/a")));

		for (int i=0; i<colors.size(); i++){
			System.out.println(colors.get(i).getAttribute("class"));
			xl.setCellData("Test", "Colors", i+2, colors.get(i).getAttribute("class"));
		}

    }

}