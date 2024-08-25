package testCases;

import java.io.IOException;

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
	 
	public void checkValidAndInvalidLoginTest(String user, String pwd) {
		SignInPage sp= new SignInPage(BaseClass.getDriver());
		logger.info("Enter the username at login page.............");
		 sp.enterUsername(user);
		 sp.enterpassword(pwd);
		 sp.clickLogin();
		}
		 @Test(priority=4,groups="regression")
		 public void check_LinkedListHomePage()
		 {	
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
				 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			 lp.click_LLGetStarted();
			boolean status = lp.check_LLHomePage();
			 Assert.assertEquals(status, true);
			 logger.info("HomePage is displayed");
				 
		 }
		 
		 @Test(priority=4,groups="regression")
		 public void check_IntoductionTab()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			
			 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			 lp.click_LLGetStarted();
			 lp.click_Introduction();
			 boolean status=lp.check_IntroductionPage();
			 Assert.assertEquals(status, true);
			 logger.info("Introduction page is displayed");
		 }
		 
		 @Test(priority=4,groups="regression")
		 public void check_TryHereButton()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			
			 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			 lp.click_LLGetStarted();
				lp.click_Introduction();
			 lp.click_TryHereBtn();
			 boolean status=lp.check_TryEditorPage();
			 Assert.assertEquals(status, true);
			 logger.info("TryEditor page is displayed");
			 
		 }
	
		 @Test(priority=4,groups="regression")
		 public void check_PythonEditorValidInput()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
				
			 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			 	DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	
			 	lp.click_LLGetStarted();
			  lp.click_Introduction();
				  lp.click_TryHereBtn();
				  logger.info("Entering valid python code..........");
				  ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
				  ds.click_DS_PythonEditor_RunBtn();  
				  ds.validate_Console_Output();        
				  logger.info("Console output.......     " +ds.ConsoleOutput + ds.PYEditor_Code);
				  Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput) );
		
		 }
		 
		 @Test(priority=4,groups="regression")
		 public void check_PythonEditorInvalidInput()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			
			 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	  
			 lp.click_LLGetStarted();
			 lp.click_Introduction();
			 lp.click_TryHereBtn();
			 logger.info("User Entering invalid pythod code on the editor ..... ");
			 ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
			 ds.Validate_OutputConsole_InvalidCodes();
			 logger.info("Alert Message in Python Editor " + ds.Alertmesg);		
		     Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));
		        
		 }
		 
		 @Test(priority=4,groups="regression")
		 public void check_PythonEditorNoInput()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			
			 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	
			 lp.click_LLGetStarted();
			 lp.click_Introduction();
			 lp.click_TryHereBtn();
			 ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
			 String crntURL = BaseClass.getDriver().getCurrentUrl();
			 Assert.assertEquals(true, crntURL.contains("tryEditor"));
		
		 }
		 
		 @Test(priority=4,groups="regression")
		 public void check_CreatingLinkedListTab()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			lp.click_LLGetStarted();
			logger.info("Clicking the Creating Linked List page link.....");
    		lp.click_creatingLinkedList();
    		logger.info("Redirecting to CreatingLinkedListPage..............");
    		boolean check_URL=lp.check_CreatingLinkedListPage();
    		Assert.assertEquals(check_URL, true);
    		logger.info("Creating linked list page displayed......");
    		
		 }
		 
		 @Test(priority=4,groups="regression")
		 public void check_TypesOfLinkedListTab()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			lp.click_LLGetStarted();
			logger.info("user clicked types of linkd list link.........");
			lp.click_TypesOfLinkedList();
			logger.info("Redirecting to typesoflinkedlist page..............");
			boolean check_URL=lp.check_TypesOfLinkedListPage();
			Assert.assertEquals(check_URL, true);
			logger.info("Typesoflinkedlist page displayed......");
		
		 }
		
		 @Test(priority=4,groups="regression")
		 public void check_ImplementingLinkedListTab()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			lp.click_LLGetStarted();
			logger.info("user clicked Implementinglinkedlist link.........");
			lp.click_ImplementingLinkedList();
			logger.info("Redirecting to Implementinglinkedlist page..............");
			boolean check_URL=lp.check_ImplementingLinkedListPage();
			Assert.assertEquals(check_URL, true);
			logger.info("Implementinglinkedlist page displayed......");
		
		 }
		 
		 @Test(priority=4,groups="regression")
		 public void check_Traversal()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			lp.click_LLGetStarted();
			logger.info("user clicked Traversal link.........");
			lp.click_Traversal();
			logger.info("Redirecting to Traversal page..............");
			boolean check_URL=lp.check_Traversal();
			Assert.assertEquals(check_URL, true);
			logger.info("Traversal page displayed......");
		
		 }
		
		 @Test(priority=4,groups="regression")
		 public void check_Insertion()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			lp.click_LLGetStarted();
			logger.info("user clicked Insertion link.........");
			lp.click_Insertion();
			logger.info("Redirecting to Insertion page..............");
			boolean check_URL=lp.check_Insertion();
			Assert.assertEquals(check_URL, true);
			logger.info("Insertion page displayed......");
		
		 }
		 
		 @Test(priority=4,groups="regression")
		 public void check_Deletion()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			lp.click_LLGetStarted();
			logger.info("user clicked Deletion link.........");
			lp.click_Deletion();
			logger.info("Redirecting to Deletion page..............");
			boolean check_URL=lp.check_Deletion();
			Assert.assertEquals(check_URL, true);
			logger.info("Deletion page displayed......");
		
		 }
		 
		 @Test(priority=4,groups="regression")
		 public void check_LLPracticeQns()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
				try {
					Hp.Login_HomePage();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
			lp.click_LLGetStarted();
			lp.click_Introduction();
			lp.click_PracticeQns();
			boolean status=lp.check_LLPracticeQns();
			Assert.assertEquals(status, true);
			logger.info("redirected to practice qn page............");
				
			 
		 }
		
		
}
