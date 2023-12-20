package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReaderByColumnName {

	public static void main(String[] args) throws Exception
	{
	FileInputStream  fis= new FileInputStream("C:\\Users\\lenovo\\OneDrive\\Desktop\\testdata1.xlsx");
	FileOutputStream fos = null;
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sht = wb.getSheet("Sheet1");
	XSSFRow row =  sht.getRow(0);
	
	int cellIndex = 0;
	for(int i = 0; i<row.getLastCellNum(); i++)
	{
		if(row.getCell(i).getStringCellValue().trim().equals("NoOfAttempts"))
			cellIndex = i;			
		
	}
	row = sht.getRow(2);
	XSSFCell cell =  row.getCell(cellIndex);
	
 String str = 	cell.getStringCellValue();
 System.out.println(str);
 wb.close();
 fis.close();
	
	}

}
