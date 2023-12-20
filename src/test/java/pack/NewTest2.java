package pack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest2
{
  @Test(priority=-1)
  public void f()
  {
	  System.out.println("f");
  }
  @Test(priority=1,enabled = false)
  public void z()
  {
	  System.out.println("z");
  }
  
  @Test(priority=0)
  public void a()
  {
	  System.out.println("a");
  }

  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("beforemethod");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("aftermethod");
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("beforeclass");  
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("afterclass");
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("afterTest");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("beforesuite");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("aftersuite");
  }

}
