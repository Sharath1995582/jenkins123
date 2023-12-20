package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReaderByColumnNumber
{

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\OneDrive\\Desktop\\testdata1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(1);
		String str = cell.getStringCellValue();
		System.out.println(str);
		wb.close();
		fis.close();
		
	/*   XSSFWorkbook wb = new XSSFWorkbook(fis);
	   XSSfSHEET sheet = 	wb.getsheet("sheet1");
	   XSSFROW row = 	sheet.getRow(1);
	   XSSFCELL cell = row.getCell(1);
	   String str = cell.getStringCellValue();
	   System.out.println(str);
	   wb.close();
	   fis.close();*/
	

	}

}
