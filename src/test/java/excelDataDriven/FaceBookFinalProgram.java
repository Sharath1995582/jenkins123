package excelDataDriven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;

public class FaceBookFinalProgram 
{
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> obj)
  {
	ChromeOptions option  =new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver(option);
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com");
	 if(obj.get("RunMode").equals("N"))
		  throw new SkipException("testcase is skipped due to runmode set as N");
	driver.findElement(By.name("email")).sendKeys(obj.get("UserName"));
	driver.findElement(By.name("pass")).sendKeys(obj.get("UserPassword"));
	
  }

  @DataProvider
  public Object[][] getData() throws Exception 
  {
	  ExcelAPI e = new ExcelAPI("C:\\Users\\lenovo\\OneDrive\\Desktop\\suites.xlsx");
		String SheetName = "data";
		String testName = "LoginTest";
		return DataUtil.getTestData(e, SheetName, testName);
	 
       };
  }

