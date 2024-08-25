package testCases;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.DataStructurePage;
import pageObjects.HomePage;
import pageObjects.QueuePage;

public class QueuePageTests extends BaseClass{
	
	
	Logger logger = BaseClass.getLogger();	
	
	 
	
	@Test  
	void Test_Queue_GetStarted() throws IOException
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());		
	    Hp.Login_HomePage();
	    Hp.clickQueueGetStarted();
		String CurntURL= BaseClass.getDriver().getCurrentUrl(); 
		Assert.assertEquals(true,CurntURL.contains("queue")); 
		logger.info("Queue Page URL --->" + CurntURL);
	}
	
	
	@Test
	void Test_ImplementationOf_Queue_InPython() throws IOException
	{		
		
	     QueuePage Qp = new QueuePage (BaseClass.getDriver());
	     Qp.Click_Getstarted_homePage_Queue();	     
		 Qp.Click_ImplementaionOfQueue();
		
		 String CrtURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, CrtURL.contains("lists"));	    
	}
	
	
	@Test
	 void Test_Implementation_UsingCollections_Queue()
	 {
		 QueuePage Qp = new QueuePage (BaseClass.getDriver());
	     Qp.Click_Getstarted_homePage_Queue();
	     Qp.Click_ImplemenUsingCollectionOfQueue();
	     String CurrentURL = BaseClass.getDriver().getCurrentUrl();
		Assert.assertEquals(true, CurrentURL.contains("collections"));
	 }
	
	
	@Test 
	 void Test_ImplementationUsing_Array()
	 {
		 logger.info("The user clicks the Implementation using Array link ........" );		  
		 QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplemenUsingArry();
		 String CurrentURL = BaseClass.getDriver().getCurrentUrl();
			Assert.assertEquals(true, CurrentURL.contains("array"));	
			logger.info("Implementation using Array link Current URL " + CurrentURL);
	 }
	
	@Test 
	 void Test_QueueOperations()
	 {
		 
		 QueuePage Qp = new QueuePage (BaseClass.getDriver());
		    Qp.Click_Getstarted_homePage_Queue();
			Qp.Click_QueueOperation();
			String CurrentURL = BaseClass.getDriver().getCurrentUrl();
			logger.info("After clicking Queue Operations link URL ... " +CurrentURL );
			Assert.assertEquals(true, CurrentURL.contains("QueueOp"));	
			
	 }
	
	@Test 
	 void Test_LEFTPanel_ImplementationOf_Queue_InPython()
	 {
		  QueuePage Qp = new QueuePage (BaseClass.getDriver());
		    Qp.Click_Getstarted_homePage_Queue();
		    Qp.Click_ImplementaionOfQueue();
		    Qp.Click_ImplementaionOfQueue();
		    String CurrentURL = BaseClass.getDriver().getCurrentUrl();
			Assert.assertEquals(true, CurrentURL.contains("lists")); 	    
		    
	 }
	
	 
	@Test 
	 void Test_LEFTPanel_Implementation_UsingCollections_Queue()
	 {
		 
		    QueuePage Qp = new QueuePage (BaseClass.getDriver());
		    Qp.Click_Getstarted_homePage_Queue();
		    Qp.Click_ImplementaionOfQueue();
		    logger.info("Clicking the Implementation using collections.queue  from the left panel links........ ");			
			Qp.Click_ImplemenUsingCollectionOfQueue();
		 String CurrentURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, CurrentURL.contains("collections"));
		 
	 }
	 
	@Test 
	 void Test_LEFTPanel_ImplementaionUsing_Array()
	 {
		 QueuePage Qp = new QueuePage (BaseClass.getDriver());
		    Qp.Click_Getstarted_homePage_Queue();
		    Qp.Click_ImplementaionOfQueue();
		    Qp.Click_ImplemenUsingArry();
		    String CurrentURL = BaseClass.getDriver().getCurrentUrl();
			Assert.assertEquals(true, CurrentURL.contains("array"));	
			logger.info("Implementation using Array link Current URL " + CurrentURL);
		 
	 }
	 
	@Test 
	 void Test_LEFTPanel_QueueOperations()
	 {
		    QueuePage Qp = new QueuePage (BaseClass.getDriver());
		    Qp.Click_Getstarted_homePage_Queue();
		    Qp.Click_ImplementaionOfQueue();
		    Qp.Click_QueueOperation();
		    String CurrentURL = BaseClass.getDriver().getCurrentUrl();
			logger.info("After clicking Queue Operations link URL ... " +CurrentURL );
			Assert.assertEquals(true, CurrentURL.contains("QueueOp"));	
			
	 
	 }
	 
	@Test 
	 void Test_LEFTPanel_PracticeQuestions()
	 {
		 logger.info("Clicking the Practice Questions  from the left panel links........ ");
			QueuePage Qp = new QueuePage (BaseClass.getDriver());
			Qp.Click_Getstarted_homePage_Queue();
		    Qp.Click_ImplementaionOfQueue();
			Qp.click_PracticeQuestions();
			String CurrentURL = BaseClass.getDriver().getCurrentUrl();
			Assert.assertEquals(true, CurrentURL.contains("practice"));
			
	 }
	 
	@Test 
	 void Test_TryHere_ImplementationOf_Queue_InPython()
	 {
		 QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplementaionOfQueue();
		  DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		  dp.click_DS_TimeComplexity_TryhereBtn();
		  String CurURL= BaseClass.getDriver().getCurrentUrl();		    
		   Assert.assertEquals(true, CurURL.contains("tryEditor"));
	 }
	 
	@Test 
	 void Test_PythonEditor_ImplementationOf_Queue_InPython_ValidCodes()
	 {		
		 QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplementaionOfQueue();
		 Qp.Click_Tryhere();
		 DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());		 	  		  
		 Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
		 Dp.click_DS_PythonEditor_RunBtn();  
		 Dp.validate_Console_Output();     
	     logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);	        
	     Assert.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );
		
	 }
	 
	@Test 
	 void Test_PythonEditor_ImplementationOf_Queue_InPython_InValidCodes()
	 {
		 
		 QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplementaionOfQueue();		 
		 Qp.Click_Tryhere();
		 DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		 logger.info("User Entering invalid pythod code on the editor ..... ");			
		 dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
		 dp.Validate_OutputConsole_InvalidCodes();
		 logger.info("Alert Message in Python Editor " + dp.Alertmesg);		
	     Assert.assertEquals(true, dp.Alertmesg.contains("bad input on line 1"));
		 
	 }
	 
	@Test 
	 void Test_PythonEditor_ImplementationOf_Queue_InPython_withOutCodes()
	 {
		 
		 QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplementaionOfQueue();		 
		 Qp.Click_Tryhere();
		 DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		 dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		 String crntURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, crntURL.contains("tryEditor"));
		
	 }
	 
	 
	 @Test
	 void Test_TryHere_Implementation_UsingCollections_Queue()
	 {
		 
		QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplemenUsingCollectionOfQueue();		
		 Qp.Click_Tryhere();		 
		 String crntURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, crntURL.contains("tryEditor"));
		 
	 }
	 
	 @Test
	 void Test_PythonEditor_Implementation_UsingCollections_Queue_ValidCodes()
	 {
		 
		QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplemenUsingCollectionOfQueue();
		 DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		 Qp.Click_Tryhere();
		 DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());		 	  		  
		 Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
		 Dp.click_DS_PythonEditor_RunBtn();  
		 Dp.validate_Console_Output();     
	     logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);	        
	     Assert.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );
	 }
	 
	 
	 @Test
	 void Test_PythonEditor_Implementation_UsingCollections_Queue_InValidCodes()
	 {
		 
		QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplemenUsingCollectionOfQueue();		
		 Qp.Click_Tryhere();
		 DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		 logger.info("User Entering invalid pythod code on the editor ..... ");			
		 dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
		 dp.Validate_OutputConsole_InvalidCodes();
		 logger.info("Alert Message in Python Editor " + dp.Alertmesg);		
	     Assert.assertEquals(true, dp.Alertmesg.contains("bad input on line 1"));
		
	 }
	 
	 @Test
	 void Test_PythonEditor_Implementation_UsingCollections_Queue_WithOutCodes()
	 {
		 QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplemenUsingCollectionOfQueue();		
		 Qp.Click_Tryhere();
		 DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		 dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		 String crntURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, crntURL.contains("tryEditor")); 
		 
	 }
	 
	 @Test
	 void Test_TryHere_Test_ImplementationUsing_Array()
	 {
		 QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplemenUsingArry();		
		 Qp.Click_Tryhere();		 
		 String crntURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, crntURL.contains("tryEditor"));
	 }
	 
	 
	 @Test
	 void Test_PythonEditor_ImplementationUsing_Array_ValidCodes()
	 {
		 
		QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplemenUsingArry();		
		 Qp.Click_Tryhere();
		 DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());		 	  		  
		 Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
		 Dp.click_DS_PythonEditor_RunBtn();  
		 Dp.validate_Console_Output();     
	     logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);	        
	     Assert.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );
		 
	 }
	 
	 @Test
	 void Test_PythonEditor_ImplementationUsing_Array_InValidCodes()
	 {
		QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplemenUsingArry();		
		 Qp.Click_Tryhere();
		 DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		 logger.info("User Entering invalid pythod code on the editor ..... ");			
		 dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
		 dp.Validate_OutputConsole_InvalidCodes();
		 logger.info("Alert Message in Python Editor " + dp.Alertmesg);		
	     Assert.assertEquals(true, dp.Alertmesg.contains("bad input on line 1"));		 
	 }
	 
	 
	 @Test
	 void Test_PythonEditor_ImplementationUsing_Array_WithOutCodes()
	 {
		QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_ImplemenUsingArry();		
		 Qp.Click_Tryhere();
		 DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		 dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		 String crntURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, crntURL.contains("tryEditor"));
	 }
	 
	 @Test
	 void Test_TryHere_QueueOperations()
	 {
		QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_QueueOperation();		
		 Qp.Click_Tryhere();
		 String crntURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, crntURL.contains("tryEditor"));
	 }
	 
	 
	 @Test
	 void Test_PythonEditor_QueueOperations_ValidCodes()
	 {
		 
		QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_QueueOperation();		
		 Qp.Click_Tryhere();
		 DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());		 	  		  
		 Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
		 Dp.click_DS_PythonEditor_RunBtn();  
		 Dp.validate_Console_Output();     
	     logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);	        
	     Assert.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );
	 }
	 
	 @Test
	 void Test_PythonEditor_QueueOperations_InValidCodes()
	 {
		 QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_QueueOperation();		
		 Qp.Click_Tryhere();
		 DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		 logger.info("User Entering invalid pythod code on the editor ..... ");			
		 dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
		 dp.Validate_OutputConsole_InvalidCodes();
		 logger.info("Alert Message in Python Editor " + dp.Alertmesg);		
	     Assert.assertEquals(true, dp.Alertmesg.contains("bad input on line 1"));
		
	 }
	 
	 @Test
	 void Test_PythonEditor_QueueOperations_WithOutCodes()
	 {
		QueuePage Qp = new QueuePage (BaseClass.getDriver());
		 Qp.Click_Getstarted_homePage_Queue();
		 Qp.Click_QueueOperation();		
		 Qp.Click_Tryhere();
		 DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		 dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		 String crntURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, crntURL.contains("tryEditor"));
	 }
	 
	 
}
