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

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT=90;
	public static long IMPLICIT_WAIT=60;
	public static long SLEEP_WAIT=1000;
	

	
	// Utilities which can be used by all applications
	
	/* #################################
	 * Function Name: ChildWindowHandle
	 * Description: to handle new or additional windows
	 * #################################
	 */
	public static void ChildWindowHandle()
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> i1 = windows.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			driver.switchTo().window(ChildWindow);
		}
	}
	/* #################################
	 * Function Name: SwitchToFrame
	 * Description: to switch between frames
	 * #################################
	 */
	public void SwitchToFrame(int index)
	{
		try{
			driver.switchTo().frame(index);
		}
		catch(NoSuchFrameException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	/* #################################
	 * Function Name: CustomWait
	 * Description: to wait for specific WebElement in WebPage
	 * #################################
	 */
	public void CustomWait(int Time_IN_Seconds,String Objectxpath)
	{
		try{
		WebDriverWait wait= new WebDriverWait(driver,Time_IN_Seconds);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(
				By.xpath(Objectxpath))));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	/* #################################
	 * Function Name: GetWindowHandles
	 * Description: to switch between windows
	 * #################################
	 */
	public void GetWindowHandles()
	{
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows)
		{
			driver.switchTo().window(window);
		}
	}
	/* #################################
	 * Function Name: SearchNCRecord
	 * Description: to search record from NC table
	 * #################################
	 */
	public static String SearchNCRecord(String NC_RecordNum)
	{
		int row_count=driver.findElements(By.xpath("//table[@id='ctl04_resultGrid_ctl00']/tbody/tr/td/div/span/a")).size();
		boolean found = false;
		for(int i=1;i<=row_count;i++ ){
			String record=driver.findElement(By.xpath("//table[@id='ctl04_resultGrid_ctl00']/tbody/tr["+i+"]/td/div/span/a")).getText();
			if(record.equals(NC_RecordNum))
			{
		      
		      driver.findElement(By.xpath("//table[@id='ctl04_resultGrid_ctl00']/tbody/tr["+i+"]/td/div/span/a")).click();
		      found=true;
			  break;
			}
			  else
			  found=false;
		}
		if(found=true)
		{
			System.out.println("Record found: "+NC_RecordNum);
		    return NC_RecordNum;
		}
		else
			System.out.println("Record not found: "+NC_RecordNum);
		     return NC_RecordNum;
		
	}
	/* #################################
	 * Function Name: TakeScreenshot
	 * Description: it takes screenshot of web page
	 * #################################
	 */
	public void TakeScreenshot(String ScreenshotName)
	{
		
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./Screenshots/"+ScreenshotName+".png"));
			//FileUtils.copyFile(src, new File("./Screenshots/"+ScreenshotName+".png"));
		} catch (Exception e) {
			System.out.println("Exception while taking the screenshot "+e.getMessage());
		}	
	}
	/* #################################
	 * Function Name: ExplicitWaitToAnElement
	 * Description: it waits for specific element in a web page
	 * #################################
	 */
	public static void ExplicitWaitToAnElement(int Time,String objectxpath)
	{
		try{
		WebDriverWait wait= new WebDriverWait(driver,Time);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(objectxpath)));
		}
		catch(TimeoutException e)
		{
			System.out.println(e.getMessage());
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	/* #################################
	 * Function Name: ExplicitWaitForFrameToBePresent
	 * Description: it waits for specific frame and switches to it when it is available in a web page
	 * #################################
	 */
	public static void ExplicitWaitForFrameToBePresent(int Time,String name)
	{
		try{
		WebDriverWait wait=new WebDriverWait(driver,Time);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name(name)));
		}
		catch(TimeoutException e)
		{
			System.out.println(e.getMessage());
		}
		catch(NoSuchFrameException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	/* #################################
	 * Function Name: FluentWaitForAnElement
	 * Description: It checks for every 2 seconds whether the element is visible or not 
	 * #################################
	 */
	public static void FluentWaitForAnElement(WebDriver driver,final String xpath)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		wait.withTimeout(90, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		// we are creating Function here which accept webdriver and output as WebElement
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			// apply method- which accept webdriver as input
			public WebElement apply(WebDriver driver) {
				WebElement ele = driver.findElement(By.xpath(xpath));
				if(ele.isDisplayed())
					return ele;
				else
					return null;
			}
		});
	}
	/* #################################
	 * Function Name: checkPageIsReady
	 * Description: check whether the page is loaded completely
	 * #################################
	 */
	public static void checkPageIsReady() {
		  
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  
		  
		  //Initially below given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		   //System.out.println("Page Is loaded.");
		   return; 
		  } 
		  
		  //This loop will rotate for 120 times to check If page Is ready after every 1 second.
		  //You can replace your value with 120 If you wants to Increase or decrease wait time.
		  for (int i=0; i<120; i++){ 
		   try {
		    Thread.sleep(2000);
		    }catch (InterruptedException e) {
		    } 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		    break; 
		   }   
		  }
		 }
		

	/* #################################
	 * Function Name: GetTextFromAlertWindow
	 * Description: get text from Alert Errors Window
	 * #################################
	 */
	public void GetTextFromAlertWindow() throws InterruptedException
	{
		List<WebElement> list=driver.findElements(By.className("errorPromptSpanLink"));
		for(WebElement err:list)
		{
			String errormsg=err.getText();
			System.out.println(errormsg);
			Thread.sleep(1000);
		}
		
	}
	/* #################################
	 * Function Name:SetTextInDEVTeamMemberPanel
	 * Description: Enter text in team member section
	 * #################################
	 */
	public boolean SetTextInDEVTeamMemberPanel(WebElement ele,String value) throws InterruptedException
	{
		boolean setstatus=true;
		ele.click();
		ele.sendKeys(Keys.CONTROL+ "a");
		ele.sendKeys(Keys.DELETE);
		ele.sendKeys(value);
		Thread.sleep(SLEEP_WAIT);
		Thread.sleep(SLEEP_WAIT);
		driver.findElement(By.xpath("//li[@class='t-item t-state-selected']")).click();
		ele.sendKeys(Keys.TAB);
		String enteredValue="";
		enteredValue=ele.getAttribute("value");
		if(!enteredValue.equalsIgnoreCase(value))
			setstatus=false;
		Thread.sleep(SLEEP_WAIT);
		return setstatus;
		
	}
	/* #################################
	 * Function Name:GetTextFromTextBox
	 * Description: Get text from text box and Validate
	 * #################################
	 */
	public static boolean GetTextFromTextBox(WebElement tb,String data)
	{
		boolean flag=true;
		//tb.click();
		tb.sendKeys(Keys.CONTROL+"a");
		tb.sendKeys(Keys.DELETE);
		tb.sendKeys(data);
		try {
			Thread.sleep(SLEEP_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tb.sendKeys(Keys.TAB);
		String enteredValue="";
		if(!enteredValue.equals(data))
			flag=false;
		else
			flag=true;
			System.out.println("TextBox contains value: "+data);
		return flag;
		
	}
	

	
	/* #################################
	 * Function Name:getCurrentDay
	 * Description: returns todays day in numeric format. eg: 25
	 * #################################
	 */
	public static String getCurrentDay (){
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        //System.out.println("Today Int: " + todayInt +"\n");
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        //System.out.println("Today Str: " + todayStr + "\n");
        return todayStr;
    }
	
	/* #################################
	 * Function Name:ScrollBar
	 * Description: Scroll horizontal or vertical bar till the element is visible
	 * #################################
	 */
	
	public static void ScrollBar(WebElement ele){
		
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		//jse.executeScript("scroll(0,-2000)");
		//("window.scrollBy(0,-1000)");
      //WebElement ele=driver.findElement(By.xpath("//div[@id='WorkflowErrorPrompt_errorHeader']/span/img"));
				jse.executeScript("arguments[0].scrollIntoView();", ele);
		
	}
	/* #################################
	 * Function Name:waitToPageLoad
	 * Description: Wait till the page completes buffering
	 * #################################
	 */
	public static void waitToPageLoad()
	{
		WebDriverWait w=new WebDriverWait(driver,90);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='RadAjaxLoadingPanelRecord']//div")));
		
	}
	
	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

