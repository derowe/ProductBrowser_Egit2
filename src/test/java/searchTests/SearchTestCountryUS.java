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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import baseClass.TestBase;
import utilities.TestUtil;
import utilities.ExcelUtil;
import utilities.ProductBrowserUtil;
import utilities.Excel_Reader;
import pages.HomePage;

import com.agiletestware.bumblebee.annotations.BooleanValue;
import com.agiletestware.bumblebee.annotations.Bumblebee;

@Bumblebee(testplan = "Subject\\webdriver", testlab = "Root\\webdriver", testset = "class annotations")
public class SearchTestCountryUS extends TestBase {
	
	// LoginPage loginPage;
	HomePage  homePage;
	TestUtil testUtil;
	ProductBrowserUtil  pbUtil;
	Excel_Reader excelReader;
	public WebDriverWait wait;
	
	public SearchTestCountryUS()
	{
		super();
	}

	/*  From Template - renamed setUp()
	@BeforeClass
	public void beforeClass() {
		
	}
	*/
	
	// Use BeforeMethod to open browser for each test case. 
	// Use BeforeClass if want to open browser only 1x at beginning of class
	@BeforeMethod
	public void setUp() throws Throwable {
		// Sets the driver
		Initialization();
		
		// wait = new WebDriverWait(driver, 10);	
        homePage = new HomePage(driver);
		testUtil = new TestUtil();		
		wait = new WebDriverWait(driver, 10);	
	
	    // Login (Firefox only), other browsers uses user AD credentials automatically
		String browserName = prop.getProperty("browser");
	    if (browserName.equals("Firefox")) {
			String userid = prop.getProperty("userid_CountryUS");
			String password = prop.getProperty("password_CountryUS");
			ProductBrowserUtil.Login(userid, password);
		} // Firefox
	    // Set the Language
	    Thread.sleep(5000);
	    String language = prop.getProperty("language_CountryUS");
	    ProductBrowserUtil.SetLanguage(homePage,language);	
	}




	// Use AfterMethod when want to close browser after each test case
        // Screen snapshot works with AfterMethod not AfterClass
	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException {		
	  
	    if (result.getStatus() == ITestResult.FAILURE) {
	  
		   testUtil.TakeScreenshot(result.getName());
	   }  
		
	//  Do not close the browser after each test.  Do it after the class
	 // driver.quit();
	 //  Unncomment to close at end of each test
	 driver.close();
	 Thread.sleep(2000);
	}
	
	// Only use if want to open browser 1x 
	/*
	@AfterClass
	public void afterClass() throws InterruptedException {		
	 driver.close();
	 Thread.sleep(1000);
	}
	*/
	
	
	/*
	@DataProvider
	public Object[][] getSearchDetailsData() {
		
	   Object data[][] =ExcelUtil.getTestData("SearchDetails_US");
	   return data;
	}
	

	@Test(dataProvider = "getSearchDetailsData")
	public void SearchDetails_US (String username, String password, String language, String searchText, String partNumber,
			String description, String 	longDescription, String packingUnit,
			String listPrice, String stockPrice, String	weight) throws Throwable {
		    
			Thread.sleep(5000);
		    //  homePage.input_searchBox(getCellData("SearchTest", "SearchText", 3));
			homePage.input_searchBox(searchText);
			Thread.sleep(5000);
			homePage.input_searchButton();
			Thread.sleep(10000);
			homePage.input_productButton();
			Thread.sleep(5000);
				
			// Assertions
			// Verify correct PartNumber returned
			System.out.println("Asserting on " + partNumber);
			homePage.field_partNumber(partNumber);
			Thread.sleep(2000);			
				
			// Verify correct Part Description returned
			homePage.field_description(description);
			Thread.sleep(1000);	
			
			// Verify correct Long Description returned
			homePage.field_long_description(longDescription);
			Thread.sleep(1000);	
				
			// Verify correct Packing Unit  returned
			homePage.field_packing_unit(packingUnit);
			Thread.sleep(1000);	
				
			// Verify correct List Price returned
			homePage.field_list_price(listPrice);
			Thread.sleep(1000);	
				
			// Verify correct Stock Price returned
			homePage.field_stock_price(stockPrice);
			Thread.sleep(1000);	
				
			// Verify correct Weight returned
			homePage.field_weight(weight);
	
			// Get ready for next search
			homePage.input_arthrex_logo_link();	
			Thread.sleep(5000);
				
		} // SearchDetails_US
	*/
	

	@DataProvider
	public Object[][] getBOMData() {
		 System.out.println("In before call getBOMData");
	   Object data[][] =ExcelUtil.getTestData("SearchBOM_US");
	   System.out.println("In getBOMData");
	   return data;
	}
	
	//method-level annotations values
	// after run 1st time
// @Bumblebee(almid=31, description="Updated description again8", testplan = "Subject\\Product Browser\\Search", testlab = "Root\\Product Browser\\2019\\CCB 01-2019", testset = "CCB - Overwrite Class TestSet", almReqIds = { 11 , 15 }, almReqRecursive=BooleanValue.TRUE)
   //  first time
@Bumblebee(testname="SearchBOM_US", testplan = "Subject\\Product Browser\\Search", testlab = "Root\\Product Browser\\2019\\CCB 01-2019", testset = "CCB - Overwrite Class TestSet")
@Test(dataProvider = "getBOMData" )
	public void SearchBOM_US (String username, String password, String language, String searchText, String partNumber,
			String bomPartNumber1, String bomDescription1, String bomQty1, 
			String bomPartNumber2, String bomDescription2, String bomQty2, 
			String bomPartNumber3, String bomDescription3, String bomQty3, 
			String bomPartNumber4, String bomDescription4, String bomQty4) throws InterruptedException {						

		    
			System.out.println("In searchBOM");

			System.out.println(searchText);
			Thread.sleep(5000);
		    //  homePage.input_searchBox(getCellData("SearchTest", "SearchText", 3));
			homePage.input_searchBox(searchText);
			Thread.sleep(5000);
			homePage.input_searchButton();
			Thread.sleep(5000);
			homePage.input_productButton();
			Thread.sleep(5000);
			homePage.input_bomTab();
			Thread.sleep(5000);
			// Assertions
			// BOM PartNumber 1
	        homePage.field_bom_partNumber1(bomPartNumber1);
	        Thread.sleep(1000);	
	        System.out.println("The part number is " + bomPartNumber1);
	    	// BOM Part Description 1
	        homePage.field_bom_description1(bomDescription1);
	        Thread.sleep(1000);	
	        System.out.println("The part descripton is " + bomDescription1);
	    	// BOM Party Qty 1
	        System.out.println("The part qty before is " + bomQty1);
	        homePage.field_bom_quantity1(bomQty1);
	        Thread.sleep(1000);
	        System.out.println("The part qty after is " + bomQty1);
	        	
	        //Homepage needs update for BOM parts
	     
			// BOM PartNumber 2
	        homePage.field_bom_partNumber2(bomPartNumber2);
	        Thread.sleep(1000);	
	    	// BOM Part Description 2
	        homePage.field_bom_description2(bomDescription2);
	        Thread.sleep(1000);	
	    	// BOM Party Qty 2
	        homePage.field_bom_quantity2(bomQty2);
	        Thread.sleep(1000);	
	        
	        // BOM PartNumber 3
	        homePage.field_bom_partNumber3(bomPartNumber3);
	        Thread.sleep(1000);	
	    	// BOM Part Description 3
	        homePage.field_bom_description3(bomDescription3);
	        Thread.sleep(1000);	
	    	// BOM Party Qty 3
	        homePage.field_bom_quantity3(bomQty3);
	        Thread.sleep(1000);	
	        
	         // BOM PartNumber 4
	        homePage.field_bom_partNumber4(bomPartNumber4);
	        Thread.sleep(1000);	
	    	// BOM Part Description 4
	        homePage.field_bom_description4(bomDescription4);
	        Thread.sleep(1000);	
	    	// BOM Party Qty 4
	        homePage.field_bom_quantity4(bomQty4);
	        Thread.sleep(1000);	
	       
			// Get ready for next search
			homePage.input_arthrex_logo_link();	
			Thread.sleep(5000);
		} // SearchBOM_US

	/*

	@DataProvider
	public Object[][] getContainsInData() {
		
	    
		Object data[][] =ExcelUtil.getTestData("SearchContainsIn_US");
	  //   Object data[][] =ExcelUtil.getSpecificColumnTestData("SearchContainsIn_US", "0", "10");
	 //  Object data[][] =ExcelUtil.getSpecificColumnTestData("SearchContainsIn_US", "5", "8");
	   return data;
	}
	// Ater run 1st time
	@Bumblebee(almid=33, description="Update Description3", testplan = "Subject\\Product Browser\\Search", testlab = "Root\\Product Browser\\2019\\CCB 01-2019", testset = "CCB - Overwrite Class TestSet", almReqIds = { 19 }, almReqRecursive=BooleanValue.FALSE)
	// 1s time
	// @Bumblebee(testname="SearchContainsIn_US", testplan = "Subject\\Product Browser\\Search", testlab = "Root\\Product Browser\\2019\\CCB 01-2019", testset = "CCB - Overwrite Class TestSet")
	@Test(dataProvider = "getContainsInData")
	public void SearchContainsIn_US(String username, String password, String language, 
			String searchText, String partNumber,
			String containPartNumber1, String containDescription1, 
			String containPartNumber2, String containDescription2, 
			String containPartNumber3, String containDescription3) throws InterruptedException {						
			
		 System.out.println("In SearchContainsIn_US");
			System.out.println(searchText);
			Thread.sleep(5000);
		    //  homePage.input_searchBox(getCellData("SearchTest", "SearchText", 3));
			homePage.input_searchBox(searchText);
			Thread.sleep(4000);
			homePage.input_searchButton();
			Thread.sleep(4000);
			homePage.input_productButton();
			Thread.sleep(4000);
			homePage.input_containedIn();
			Thread.sleep(4000);
			
			// 

			// Assertions
			// Contains PartNumber 1
			homePage.field_contain_part1(containPartNumber1);
	        Thread.sleep(1000);	
	    	// Contains PartDescription 1
            homePage.field_contain_desc1(containDescription1);
	        Thread.sleep(1000);	
	        
	    	// Contains PartNumber 2
			homePage.field_contain_part2(containPartNumber2);
	        Thread.sleep(1000);	
	    	// Contains PartDescription 2
            homePage.field_contain_desc2(containDescription2);
	        Thread.sleep(1000);		
	        
	    	// Contains PartNumber 3
			homePage.field_contain_part3(containPartNumber3);
	        Thread.sleep(1000);	
	    	// Contains PartDescription 3
            homePage.field_contain_desc3(containDescription3);
	        Thread.sleep(1000);	
	        
			// Get ready for next search
			homePage.input_arthrex_logo_link();	
			Thread.sleep(2000);
		} // SearchContainsIn_US

*/

/*
	@DataProvider
	public Object[][] getProductCodeData() {
		
	   Object data[][] =ExcelUtil.getTestData("SearchProductCodes_US");
	   return data;
	}
	
	@Test(dataProvider = "getProductCodes")
	public void SearchProductCodes_US (String username, String password, String language, 
			String searchText, String partNumber,
			String gtin, String lifeCyclePhase, 
			String level1DeviceCountPKG, String level2DeviceCountPKG, String level3DeviceCountPKG,
			String level1PKGGTIN, String level2PKGGTIN, String level3PKGGTIN,
			String gdmn, String umdms, String unspsc, String fdaClass, String medDeviceClass) throws InterruptedException {						
			

			System.out.println(searchText);
			Thread.sleep(5000);
		    //  homePage.input_searchBox(getCellData("SearchTest", "SearchText", 3));
			homePage.input_searchBox(searchText);
			Thread.sleep(5000);
			homePage.input_searchButton();
			Thread.sleep(5000);
			homePage.input_productButton();
			Thread.sleep(5000);
			homePage.input_productCode();
			Thread.sleep(10000);

			// Assertions
			// GTIN
			homePage.field_gtin(gtin);
	        Thread.sleep(1000);	
	    	// Life Cycle Phase	        
            homePage.field_lifeCycePhase(lifeCyclePhase);
	        Thread.sleep(1000);	
	    	// Level 1 Device Count Pkg
			homePage.field_Level1DeviceCountPKG(level1DeviceCountPKG);
	        Thread.sleep(1000);	
	    	// Level 2 Device Count Pkg
	        homePage.field_Level2DeviceCountPKG(level2DeviceCountPKG);
	        Thread.sleep(1000);		 
	    	// Level 3 Device Count Pkg
	        homePage.field_Level3DeviceCountPKG(level3DeviceCountPKG);
	        Thread.sleep(1000);	
	    	// Level 1 PKg GTIN
            homePage.field_Level1PKGGTIN(level1PKGGTIN);
	        Thread.sleep(1000);		        
	    	// Contains Level 2 PKg GTIN
            homePage.field_Level2PKGGTIN(level2PKGGTIN);
	        Thread.sleep(1000);		        
	    	// Contains Level 3 PKg GTIN
            homePage.field_Level3PKGGTIN(level3PKGGTIN);
	        Thread.sleep(1000);	
	    	// GDMN
            homePage.field_gdmn(gdmn);
	        Thread.sleep(1000);	
	    	// UMDMS
            homePage.field_umdms(umdms);
	        Thread.sleep(1000);		        	        
	    	// UNSPSC
            homePage.field_unspsc(unspsc);
	        Thread.sleep(1000);	
	    	// FDA Class
            homePage.field_fdaClass(fdaClass);
	        Thread.sleep(1000);		        
	    	// Medical Device Classs
            homePage.field_medDeviceClass(medDeviceClass);
	        Thread.sleep(1000);	
	        
			// Get ready for next search
			homePage.input_arthrex_logo_link();	
			Thread.sleep(5000);
			
		} // SearchProductCodes_US
	*/

}
