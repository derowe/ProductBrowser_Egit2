package utilities;

import baseClass.TestBase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import pages.HomePage;

public class ProductBrowserUtil extends TestBase{

	
	// ProductBrowser specific Utilities
	
	/* ################################################################
	 * Function Name: Login
	 * Description: Firefox Browser only - enters login credentials
	 * ##################################################################
	 */
	public static void Login ( String userid, String password) throws Throwable {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(userid + Keys.TAB.toString() + password);
		alert.accept();
		Thread.sleep(5000);
	}
	
	/* ################################################################
	 * Function Name: SetLanguage
	 * Description: Sets the desired language.  Country is determined by
	 *                   AD account country
	 * ##################################################################
	 */
	public static void SetLanguage(HomePage homePage, String language) throws InterruptedException {
		homePage.input_salesorg_langButton();
		Thread.sleep(2000);
		//homePage.input_language(prop.getProperty("language"));
		homePage.input_language(language);
		Thread.sleep(2000);	 
	}
	
}
