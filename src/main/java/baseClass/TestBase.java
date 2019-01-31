package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utilities.TestUtil;
import utilities.ProductBrowserUtil;


@SuppressWarnings("unused")
public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public String path;
	static FileInputStream fis;

	//static XSSFWorkbook workbook;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	XSSFCell cell;

	public TestBase() {

		this(System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "ProductBrowserDataSheet.xlsx");		
		System.out.println((System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "ProductBrowserDataSheet.xlsx"));
		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream(System.getProperty("user.dir") + File.separator + "ConfigFile"
					+ File.separator + "config.properties");

			prop.load(fip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public TestBase(String path) {
		this.path = path;
		System.out.println("Path is " + path);
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	public static String getCellData(String sheetName, String colName, int rowNum) {

		try {
			int col_Num = 0;
			int index = workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			XSSFRow row = sheet.getRow(1);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equals(colName)) {
					col_Num = i;
				}
			}
			row = sheet.getRow(rowNum - 1);
			XSSFCell cell = row.getCell(col_Num);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(cell.getBooleanCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

/*
	public static void Initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Projects\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Projects\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Selenium Projects\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.ie.driver", "C:\\Selenium Projects\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
			
	*/
	
	public static void Initialization() throws Throwable {
		System.out.println(prop.getProperty("url"));
		String browserName = prop.getProperty("browser");
		String driverPath = prop.getProperty("driver_dir");
		
		System.out.println(browserName);
		System.out.println(driverPath);
		if (browserName.equals("Chrome")) {
			//String driverpath = System.getProperty("user.dir") + "\\Driver";
			
			//System.setProperty("webdriver.chrome.driver",
			//		driverPath + File.separator + "chromedriver2.38" + File.separator + "chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", driverPath + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserName.equals("Firefox")) {
			// System.setProperty("webdriver.gecko.driver", "");
			System.setProperty("webdriver.gecko.driver", driverPath + File.separator + "geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\Selenium Projects\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", driverPath + File.separator + "IEDriverServer.exe");
			//System.setProperty("webdriver.ie.driver", "C:\\Selenium Projects\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.ie.driver", driverPath + File.separator + "IEDriverServer.exe");
			// System.setProperty("webdriver.ie.driver", "C:\\Selenium Projects\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

	    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    // driver.manage().deleteAllCookies();
	    
	    
	    driver.get(prop.getProperty("url"));   
	}   
	
}

