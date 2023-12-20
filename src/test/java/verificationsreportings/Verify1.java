package verificationsreportings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify1 {

	public static void main(String[] args) 
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https:\\www.amazon.in");
		
		 //String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		String actualLink = driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
		 System.out.println(actualLink);
		 String expectedLink = "Customer Ser";
		 
		 System.out.println("ActualLink : "+actualLink);
		 System.out.println("ExpectLink : "+expectedLink);
		 
		 //if(actualLink.equals(expectedLink))
		 //if(actualLink.equalsIgnoreCase(expectedLink))
		 if(actualLink.contains(expectedLink))
			 
			 System.out.println("both links are equal");
		 else
			 System.out.println("both links are not equal");
		 
		 	 
	}

	

}
