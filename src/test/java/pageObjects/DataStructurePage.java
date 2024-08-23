package pageObjects;


import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.BaseClass;
//import io.cucumber.messages.types.Duration;

public class DataStructurePage extends BasePage{

	public String PYEditor_Code = "'Numpy Ninja'";	
	
	public String ConsoleOutput="";
	public String Alertmesg ="";
	
	public DataStructurePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//-------------WebElements--------------
	
	@FindBy (xpath="//*[text()='Data Structures-Introduction']//following::a[1]")
	private WebElement DS_Introduction_GetStartedBtn;

	@FindBy (xpath="//*[@class='list-group-item']") 
	public WebElement TimeComplexityBtn;
	
	@FindBy(xpath="//*[@class='list-group-item list-group-item-light ']")
	private WebElement DS_TimeComplexity_LeftPanel;
	
	
	@FindBy(linkText="Practice Questions") 
	private WebElement PracticeQuestionsBtn;
	
	
	@FindBy (xpath="//*[@class='btn btn-info']")
	private WebElement TryHereBtn;	
	
	
	@FindBy (xpath = "//*[text()='Run']")
	private WebElement RunBtn;	
	
	@FindBy (xpath="//*[text()='Sign out']")
	private WebElement DS_Intro_SignOut;
	
	
	@FindBy (xpath="//div[@role='alert']")
	public WebElement DS_LogoutMessage;
	
	
	//-----------Methods---------
		
	
	public void click_GetStartedBtn_DSIroduction()
	{
		DS_Introduction_GetStartedBtn.click();
	}
	
	public void click_TimeComplexityBtn()
	{
		JavascriptExecutor jse = (JavascriptExecutor)BaseClass.getDriver();
		jse.executeScript("window.scrollBy(0,1000)"); 
		TimeComplexityBtn.click();
	}
	
	public void click_DS_PracticeQuestionsBtn()
	{
		PracticeQuestionsBtn.click();
	}
	
	
	public void click_DS_TimeComplexity_TryhereBtn()
	{
		JavascriptExecutor jse = (JavascriptExecutor)BaseClass.getDriver();
		jse.executeScript("window.scrollBy(0,1000)"); 
		TryHereBtn.click();		
	}
		
	public void click_DS_PythonEditor_RunBtn()
	{		
		Actions action= new Actions(BaseClass.getDriver());
		
		action.moveToElement(RunBtn).click().perform();		
	
	}
	
		
	// Python Editor ->  Without Codes
	public void Click_DS_PythonEditor_Runbtn_WithoutCodes()
	{
		BaseClass.getDriver().findElement(By.cssSelector(".CodeMirror-scroll")).click();
        JavascriptExecutor js=(JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("window.scrollTo(0,0)");	       
        BaseClass.getDriver().findElement(By.cssSelector("div:nth-child(1) > textarea")).sendKeys("");
        BaseClass.getDriver().findElement(By.cssSelector("button")).click();   
	}
	
	
	  // Python Editor -> Entering Valid Codes 
	public void Click_DS_PythonEditor_Runbtn_ValidCodes()		
	
	{	  		
		
			BaseClass.getDriver().findElement(By.cssSelector(".CodeMirror-scroll")).click();
	        JavascriptExecutor js=(JavascriptExecutor) BaseClass.getDriver();
	        js.executeScript("window.scrollTo(0,0)");	       
	        BaseClass.getDriver().findElement(By.cssSelector("div:nth-child(1) > textarea")).sendKeys("print "+PYEditor_Code);
	        BaseClass.getDriver().findElement(By.cssSelector("button")).click();   
		
	        
	}
	
	
	 // Python Editor -> Entering In-Valid Codes 
	public void Click_DS_PythonEditor_Runbtn_InValidCodes()
	{
		BaseClass.getDriver().findElement(By.cssSelector(".CodeMirror-scroll")).click();
        JavascriptExecutor js=(JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("window.scrollTo(0,0)");	       
        BaseClass.getDriver().findElement(By.cssSelector("div:nth-child(1) > textarea")).sendKeys("Print "+PYEditor_Code);
        BaseClass.getDriver().findElement(By.cssSelector("button")).click();  
		
	}
	
	
	// Python Editor -> Console OUTPUT -> For Valid Codes
	public void validate_Console_Output()
	{				
		WebElement result=BaseClass.getDriver().findElement(By.xpath("//*[@id='output']"));		
		
         ConsoleOutput=result.getText();  
        
	}
	
	// Python Editor -> Invalid Codes Validation (Alert Message)
	public void Validate_OutputConsole_InvalidCodes()
	{
		Alert alert = driver.switchTo().alert();		
		Alertmesg = alert.getText();
			
	}
	
	
	public void click_DS_TimeComplexity_LeftPanel()
	{
		DS_TimeComplexity_LeftPanel.click();
	}
	
	// Navigating to the PY_Editor Page
	
	public void DS_Pyhton_Editor_Page()
	{
		click_GetStartedBtn_DSIroduction();
		click_TimeComplexityBtn();
		click_DS_TimeComplexity_TryhereBtn();
	}
	
	
	// Clicking Sign out Button
	
	public void click_Signout_Btn()
	{
		DS_Intro_SignOut.click();
	}
	
	public Boolean SignOutErrorMessgae()
	{
				
		boolean status = DS_LogoutMessage.isDisplayed();
		return status;
	}
}
