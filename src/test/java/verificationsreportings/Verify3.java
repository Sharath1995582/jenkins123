package verificationsreportings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.BaseTest;

public class Verify3 extends BaseTest{

	public static void main(String[] args) throws Exception {
		/*ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https:\\www.amazon.in");*/
		init();
		 test = report.createTest("Verify3");
		 test.log(Status.INFO,"init the properties file");
		 
		 launch("chromebrowser");
		 test.log(Status.PASS,"Opening the browse :"+ p.getProperty("chromebrowser"));
		 	 
		 navigateurl("amazonurl");
		 test.log(Status.FAIL,"navigate togo url...  "+ childprop.getProperty("amazonurl"));
		
		 
		 String expectedLink = "Customer Serv";
		 
		 if(!isLinkEqual(expectedLink))
			 //System.out.println("both links are not equal..");
		 reportFailure("both links are not equal..");
		 else
			 //System.out.println("both links are not equal..");
		 reportPass("both links are equal..");
		 
		 report.flush();

	}



	

}
