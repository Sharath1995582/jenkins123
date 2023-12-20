package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest
{
	public static WebDriver driver;
	public static Properties p;
	public static FileInputStream fis;
	public static String projectPath = System.getProperty("user.dir");
	public static Properties mainprop;
	public static Properties childprop;
	public static Properties orprop;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String filePath;
	
	static
	{
		Date dt = new Date();
		filePath = dt.toString().replace(':','_').replace(' ', '_');
	}
	
		public static void init() throws Exception
	{
	//FileInputStream fis = new FileInputStream("D:\\Selenium_automation\\August2023Selenium\\src\\test\\resources\\data.properties");
	 fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.properties");
	 p = new Properties();
	p.load(fis);
	//String e	= p.getProperty("amazonurl");
	//System.out.println(e);
	
	fis = new FileInputStream(projectPath+"\\src\\test\\resources\\environment.properties");
	mainprop = new Properties();
	mainprop.load(fis);
	String e1 =  mainprop.getProperty("env");
	System.out.println(e1);
	
	fis = new FileInputStream(projectPath+"\\src\\test\\resources\\"+e1+".properties" );
	childprop = new Properties();
	childprop.load(fis);
	System.out.println(childprop.getProperty("amazonurl"));
	
	fis = new FileInputStream(projectPath+"\\src\\test\\resources\\or.properties");
	orprop = new Properties();
	orprop.load(fis);
//	orprop.getProperty("amazonurl");
	fis = new FileInputStream(projectPath+"\\src\\test\\resources\\log4jconfig.properties");
	PropertyConfigurator.configure(fis);
	report = ExtentManager.getInstance();
	}
		
public static void launch(String browser) throws Exception
{
	//if(p.getProperty(browser).equals("chrome"))
		if(browser.equals("chrome"))
	//if(p.getProperty(browser).equals("chrome"))
	{
			 WebDriverManager.chromedriver().setup();
		 ChromeOptions option = new ChromeOptions();
		 //option.addArguments("user-data-dir=C:\\Users\\ravi\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 5");
		 option.addArguments("--disable-notifications");
		 option.addArguments("--start-maximized");
		 //option.addArguments("--ignore-certificate-errors");*/
		
			driver = new ChromeDriver(option);
		//Thread.sleep(4000);
	}
	else if (browser.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else if(browser.equals("ie"))
	{
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();

	}
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
} 
		public static void navigateurl(String url) throws Exception
		{
			driver.get(childprop.getProperty(url));
			//Thread.sleep(4000);
			}	
//------------------------------------------------------------------------------------------------------				
		public static void selectOption(String locatorkey, String option) 
		{
			getElement(locatorkey).sendKeys(option);
			//driver.findElement(By.id(orprop.getProperty(locatorkey))).sendKeys(option);
			
		}
		
		public static void typeText(String locatorkey, String text) 
		{
			getElement(locatorkey).sendKeys(text);
		
			// driver.findElement(By.name(orprop.getProperty(locatorkey))).sendKeys(text);
		}
		public static void clickElement(String locatorkey) 
		{
		getElement(locatorkey).click();
		//WebElement element = driver.findElement(By.xpath(orprop.getProperty(locatorkey)));
		//element.click();
		}
//--------------------------------------------------------------------------------------------------
		public static WebElement getElement(String locatorkey) 
		{
			
			WebElement element = null;
			//check for element present
			if(!isElementPresent(locatorkey))
				//report as failure
				System.out.println("Element is not present:  "+locatorkey);
		element = driver.findElement(getLocator(locatorkey));
				
			/*if(locatorkey.endsWith("_id"))
			{
			element = driver.findElement(By.id(orprop.getProperty(locatorkey)));
			}
			else if(locatorkey.endsWith("_name"))
			{
				element = driver.findElement(By.name(orprop.getProperty(locatorkey)));
			}
			else if(locatorkey.endsWith("_classname"))
			{
				element = driver.findElement(By.className(orprop.getProperty(locatorkey)));
			}
			else if(locatorkey.endsWith("_xpath"))
			{
				element = driver.findElement(By.xpath(orprop.getProperty(locatorkey)));
			}
			else if(locatorkey.endsWith("_cssselector"))
			{
				element = driver.findElement(By.cssSelector(orprop.getProperty(locatorkey)));
			}
			else if(locatorkey.endsWith("_linktext"))
			{
				element = driver.findElement(By.partialLinkText(orprop.getProperty(locatorkey)));
			}
			else if(locatorkey.endsWith("_partiallinktext"))
			{
				element = driver.findElement(By.partialLinkText(orprop.getProperty(locatorkey)));
			}
			else
				System.out.println("please enter valid name");*/
			
			return element;
		}
///-------------------------------------------------------------------------------------------------		
		public static boolean isElementPresent(String locatorKey) 
		{
			System.out.println("Checking for Element presence :" + locatorKey );
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			return true;
			
			/*if(locatorKey.endsWith("_id")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orprop.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_name")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orprop.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_classname")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orprop.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_xpath")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orprop.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_cssselector")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orprop.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_linktext")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orprop.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_partiallinktext")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(orprop.getProperty(locatorKey))));
			}
			return true;*/	
			}
//-----------------------------------------------------------------------------------------------		
		public static By getLocator(String locatorKey) {
			By by = null;
			if(locatorKey.endsWith("_id"))
			{
				by = By.id(orprop.getProperty(locatorKey));
			}else if(locatorKey.endsWith("_name")) {
				by = By.name(orprop.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_className")) {
				by = By.className(orprop.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_xpath")) {
				by = By.xpath(orprop.getProperty(locatorKey));
			}
			return by;
		}
		
			// verifications
		public static boolean isLinkEqual(String expectedLink)
		{
			String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
			if(actualLink.equals(expectedLink))
			return true;
			else
				return false;
		}
		//reportings
		public static void reportPass(String passMessage) 
		{
		 test.log(Status.PASS, passMessage);	
			
		}

		public static void reportFailure(String failMessage) throws Exception 
		{
			
			test.log(Status.FAIL, failMessage);
			takesScreenshot();
		}
		public static void takesScreenshot() throws Exception
		{
			Date dt = new Date();
			 System.out.println(dt);
			 String	d = dt.toString().replace(':','_').replace(' ', '_')+".png";
			 File Scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileHandler.copy(Scrfile, new File(System.getProperty("user.dir")+"//failurescreenshots//"+d));
			 test.log(Status.INFO,"Screenshot---->"+test.addScreenCaptureFromPath(System.getProperty("user.dir")+"//failurescreenshots//"+d));
		}
public static int randomNum()
{
	Random r = new Random();
 int ran	= r.nextInt(99999);
 return ran;
}
public void dropDown(WebElement locator, String option)
{
	Select s = new Select(locator);
	//s.selectByVisibleText(option);
	s.selectByValue(option);
			
}
}
