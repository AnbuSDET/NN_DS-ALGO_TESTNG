package factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal();
	private  static Properties property;
	private static Logger logger;
	
	
	public static void initializeBrowser(String browser) throws IOException
	{  
		if (browser.isEmpty()) {
			if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
					{
						DesiredCapabilities capabilities = new DesiredCapabilities();
						
						//------------------------os setup-------------------------
						if (getProperties().getProperty("os").equalsIgnoreCase("windows"))
							capabilities.setPlatform(Platform.WIN11);
						else if (getProperties().getProperty("os").equalsIgnoreCase("mac"))
							capabilities.setPlatform(Platform.MAC);
						else System.out.println("No Matching OS Found......");
										
						//-----------------browser setup----------------------------
					
						switch (getProperties().getProperty("browser").toLowerCase())
						{   
						case "chrome": capabilities.setBrowserName("chrome");break;
						case "edge":capabilities.setBrowserName("edge");break;
						default:System.out.println("No matching Browser found.......");
						}
						
						driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities));
						
					 }
			
			 else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
				   {  
				 	  switch(getProperties().getProperty("browser").toLowerCase())
						{  
						case "chrome":
							driver.set(ThreadGuard.protect(new ChromeDriver()));System.out.println("Testing in Chrome Browser"); break;
						case "edge":
							driver.set(ThreadGuard.protect(new EdgeDriver())); System.out.println("Testing in Edge Browser");break;
						case "safari":
							driver.set(ThreadGuard.protect(new SafariDriver()));System.out.println("Testing in Firefox Browser"); break;
						default:
							System.out.println("No matching Browser found.......");
						}
				    
					getDriver().manage().deleteAllCookies();
					getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					getDriver().get(property.getProperty("appURL"));
					//getDriver().manage().window().maximize();
			    }			
			
		 }
	
		
		else
		{ 
			switch(browser)
			{  
			case "chrome":
				driver.set(ThreadGuard.protect(new ChromeDriver()));System.out.println("Testing in Chrome Browser"); break;
			case "edge":
				driver.set(ThreadGuard.protect(new EdgeDriver())); System.out.println("Testing in Edge Browser");break;
			case "safari":
				driver.set(ThreadGuard.protect(new SafariDriver()));System.out.println("Testing in Firefox Browser"); break;
			default:
				System.out.println("No matching Browser found.......");
			}			
		
			getDriver().manage().deleteAllCookies();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("Im am here");
			BaseClass.getDriver().get(getProperties().getProperty("appURL"));
			//getDriver().manage().window().maximize();
		}
		
	}
	
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
		
	
	
	public synchronized static Properties getProperties() throws IOException
	{
		FileReader file = new FileReader(System.getProperty("user.dir")+".\\src\\test\\resources\\config.properties");
		property = new Properties();
		property.load(file);
		return property;
	}
	
	public static Logger getLogger()
	{
		logger = LogManager.getLogger();
		return logger;
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot) BaseClass.getDriver();		
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	public static String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	
	public static String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
		
	public static String randomAlphaNumeric()
	{
	 String str=RandomStringUtils.randomAlphabetic(5);
	 String num=RandomStringUtils.randomNumeric(5);
	 return str+num;
	}
	
	
}

