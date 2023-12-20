package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {
	public static WebDriver driver;
	public static void main(String[] args) 
	{
		//System.setProperty("webdriver.chrome.driver","\"C:\\Users\\lenovo\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe\"");
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https:\\www.amazon.in");
	  

	}

}
