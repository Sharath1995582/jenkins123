package excelDataDriven;

public class ExcelDemo {

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e = new ExcelAPI("C:\\Users\\lenovo\\OneDrive\\Desktop\\testdata1.xlsx");
	System.out.println(e.getRowCount("Sheet1"));
	System.out.println(e.columnCount("Sheet1"));
	
	System.out.println(e.getCellData("Sheet1", 0, 1));
	System.out.println(e.getCellData("sheet1", "Password", 1));
	e.setCellData("Sheet1", 4, 3, "Aborted");

	}

}
