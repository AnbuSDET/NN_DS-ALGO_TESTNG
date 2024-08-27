package factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Hooks extends BaseClass{
		ThreadLocal<WebDriver> driver;
		Properties property;

		@BeforeMethod
		@Parameters ("browser")
		public void setup(String browser) throws Throwable
		{
			BaseClass.initializeBrowser(browser);
			
	   	}
		
		@AfterMethod
		public void tearDown()
		{
	    	BaseClass.getDriver().quit();
	    	
		} 	
		
		

	}



