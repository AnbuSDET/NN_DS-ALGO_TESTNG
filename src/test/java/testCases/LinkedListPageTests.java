package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.DataStructurePage;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;
import pageObjects.LinkedListPage;
import pageObjects.SignInPage;

public class LinkedListPageTests extends BaseClass {
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
		 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
		lp.click_LLGetStarted();
	}
		 @Test
		 public void check_LinkedListHomePage()
		 {	
			 Login_HomePage();
			 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			 boolean status = lp.check_LLHomePage();
			 Assert.assertEquals(status, true);
			 logger.info("HomePage is displayed");
				 
		 }
		 
		 @Test
		 public void check_IntoductionTab()
		 {
			
			 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			 Login_HomePage();
			 lp.click_Introduction();
			 boolean status=lp.check_IntroductionPage();
			 Assert.assertEquals(status, true);
			 logger.info("Introduction page is displayed");
		 }
		 
		 @Test
		 public void check_TryHereButton()
		 {
			 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			 Login_HomePage();
			 lp.click_Introduction();
			 lp.click_TryHereBtn();
			 boolean status=lp.check_TryEditorPage();
			 Assert.assertEquals(status, true);
			 logger.info("TryEditor page is displayed");
			 
		 }
	
		 @Test
		 public void check_PythonEditorValidInput()
		 {
			 	LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			 	Login_HomePage();
			 	DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	  		  
				  lp.click_Introduction();
				  lp.click_TryHereBtn();
				  logger.info("Entering valid python code..........");
				  ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
				  ds.click_DS_PythonEditor_RunBtn();  
				  ds.validate_Console_Output();     
				
				  logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
				  Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );
				  
		 }
		 
		 @Test
		 public void check_PythonEditorInvalidInput()
		 {
			 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			 Login_HomePage();
			 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	  		  
			 lp.click_Introduction();
			 lp.click_TryHereBtn();
			 logger.info("User Entering invalid pythod code on the editor ..... ");
			 ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
			 ds.Validate_OutputConsole_InvalidCodes();
			 logger.info("Alert Message in Python Editor " + ds.Alertmesg);		
		     Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));
		        
		 }
		 
		 @Test
		 public void check_PythonEditorNoInput()
		 {
			 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			 Login_HomePage();
			 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	  		  
			 lp.click_Introduction();
			 lp.click_TryHereBtn();
			 ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
			 String crntURL = BaseClass.getDriver().getCurrentUrl();
			 Assert.assertEquals(true, crntURL.contains("tryEditor"));
		
		 }
		 
		 @Test
		 public void check_CreatingLinkedListTab()
		 {
			 Login_HomePage();
			 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			logger.info("Clicking the Creating Linked List page link.....");
    		lp.click_creatingLinkedList();
    		logger.info("Redirecting to CreatingLinkedListPage..............");
    		boolean check_URL=lp.check_CreatingLinkedListPage();
    		Assert.assertEquals(check_URL, true);
    		logger.info("Creating linked list page displayed......");
    		
		 }
		 
		 @Test
		 public void check_TypesOfLinkedListTab()
		 {
			Login_HomePage();
			LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			logger.info("user clicked types of linkd list link.........");
			lp.click_TypesOfLinkedList();
			logger.info("Redirecting to typesoflinkedlist page..............");
			boolean check_URL=lp.check_TypesOfLinkedListPage();
			Assert.assertEquals(check_URL, true);
			logger.info("Typesoflinkedlist page displayed......");
		
		 }
		
		 @Test
		 public void check_ImplementingLinkedListTab()
		 {
			Login_HomePage();
			LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			logger.info("user clicked Implementinglinkedlist link.........");
			lp.click_ImplementingLinkedList();
			logger.info("Redirecting to Implementinglinkedlist page..............");
			boolean check_URL=lp.check_ImplementingLinkedListPage();
			Assert.assertEquals(check_URL, true);
			logger.info("Implementinglinkedlist page displayed......");
		
		 }
		 
		 @Test
		 public void check_Traversal()
		 {
			Login_HomePage();
			LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			logger.info("user clicked Traversal link.........");
			lp.click_Traversal();
			logger.info("Redirecting to Traversal page..............");
			boolean check_URL=lp.check_Traversal();
			Assert.assertEquals(check_URL, true);
			logger.info("Traversal page displayed......");
		
		 }
		
		 @Test
		 public void check_Insertion()
		 {
			Login_HomePage();
			LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			logger.info("user clicked Insertion link.........");
			lp.click_Insertion();
			logger.info("Redirecting to Insertion page..............");
			boolean check_URL=lp.check_Insertion();
			Assert.assertEquals(check_URL, true);
			logger.info("Insertion page displayed......");
		
		 }
		 
		 @Test
		 public void check_Deletion()
		 {
			Login_HomePage();
			LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			logger.info("user clicked Deletion link.........");
			lp.click_Deletion();
			logger.info("Redirecting to Deletion page..............");
			boolean check_URL=lp.check_Deletion();
			Assert.assertEquals(check_URL, true);
			logger.info("Deletion page displayed......");
		
		 }
		 
		 
		
		
}
