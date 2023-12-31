package excelDataDriven;

import org.testng.annotations.Test;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;

public class DataManagementFinalVersion 
{
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> obj) 
  {
	  if(obj.get("RunMode").equals("N"))
		  throw new SkipException("testcase is skipped due to runmode set as N");
	  System.out.println(obj.get("UserName"));
	  System.out.println(obj.get("UserPassword"));
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

