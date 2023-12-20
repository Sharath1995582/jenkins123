package selenium;

public class TC_001 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		launch("chrome");
		
		navigateurl("https://www.amazon.in");
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		  String url =driver.getCurrentUrl();
		  System.out.println(url);
		  
		  driver.manage().deleteAllCookies(); // to delete all cookies in browser
		  		  
		  
		  driver.navigate().back();// this method is used to do 'back'
		  
		  Thread.sleep(4000);
		  
		  driver.navigate().forward();// this method is used to do 'forward'
		  
		  Thread.sleep(10000);
		  
		  driver.navigate().refresh();// this will refresh the page
		  
		 // Thread.sleep(4000);
		  driver.close();// it will close only current window only
		  
		  driver.quit(); // it will close total chrome
	}

}
