package selenium;

import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.slf4j.spi.LocationAwareLogger;

public class TC_003 extends BaseTest
{
	private static final Logger log = Logger.getLogger(TC_003.class);
	
	
	public static void main(String[] args) throws Exception 
	{
	 init();
	 log.info("init the properties files...");
	 launch("chromebrowser");
	 log.info("opening the browser..."+ p.getProperty("chromebrowser"));
	 
	 navigateurl("amazonurl");
	 log.info("navigate togo url..."+ childprop.getProperty("amazonurl"));
	 
	 selectOption("amazondropdown_id","Books");
	 log.info("selected the option books by usinglocator"+orprop.getProperty("amazondropdown_id"));
	 
	 typeText("amazonsearchtext_name","harry potter books set");
	 log.info("entering the text harry potter by using the locator"+orprop.getProperty("amazonsearchtext_name"));
	 
	 clickElement("amazonsearchbutton_xpath");
	 log.info("clicked the element by using locator : "+orprop.getProperty("amazonsearchbutton_xpath"));
	 
	 
	/* WebElement element = driver.findElement(By.id("searchDropdownBox"));
	 element.sendKeys("electronics");
	 
	 
	 driver.findElement(By.id("field-keywords")).sendKeys("iphone 14 pro max price");
	 
	 driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	 
	 driver.close();*/
	 

	}

	
	
}
