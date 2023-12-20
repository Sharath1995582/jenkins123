package excelDataDriven;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataManagementwithDataProvider
{
  @Test(dataProvider = "getData")
  public void f(String RunMode,String Browser,String UserName, String UserPassword /*String ExpectedResult*/) 
  {
	  
	  
  }

  @DataProvider
  public Object[][] getData() throws Exception 
  {
	  ExcelAPI e = new ExcelAPI("C:\\Users\\lenovo\\OneDrive\\Desktop\\suites.xlsx");
		String SheetName = "data";
		String testName = "TestB";
		
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
		 Object[][] data = new Object[rows][cols];
		 for(int rNum = dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		 {
			 for(int cNum = 0; cNum<cols;cNum++)
			 {
				// System.out.println(e.getCellData(SheetName, cNum, rNum));
				data[dataRow][cNum] =  e.getCellData(SheetName, cNum, rNum);
				 
			 }
			 dataRow++;
    }
		 return data
				 ;
  }
}
