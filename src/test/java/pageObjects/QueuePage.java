package pageObjects;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import factory.BaseClass;

public class QueuePage extends BasePage{

	Logger logger = BaseClass.getLogger();	
	
	public QueuePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());

	// Page Objects
	
	@FindBy (xpath = "//*[text()='Data Structures-Introduction']//following::a[5]")
	WebElement Queue_GetStartedBtn;
	
	// Queue Page Objects
	
	@FindBy (xpath = "//a[contains(text(),'Implementation of Queue in Python')]")
	WebElement ImpofQueue_Btn;
	
	@FindBy (xpath = "//a[contains(text(),'Implementation using collections.deque')]")
	WebElement ImpusingcollectionQueue_Btn;
	
	
	@FindBy (xpath = "//a[contains(text(),'Implementation using array')]")
	WebElement ImpUsingArray_Btn;
	
	
	@FindBy (xpath = "//a[contains(text(),'Queue Operations')]")	
	WebElement QueueOperation_Btn;
	
	
	// Implementation of Queue Page Objects		
	
	
	@FindBy (xpath = "//a[contains(text(),'Practice Questions')]")
	WebElement LeftPanel_PracticeQuestion_Btn;	
	
	
	

	public void Click_ImplementaionOfQueue()
	{
		ImpofQueue_Btn.click();
	}
	
	public void Click_ImplemenUsingCollectionOfQueue()
	{
		ImpusingcollectionQueue_Btn.click();
	}
	
	
	public void Click_ImplemenUsingArry()
	{
		ImpUsingArray_Btn.click();
	}
	
	public void Click_QueueOperation()
	{
		QueueOperation_Btn.click();
	}
	
	
	public void click_PracticeQuestions()
	{
		LeftPanel_PracticeQuestion_Btn.click();
	}
	
	
	
	public void Click_Tryhere()
	{
		DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		dp.click_DS_TimeComplexity_TryhereBtn();
	}
	
	
	
	public void Click_Getstarted_homePage_Queue()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());		
	    try {
			Hp.Login_HomePage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Hp.clickQueueGetStarted();
	}
	
	
	public void PythonEditor_ValidCodes_Validation_All()
	{
		 DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		 
		 logger.info("Entering valid python code..........");
		 dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
		 dp.validate_Console_Output();        
	       
	        logger.info("Console output.......     " +dp.ConsoleOutput_text + dp.PYEditor_Code);
	        
	        Assert.assertEquals(true,dp.PYEditor_Code.contains(dp.ConsoleOutput_text) );
	}
	
	
	public void PythonEditor_InValidCodes_Validation_All()
	{
		 logger.info("User Entering invalid pythod code on the editor ..... ");			
		 dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
		 dp.Validate_OutputConsole_InvalidCodes();
		 logger.info("Alert Message in Python Editor " + dp.Alertmesg);		
	     Assert.assertEquals(true, dp.Alertmesg.contains("bad input on line 1"));	 
	}
	
	public void PythonEditor_WithOutCodes_Validation_All()
	{
		 dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		 String crntURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, crntURL.contains("tryEditor"));
	}
	
	
	
	
}
