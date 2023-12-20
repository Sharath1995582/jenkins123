package screenshots;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy2 
{

	public static void main(String[] args) throws Exception 
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https:\\www.google.com");
		
		List<WebElement> links	=  driver.findElements(By.linkText("rajinikanth"));
		if(links.size()==0)
		{
		File Scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(Scrfile, new File("C:\\Users\\lenovo\\OneDrive\\Desktop\\Screenshots\\google.jpeg"));
		}
	
		
		

	}

}
