package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAsserts {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:\\www.amazon.in");
		
	String actuallink = 	driver.findElement(By.linkText("Customer Service")).getText();
	String expectedlink = "Customer Services";
	
	/*
	 * if (actuallink.equals(expectedlink))
	 * System.out.println("both links are equal");
	 * 
	 * else System.out.println("both links are not equal");
	 */
	
	//Assert.assertEquals(actuallink, expectedlink);
	Assert.assertTrue(actuallink.equals(expectedlink), "both links are not equal");
	driver.findElement(By.linkText("Customer Service")).click();
		
	//	driver.close();
		

	}

}
