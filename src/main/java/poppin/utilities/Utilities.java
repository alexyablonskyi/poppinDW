package poppin.utilities;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import poppin.pages.Global;
import poppin.pages.Login;


public class Utilities {
	
	public static WebDriver driver = null;
	public static Logger log = Logger.getLogger("automationLogs");
	public static ExcelReader xl = new ExcelReader("src/main/data/testData.xlsx");
	

	
	// ---- This method will run firefox profile of Sage----	
	public static void automationProfile() {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fp = profile.getProfile("Automation");
		driver = new FirefoxDriver(fp);
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		maxWindow();
	}


	// ---- This method will close Pop Up Modal----	
	public static void closeModalIfExist() {
	    boolean exist = driver.findElements(By.xpath("//div[@id='ltkmodal-wrapper']")).size()!=0; //If Modal exists
	    if (exist == true){
	    	driver.findElement(By.xpath("//a[@class='ltkmodal-close close-button']")).click();
	    }
	}
	
	// ---- This method will maximize the window ----
	public static void maxWindow() {
		driver.manage().window().maximize();
	}
	
	
	// ---- Click Methods ----
	public static void clickbyXPath(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
	
	
	
	// ---- Mouse Hover Method
	public void hoverMenuClick(WebElement topMenu, WebElement subMenu) throws InterruptedException{
		Actions action = new  Actions(driver);	
		action.moveToElement(topMenu).perform();
		Thread.sleep(1000);
		action.moveToElement(subMenu);
		Thread.sleep(1000);
		subMenu.click();;

	}
	
	
	
	// ---- Wait Methods ----
	public void waitForElementClickableX(WebElement locator){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
		
	public void waitForElementVisibleX(WebElement locator){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	

	
	
	
	//---- Log out User - Reset Script ----
	
	public boolean isElementPresent(By by) {
		try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	}
	
	public void isUserLoggin(){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Global homePage = new Global(driver);
		if(isElementPresent(By.cssSelector(homePage.getSignOut()))){
			homePage.clickSignOutLink();
//			waitForElementVisibleX(homePage.getSliderWrapperXpath());
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else {
			System.out.println("User is already logged out");
		}
	}
	
	
	
	
	
	
	
}