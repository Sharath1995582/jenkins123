package excelDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws Exception {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		ExcelAPI e = new ExcelAPI("C:\\Users\\lenovo\\OneDrive\\Desktop\\testdata1.xlsx");
		
		for(int i = 1;i<e.getRowCount("Sheet1");i++)
		{
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(e.getCellData("Sheet1", 0, i));
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(e.getCellData("Sheet1", 1, i));
		Thread.sleep(3000);
		}
		

	}

}
