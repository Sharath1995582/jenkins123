package suiteA;

import org.testng.annotations.Test;

public class TestA2 {
  @Test
  public void f() throws Exception
  {
	  System.out.println("Starting TestA2: "+Thread.currentThread().getId());
	   Thread.sleep(4000);
	  
	  System.out.println("Ending TestA2: "+Thread.currentThread().getId());
  }
}
