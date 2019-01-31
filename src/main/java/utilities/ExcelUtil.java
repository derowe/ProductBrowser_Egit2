package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import baseClass.TestBase;

/* 
 * ExcelUtil.java - Utility for reading Data from Excel sheet
 */
public class ExcelUtil extends TestBase {
	static Workbook book;
	static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH = prop.getProperty("datasheet");
	
	/* 
	 * getTestData - reads all rows and columns from Data import sheet specified.
	 */
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e){
			e.printStackTrace();
		}	catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object [][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// Was i-0, Start on row 2, first row has labels
		for (int i =0; i < sheet.getLastRowNum(); i++) {
			//  was getRow(0), start at Row 2
			for (int k=0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i +1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		  }
		  System.out.println("last row number" + sheet.getLastRowNum());
		  System.out.println("last column number" + sheet.getRow(0).getLastCellNum());
		  System.out.println(data[0][0]);
		  System.out.println(data[0][1]);
		  System.out.println(data[0][2]);
		  System.out.println(data[0][3]);
		  System.out.println(data[0][4]);
		  System.out.println(data[0][5]);
		  System.out.println(data[0][6]);
		  System.out.println(data[0][7]);
		  return data;
		}  // getTestData
	
	/* 
	 * getSpecificColumnTestData - reads data in the columns specified from the Data import sheet.
	 * Reads all rows for the specified columns
	 * colStart - first column, A1= Column 0  
	 * ColEnd - last column, must be > colStart
	 */
	public static Object[][] getSpecificColumnTestData(String sheetName, String colStart, String colEnd) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e){
			e.printStackTrace();
		}	catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		
		int columnStart = Integer.parseInt(colStart);
		int columnEnd = Integer.parseInt(colEnd);
		int numColumns= columnEnd - columnStart + 1;
		

		sheet = book.getSheet(sheetName);
		Object [][] data=new Object[sheet.getLastRowNum()][numColumns];
		System.out.println("Number of rows " + sheet.getLastRowNum());
		System.out.println("Starting on column " + colStart);
		System.out.println("Ending on column " + colEnd);
		System.out.println("Number of columns " + numColumns);
		
		// Was i-0, Start on row 2, first row has labels
		for (int i =0; i < sheet.getLastRowNum(); i++) {
			//  was getRow(0), start at Row 2

			for (int k=0, columnValue=columnStart; k < numColumns; k++, columnValue++) {
				data[i][k] = sheet.getRow(i +1).getCell(columnValue).toString();
				System.out.println(data[i][k]);
			}
		  }
		  //System.out.println("last row number" + sheet.getLastRowNum());
		//  System.out.println("last cell  number" + sheet.getRow(0).getLastCellNum());
		  
		  return data;
		}  // getSpecificColumnTestData

}
