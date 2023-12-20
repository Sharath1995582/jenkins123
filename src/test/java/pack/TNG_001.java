package pack;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import selenium.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TNG_001 extends BaseTest

{
   @BeforeMethod(groups = {"regression","sanity"})
   @Parameters("browser")
  public void startProcess(String btype) throws Exception 
  {
	   System.out.println("before method");
	   init();
		 test = report.createTest("TNG_001");
		 test.log(Status.INFO,"init the properties file");
		 
		// launch("chromebrowser");
		 launch(btype);
		 test.log(Status.PASS,"Opening the browse :"+ p.getProperty("chromebrowser"));
		 	 
		 navigateurl("amazonurl");
		 test.log(Status.FAIL,"navigate togo url...  "+ childprop.getProperty("amazonurl"));
	   
  }
 
   @Test(groups = {"regression","sanity"})
  public void amazon() 
  {
	   System.out.println("amazon test method");
	   selectOption("amazondropdown_id","Books");
		 test.log(Status.PASS,"selected the option books by usinglocator :"+orprop.getProperty("amazondropdown_id"));
		 
		 typeText("amazonsearchtext_name","harry potter");
		 test.log(Status.PASS, "entering the text harry potter by using the locator :"+orprop.getProperty("amazonsearchtext_name"));
		 
		 clickElement("amazonsearchbutton_xpath");
		 test.log(Status.PASS,"clicked the element by using locator : "+orprop.getProperty("amazonsearchbutton_id"));

	  
  }

  @AfterMethod(groups = {"regression","sanity"})
  public void endProcess()
  {
	  System.out.println("after method");
	  report.flush();
	  driver.quit();
  }

}
