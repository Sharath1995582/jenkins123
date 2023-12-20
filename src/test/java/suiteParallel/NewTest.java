package suiteParallel;

import org.testng.annotations.Test;

public class NewTest
{
  @Test
  public void f() 
  {
	  System.out.println("iam test 1:"+Thread.currentThread().getId());
  }
  @Test
  public void f1() 
  {
	  System.out.println("iam test2 "+Thread.currentThread().getId());
  }
  @Test
  public void f3() 
  {
	  System.out.println("iam test3 :"+Thread.currentThread().getId());
  }
}
