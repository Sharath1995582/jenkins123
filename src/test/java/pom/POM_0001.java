package pom;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.BaseTest;

public class POM_0001 extends BaseTest
{
	CustomerLogin obj;
	CustomerRegistrationPage page;
  @Test(enabled=false)
  public void f() 
  {
	obj = new CustomerLogin(driver);
	obj.cutomerLogin();
	obj.loginVerification();
	Assert.assertEquals(obj.loginVerification(), "Authentication failed.");
  }
  
  @Test
  public void customerReg() throws Exception
  {
	page = new CustomerRegistrationPage(driver);
	page.customerRegistration();
  }
  @BeforeMethod
  public void beforeMethod() throws Exception
  {
	  init();
	  launch("chromebrowser");
	  navigateurl("automationurl");
	  

  }
  @AfterMethod
  public void afterMethod()
  {
	  
  }
  
}
