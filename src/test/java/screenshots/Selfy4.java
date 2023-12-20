package screenshots;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy4 {

	public static void main(String[] args) throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https:\\www.google.com");
		
		List<WebElement> link4 =driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		for(int i=0;i<link4.size();i++)
		{
			Date dt = new Date();
			 
			 String	d = dt.toString().replace(':','_').replace(' ', '_');
			 
			String linkname	= link4.get(i).getText();
			link4.get(i).click();
			
			File Scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(Scrfile, new File("C:\\Users\\lenovo\\OneDrive\\Desktop\\Screenshots\\"+linkname+"_"+d+".png"));
			link4 =driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		}
		 

	}

}
