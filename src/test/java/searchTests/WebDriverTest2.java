package searchTests;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.agiletestware.bumblebee.annotations.BooleanValue;
import com.agiletestware.bumblebee.annotations.Bumblebee;
import com.agiletestware.bumblebee.annotations.BumblebeeTestStep;

@Bumblebee(testplan = "Subject\\webdriver", testlab = "Root\\webdriver", testset = "class annotations")
public class WebDriverTest2 {

	    private WebDriver driver;

	    @BeforeClass
	    public static void beforeClass() {
	        System.setProperty("webdriver.chrome.driver", new File("chromedriver.exe").getAbsolutePath());
	    }

	    @BeforeTest
	    public void setUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Projects2\\Drivers\\chromedriver.exe");
			this.driver = new ChromeDriver();
	    }

	    @Bumblebee(almid=24, description = "test one description")@Test(priority = 1)
	    public void testOne() {
	        driver.get("http:\\agiletestware.com");
	        Assert.assertEquals("Agiletestware - Software for QA and Development Tools", driver.getTitle());
	    }

	    @Test(priority = 2)
	    public void testTwo() {
	        driver.get("http:\\agiletestware.com");
	        Assert.assertEquals("Something wrong", driver.getTitle());
	    }
	    
	    @Test(enabled = false)
	    public void ignoredTest() {
	        driver.get("http:\\agiletestware.com");
	    }

	    @Bumblebee(almid=26, description = "test three description") @Test(priority = 3)
	    public void testThree() {
	        throw new RuntimeException("You shall not pass!!!");
	    }

	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
	    
	    
}
