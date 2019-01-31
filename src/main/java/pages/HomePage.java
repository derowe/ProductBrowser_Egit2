package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import baseClass.TestBase;

public class HomePage extends TestBase {

	WebDriver driver;
    By input_arthrex_logo_link = By.xpath("//html/body/header/nav/div/div[1]/div/a/img");
	By input_salesorg_langButton = By.xpath("//*[@id=\"dropdownMenu1\"]");
	By input_lang_select = By.xpath("//*[@id=\"internationalization\"]/li[2]/div/form/div[3]/select");
	
	By input_searchBox = By.xpath("//input[@id=\"searchBox\"]");
	By input_searchButton = By.xpath("//*[@id=\"splashSearchButton\"]");
	By input_productButton = By
			.xpath("/html[1]/body[1]/section[1]/div[2]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/span[1]");
	By input_bomTab = By.xpath("//*[@id=\"searchResults\"]/table/tbody/tr[2]/td/div/div[2]/div/div/ul/li[2]/a");
	By input_containedIn = By.xpath("//*[@id=\"searchResults\"]/table/tbody/tr[2]/td/div/div[2]/div/div/ul/li[3]/a");
	By input_productCode = By.xpath("//*[@id=\"searchResults\"]/table/tbody/tr[2]/td/div/div[2]/div/div/ul/li[4]/a");
	By input_assets = By.xpath("//*[@id=\"searchResults\"]/table/tbody/tr[2]/td/div/div[2]/div/div/ul/li[1]/a");
    
	
	// Assertion Locators
	// PartNumber top returned - use this one
	By field_partNumber_main = By.xpath("//*[@id=\"partNumber\"]");
	By field_description_main = By.xpath("//*[@id=\"partDescription\"]");
	By field_long_description_main =By.xpath("/html/body/section/div[2]/div[3]/table/tbody/tr[2]/td/div/div[2]/p[2]");
	By field_packing_unit = By.xpath("/html/body/section/div[2]/div[3]/table/tbody/tr[2]/td/div/div[1]/table/tbody/tr[1]/td[2]");
	By field_list_price =By.xpath("/html/body/section/div[2]/div[3]/table/tbody/tr[2]/td/div/div[1]/table/tbody/tr[2]/td[2]");	
	By field_stock_price =By.xpath("/html/body/section/div[2]/div[3]/table/tbody/tr[2]/td/div/div[1]/table/tbody/tr[3]/td[2]");
	By field_weight =By.xpath("/html/body/section/div[2]/div[3]/table/tbody/tr[2]/td/div/div[1]/table/tbody/tr[7]/td[2]");
			
	By field_bom_partNumber1 = By.xpath("//*[@id=\"bom-0\"]/table/tbody/tr[1]/td[1]");
	By field_bom_description1 = By.xpath("//*[@id=\"bom-0\"]/table/tbody/tr[1]/td[2]");
	By field_bom_quantity1 = By.xpath("//*[@id=\"bom-0\"]/table/tbody/tr[1]/td[3]");	
	By field_bom_partNumber2 = By.xpath("//*[@id=\"bom-0\"]/table/tbody/tr[2]/td[1]");
	By field_bom_description2 = By.xpath("//*[@id=\"bom-0\"]/table/tbody/tr[2]/td[2]");
	By field_bom_quantity2 = By.xpath("//*[@id=\"bom-0\"]/table/tbody/tr[2]/td[3]");	
	By field_bom_partNumber3 = By.xpath("//*[@id=\"bom-0\"]/table/tbody/tr[3]/td[1]");
	By field_bom_description3 = By.xpath("//*[@id=\"bom-0\"]/table/tbody/tr[3]/td[2]");
	By field_bom_quantity3 = By.xpath("//*[@id=\"bom-0\"]/table/tbody/tr[3]/td[3]");	
	By field_bom_partNumber4 = By.xpath("//*[@id=\"bom-0\"]/table/tbody/tr[4]/td[1]");
	By field_bom_description4 = By.xpath("//*[@id=\"bom-0\"]/table/tbody/tr[4]/td[2]");
	By field_bom_quantity4 = By.xpath("//*[@id=\"bom-0\"]/table/tbody/tr[4]/td[3]");
	
		
	By field_contain_part1 = By.xpath("//*[@id=\"inSets-0\"]/table/tbody/tr/td[1]/span");
	By field_contain_desc1 = By.xpath("//*[@id=\"inSets-0\"]/table/tbody/tr/td[2]");
	By field_contain_part2 = By.xpath("//*[@id=\"inSets-0\"]/table/tbody/tr[2]/td[1]/span");
	By field_contain_desc2 = By.xpath("//*[@id=\"inSets-0\"]/table/tbody/tr[2]/td[2]");
	By field_contain_part3 = By.xpath("//*[@id=\"inSets-0\"]/table/tbody/tr[3]/td[1]/span");
	By field_contain_desc3 = By.xpath("//*[@id=\"inSets-0\"]/table/tbody/tr[3]/td[2]");
	By field_gtin = By.xpath(""); 
	By field_lifeCyclePhase = By.xpath("");
	By field_Level1DeviceCountPKG = By.xpath("");
	By field_Level2DeviceCountPKG = By.xpath("");
	By field_Level3DeviceCountPKG = By.xpath("");
	By field_Level1PKGGTIN = By.xpath("");
	By field_Level2PKGGTIN = By.xpath("");
	By field_Level3PKGGTIN = By.xpath("");
	By field_GMDN = By.xpath("//*[@id=\"gtin-0\"]/div[1]/div[5]/div[1]/span[2]");
	By field_UMDMS = By.xpath("");
	By field_UNSPSC = By.xpath("//*[@id=\"gtin-0\"]/div[1]/div[7]/div/span[2]");
	By field_FDAClass = By.xpath("//*[@id=\"gtin-0\"]/div[1]/div[5]/div[2]/span[2]");
	By field_MedicalDeviceClass = By.xpath("//*[@id=\"gtin-0\"]/div[1]/div[6]/div[2]/span[2]");

	
	/*
	public ApproveCAPAImplementationPlanPage(){
		
		PageFactory.initElements(driver, this);
	}
	*/
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void input_arthrex_logo_link() {
		driver.findElement(input_arthrex_logo_link).click();
	}

	public void input_salesorg_langButton() {
		driver.findElement(input_salesorg_langButton).click();
	}

	
	public void input_language(String lang) {
		
		Select langSelect = new Select(driver.findElement(input_lang_select));
		System.out.println("Language passed in " + lang);
		if (lang.equals("English")) {
			langSelect.selectByVisibleText("English");
		} else if (lang.equals("German")) {
			langSelect.selectByVisibleText("German");
		} else if (lang.equals("French")) {
			langSelect.selectByVisibleText("French");
		}  else {
			// Lang not defined
		}
		
	}
	
	public void input_searchBox(String search) {
		driver.findElement(input_searchBox).sendKeys(search);
	}

	public void input_searchButton() {
		driver.findElement(input_searchButton).click();
	}

	public void input_productButton() {
		driver.findElement(input_productButton).click();
	}

	public void textExistsOnPage(String value) {

		System.out.println("Page contains1 " + value);
		
		Assert.assertTrue(driver.getPageSource().contains(value));
	
		if (driver.getPageSource().contains(value)) {
			System.out.println("Page contains " + value);
		} else {
			System.out.println("Page does not contain " + value);
		}
	}

	public void input_bomTab() {
		driver.findElement(input_bomTab).click();
	}
	public void input_containedIn() {
		driver.findElement(input_containedIn).click();
	}

	public void input_productCode() {
		driver.findElement(input_productCode).click();
	}

	public void input_assets() {
		driver.findElement(input_assets).click();
	}
	
	 // Assertion Code 
	// Assert Part Number
	public void field_partNumber(String number) {		
		System.out.println("PartNumber passed to assert method" + number);
		//String actualString = driver.findElement(field_partNumber).getText();
		String actualString = driver.findElement(field_partNumber_main).getText();
		System.out.println("Actual partname is " + actualString);
		Assert.assertTrue(actualString.contains(number));
	}
	// Assert Part Description
	public void field_description(String description) {
		String actualString = driver.findElement(field_description_main).getText();
		System.out.println("Actual description is " + actualString);
		Assert.assertTrue(actualString.contains(description));
	}
	// Assert Long Description
	public void field_long_description(String longDescription) {
		String actualString = driver.findElement(field_long_description_main).getText();
		System.out.println("Actual long descripton is " + actualString);
		Assert.assertTrue(actualString.contains(longDescription));
	}
	
	// Assert Packing Unit
	public void field_packing_unit(String packingUnit) {
		String actualString = driver.findElement(field_packing_unit).getText();
		System.out.println("Actual list price is " + actualString);
		Assert.assertTrue(actualString.contains(packingUnit));
	}
	// Assert List Price
	public void field_list_price(String listPrice) {
		String actualString = driver.findElement(field_list_price).getText();
		System.out.println("Actual list price is " + actualString);
		Assert.assertTrue(actualString.contains(listPrice));
	}
	// Assert Stock Price
	public void field_stock_price(String stockPrice) {
		String actualString = driver.findElement(field_stock_price).getText();
		System.out.println("Actual stock price is " + actualString);
		Assert.assertTrue(actualString.contains(stockPrice));
	}
	// Assert Weight
	public void field_weight(String weight) {
		String actualString = driver.findElement(field_weight).getText();
		System.out.println("Actual weight price is " + actualString);
		Assert.assertTrue(actualString.contains(weight));
	}
	// Assert BOM Part Number 1
	public void field_bom_partNumber1(String bom_partNumber1) {
		String actualString = driver.findElement(field_bom_partNumber1).getText();
		Assert.assertTrue(actualString.contains(bom_partNumber1));
	}
	// Assert BOM Part Description 1
	public void field_bom_description1(String bom_description1) {
		String actualString = driver.findElement(field_bom_description1).getText();
		Assert.assertTrue(actualString.contains(bom_description1));
	}
	// Assert BOM Part Quantity 1
	public void field_bom_quantity1(String quantity1) {
		String actualString = driver.findElement(field_bom_quantity1).getText();
		Assert.assertTrue(actualString.contains(quantity1));
	}
	// Assert BOM Part Number 2
	public void field_bom_partNumber2(String bom_partNumber2) {
		String actualString = driver.findElement(field_bom_partNumber2).getText();
		Assert.assertTrue(actualString.contains(bom_partNumber2));
	}
	// Assert BOM Part Description 2
	public void field_bom_description2(String bom_description2) {
		String actualString = driver.findElement(field_bom_description2).getText();
		Assert.assertTrue(actualString.contains(bom_description2));
	}
	// Assert BOM Part Quantity 2
	public void field_bom_quantity2(String quantity2) {
		String actualString = driver.findElement(field_bom_quantity2).getText();
		Assert.assertTrue(actualString.contains(quantity2));
	}
	// Assert BOM Part Number 3
	public void field_bom_partNumber3(String bom_partNumber3) {
		String actualString = driver.findElement(field_bom_partNumber3).getText();
		Assert.assertTrue(actualString.contains(bom_partNumber3));
	}	
	// Assert BOM Part Description 3
	public void field_bom_description3(String bom_description3) {
		String actualString = driver.findElement(field_bom_description3).getText();
		Assert.assertTrue(actualString.contains(bom_description3));
	}
	// Assert BOM Part Quantity 3
	public void field_bom_quantity3(String quantity3) {
		String actualString = driver.findElement(field_bom_quantity3).getText();
		Assert.assertTrue(actualString.contains(quantity3));
	}
	// Assert BOM Part Number 4
	public void field_bom_partNumber4(String bom_partNumber4) {
		String actualString = driver.findElement(field_bom_partNumber4).getText();
		Assert.assertTrue(actualString.contains(bom_partNumber4));
	}		
	// Assert BOM Part Description 4
		public void field_bom_description4(String bom_description4) {
			String actualString = driver.findElement(field_bom_description4).getText();
			Assert.assertTrue(actualString.contains(bom_description4));
	}
	// Assert BOM Part Quantity 4
		public void field_bom_quantity4(String quantity4) {
			String actualString = driver.findElement(field_bom_quantity4).getText();
			Assert.assertTrue(actualString.contains(quantity4));
	}	
	
	// Assert Contains Part 1
	public void field_contain_part1(String contain_part1) {
		String actualString = driver.findElement(field_contain_part1).getText();
		Assert.assertTrue(actualString.contains(contain_part1));
	}
	// Assert Contains Description 1
	public void field_contain_desc1(String contain_desc1) {
		String actualString = driver.findElement(field_contain_desc1).getText();
		Assert.assertTrue(actualString.contains(contain_desc1));
	}
	// Assert Contains Part 2
	public void field_contain_part2(String contain_part2) {
		String actualString = driver.findElement(field_contain_part2).getText();
		Assert.assertTrue(actualString.contains(contain_part2));
	}
	// Assert Contains Description 2
	public void field_contain_desc2(String contain_desc2) {
		String actualString = driver.findElement(field_contain_desc2).getText();
		Assert.assertTrue(actualString.contains(contain_desc2));
	}

	// Assert Contains Part 3
	public void field_contain_part3(String contain_part3) {
		String actualString = driver.findElement(field_contain_part3).getText();
		Assert.assertTrue(actualString.contains(contain_part3));
	}
	// Assert Contains Description 3
	public void field_contain_desc3(String contain_desc3) {
		String actualString = driver.findElement(field_contain_desc3).getText();
		Assert.assertTrue(actualString.contains(contain_desc3));
	}
	// Assert GTIN
	public void field_gtin(String gtin) {
		String actualString = driver.findElement(field_gtin).getText();
		Assert.assertTrue(actualString.contains(gtin));
	}
	
	// Assert Life Cycle Phase
	public void field_lifeCycePhase(String lifeCyclePhase) {
		String actualString = driver.findElement(field_lifeCyclePhase).getText();
		Assert.assertTrue(actualString.contains(lifeCyclePhase));
	}
	
	// Assert Level1DeviceCountPKG
	public void field_Level1DeviceCountPKG(String level1DeviceCountPKG) {
		String actualString = driver.findElement(field_Level1DeviceCountPKG).getText();
		Assert.assertTrue(actualString.contains(level1DeviceCountPKG));
	}
	
	
	// Assert Level2DeviceCountPKG
	public void field_Level2DeviceCountPKG(String level2DeviceCountPKG) {
		String actualString = driver.findElement(field_Level2DeviceCountPKG).getText();
		Assert.assertTrue(actualString.contains(level2DeviceCountPKG));
	}
	
	// Assert Level3DeviceCountPKG
	public void field_Level3DeviceCountPKG(String level3DeviceCountPKG) {
		String actualString = driver.findElement(field_Level3DeviceCountPKG).getText();
		Assert.assertTrue(actualString.contains(level3DeviceCountPKG));
	}
	
	// Assert Level1PKGGTIN
	public void field_Level1PKGGTIN(String level1PKGGTIN) {
		String actualString = driver.findElement(field_Level1PKGGTIN).getText();
		Assert.assertTrue(actualString.contains(level1PKGGTIN));
	}	
	
	// Assert Level2PKGGTIN
	public void field_Level2PKGGTIN(String level2PKGGTIN) {
		String actualString = driver.findElement(field_Level2PKGGTIN).getText();
		Assert.assertTrue(actualString.contains(level2PKGGTIN));
	}	
	
	// Assert Level3PKGGTIN
	public void field_Level3PKGGTIN(String level3PKGGTIN) {
		String actualString = driver.findElement(field_Level3PKGGTIN).getText();
		Assert.assertTrue(actualString.contains(level3PKGGTIN));
	}	

	// Assert GDMN
	public void field_gdmn(String gdmn) {
		String actualString = driver.findElement(field_GMDN).getText();
		Assert.assertTrue(actualString.contains(gdmn));
	}	

	// Assert UMDMS
	public void field_umdms(String umdms) {
		String actualString = driver.findElement(field_UMDMS).getText();
		Assert.assertTrue(actualString.contains(umdms));
	}	
	
	// Assert UNSPSC
	public void field_unspsc(String unspsc) {
		String actualString = driver.findElement(field_UMDMS).getText();
		Assert.assertTrue(actualString.contains(unspsc));
	}	
	
	// Assert FDAClass
	public void field_fdaClass(String fdaClass) {
		String actualString = driver.findElement(field_FDAClass).getText();
		Assert.assertTrue(actualString.contains(fdaClass));
	}	
		
	// Assert Medical Device Class
	public void field_medDeviceClass(String medDeviceClass) {
		String actualString = driver.findElement(field_MedicalDeviceClass).getText();
		Assert.assertTrue(actualString.contains(medDeviceClass));
	}	
	
}
