package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.BaseClass;


public class Hooks  {
	ThreadLocal<WebDriver> driver;
	Properties p;

	@BeforeMethod
	public void setup() throws Throwable
	{
		BaseClass.getLogger().info("Launch the app URL.........");
	    driver= BaseClass.initializeBrowser();
		p= BaseClass.getProperties();
		
		BaseClass.getDriver().get(p.getProperty("appURL"));
		BaseClass.getDriver().manage().window().maximize();
		BaseClass.getLogger().info("Application launched.......");
   	}
	
	
    @AfterMethod
	public void tearDown()
	{
    	BaseClass.getDriver().quit();
    	driver.remove();
	}
    
    
    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
}
