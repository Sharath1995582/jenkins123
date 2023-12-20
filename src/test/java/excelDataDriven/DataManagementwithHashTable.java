package excelDataDriven;

import org.testng.annotations.Test;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataManagementwithHashTable
{
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> str) 
  {
	  
	  
  }

  @DataProvider
  public Object[][] getData() throws Exception 
  {
	  ExcelAPI e = new ExcelAPI("C:\\Users\\lenovo\\OneDrive\\Desktop\\suites.xlsx");
		String SheetName = "data";
		String testName = "TestA";
		
		// to find matching testcase
		 int testStartRowNum = 0;
		 while (!e.getCellData(SheetName, 0, testStartRowNum).equals(testName))
		 {
			 testStartRowNum++;
		 }
		 System.out.println("Test start row number is : "+testStartRowNum);
		 int colStartRowNum = testStartRowNum+1;
		 int dataStartRowNum = testStartRowNum+2;
		 
		 // cal the row of data
		 int rows = 0;
		 while(!e.getCellData(SheetName, 0, dataStartRowNum+rows).equals(""))
		 {
			 rows++;
		 }
		 System.out.println("total rows are : "+ rows);
		 
		 
		 //cal  the cols of data
		 int cols = 0;
		 while(!e.getCellData(SheetName, cols, colStartRowNum).equals(""))
		 {
			 cols++;
		 }
		 System.out.println("total rows are : "+ cols);
		 
		 // read the test data
		 int dataRow = 0;
		 Object[][] data = new Object[rows][1];
		 Hashtable<String, String> table = null;
		 for(int rNum = dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		 {
			 table = new Hashtable<String, String>();
			 for(int cNum = 0; cNum<cols;cNum++)
			 {
				// System.out.println(e.getCellData(SheetName, cNum, rNum));
				// data[dataRow][cNum] =  e.getCellData(SheetName, cNum, rNum);
				 String  key = e.getCellData(SheetName, cNum, colStartRowNum);
				  String  value  =   e.getCellData(SheetName, cNum, rNum);
				  table.put(key, value);
				  
			 }
			 data[dataRow][0] = table;
			 
			 dataRow++;
    }
		 return data;
  }
}
