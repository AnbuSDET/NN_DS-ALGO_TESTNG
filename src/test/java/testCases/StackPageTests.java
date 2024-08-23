package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.DataStructurePage;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;
import pageObjects.LinkedListPage;
import pageObjects.SignInPage;
import pageObjects.StackPage;

public class StackPageTests extends BaseClass{

	Logger logger=BaseClass.getLogger();
	
	public void Login_HomePage() {
	    logger.info("User clicks the GetStarted Button at start page and clicks the Sign In.. ");
	    GetStartedPage gsp = new GetStartedPage(BaseClass.getDriver());
		gsp.clickGetStartedSP();
		HomePage hp =new HomePage(BaseClass.getDriver());
		hp.clickSigIn();	
		logger.info("User login with valid username and password..........");
		SignInPage sp = new SignInPage(BaseClass.getDriver());
		 sp.enterUsername("Testing");
		 sp.enterpassword("Password@143");
		 sp.clickLogin();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		stp.click_StGetStarted();
	}
	
	@Test
	public void check_StackHomePage()
	{
		 Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 boolean status = stp.check_StHomePage();
		 Assert.assertEquals(status, true);
		 logger.info("HomePage is displayed");
			 
	
	}
	
	@Test
	public void check_StackOperationspage()
	{
		 Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_Operations();
		 boolean status=stp.check_StOperationsPage();
		 Assert.assertEquals(status, true);
		 logger.info("Stack operations page is displayed.......");
		
	}
	
	@Test
	public void check_OperationsTryHereBtn()
	{
		Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_Operations();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
		 boolean status=lp.check_TryEditorPage();
		 Assert.assertEquals(status, true);
		 logger.info("python editor page is displayed..........");
	}
	
	@Test
	public void check_StackImplementationspage()
	{
		 Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_Implementations();
		 boolean status=stp.check_StImplementationsPage();
		 Assert.assertEquals(status, true);
		 logger.info("Stack implementation page is displayed.......");
		
	}
	
	@Test
	public void check_ImplementationTryHereBtn()
	{
		Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_Operations();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
		 boolean status=lp.check_TryEditorPage();
		 Assert.assertEquals(status, true);
		 logger.info("python editor page is displayed..........");
	}
	
	@Test
	public void check_StackApplicattionspage()
	{
		 Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_Applications();
		 boolean status=stp.check_StApplicationsPage();
		 Assert.assertEquals(status, true);
		 logger.info("Stack application page is displayed.......");
		
	}
	
	@Test
	public void check_ApplicationTryHereBtn()
	{
		Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_Applications();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
		 boolean status=lp.check_TryEditorPage();
		 Assert.assertEquals(status, true);
		 logger.info("python editor page is displayed..........");
	}
	
	
	@Test
	public void check_PythonEditorValidInput()
	{
		Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_Operations();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		  logger.info("Entering valid python code..........");
		  DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	  		  
		  ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
		  ds.click_DS_PythonEditor_RunBtn();  
		  ds.validate_Console_Output();        
		  logger.info("Console output.......     " +ds.ConsoleOutput + ds.PYEditor_Code);
		  Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput) );

	}
	
	 @Test
	 public void check_PythonEditorInvalidInput()
	 {
		 Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_Operations();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		 logger.info("User Entering invalid pythod code on the editor ..... ");
		 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());  
		 ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
		 ds.Validate_OutputConsole_InvalidCodes();
		 logger.info("Alert Message in Python Editor " + ds.Alertmesg);		
	     Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));
	        
	 }
	 
	 @Test
	 public void check_PythonEditorNoInput()
	 {
		 Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_Operations();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	  		  
		 ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		 String crntURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, crntURL.contains("tryEditor"));
	
	 }
	
	 @Test
	 public void check_StPracticeQns()
	 {
		 Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_Operations();
		 stp.click_StPracticeQns();
		boolean status=stp.check_StPracticeQnsPage();
		Assert.assertEquals(status, true);
		logger.info("redirected to practice qn page............");
			
		 
	 }
	
}
