package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.slf4j.spi.LocationAwareLogger;

import com.aventstack.extentreports.Status;

public class TC_004 extends BaseTest
{
	private static final Logger log = Logger.getLogger(TC_003.class);
	
	
	public static void main(String[] args) throws Exception 
	{
	 init();
	 test = report.createTest("TC_004");
	 test.log(Status.INFO,"init the properties file");
	 
	 launch("chromebrowser");
	 test.log(Status.PASS,"Opening the browse :"+ p.getProperty("chromebrowser"));
	 	 
	 navigateurl("amazonurl");
	 test.log(Status.FAIL,"navigate togo url...  "+ childprop.getProperty("amazonurl"));
	 
	 selectOption("amazondropdown_id","Books");
	 test.log(Status.PASS,"selected the option books by usinglocator :"+orprop.getProperty("amazondropdown_id"));
	 
	 typeText("amazonsearchtext_name","harry potter");
	 test.log(Status.PASS, "entering the text harry potter by using the locator :"+orprop.getProperty("amazonsearchtext_name"));
	 
	 clickElement("amazonsearchbutton_xpath");
	 test.log(Status.PASS,"clicked the element by using locator : "+orprop.getProperty("amazonsearchbutton_id"));

	 report.flush();
	 
	/* WebElement element = driver.findElement(By.id("searchDropdownBox"));
	 element.sendKeys("electronics");
	 
	 
	 driver.findElement(By.id("field-keywords")).sendKeys("iphone 14 pro max price");
	 
	 driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	 
	 driver.close();*/
	 

	}

	
	
}
