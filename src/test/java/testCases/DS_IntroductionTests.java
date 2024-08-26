package testCases;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.DataStructurePage;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;




public class DS_IntroductionTests extends BaseClass {
	
	
	Logger logger = BaseClass.getLogger();	
	
	
	
	@Test (priority=0)
	void Test_DS_TimeComplexityLink()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());			
	    Hp.Login_HomePage();		
		 DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
		 Dp.click_GetStartedBtn_DSIroduction(); 
		 Dp.click_TimeComplexityBtn();
		  String CurrentURL =BaseClass.getDriver().getCurrentUrl();
		  Assert.assertEquals(true, CurrentURL.contains("array"));
		 
	}

	
	
	@Test  (priority=1)
	void Test_DS_TimeComplexity_Practice_Questions_link() 
	{
		
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());	
		HomePage Hp = new HomePage(BaseClass.getDriver());		
		Hp.Login_HomePage();		
		Dp.click_GetStartedBtn_DSIroduction();
		Dp.click_TimeComplexityBtn();
		Dp.click_DS_PracticeQuestionsBtn();
        String CurURL= BaseClass.getDriver().getCurrentUrl();		
		Assert.assertEquals(true, CurURL.contains("practice"));
		
	}
	
	
	
	
	@Test  (priority=2)
	void Test_LeftPanel_TimeComplexity()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());		
		Hp.Login_HomePage();	
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());		
		Dp.click_GetStartedBtn_DSIroduction();
		Dp.click_TimeComplexityBtn();	
		Dp.click_DS_TimeComplexity_LeftPanel();
		String CurrentURL =BaseClass.getDriver().getCurrentUrl();
		Assert.assertEquals(true, CurrentURL.contains("time"));
	}	
	
	
	
	@Test  (priority=3)
	void Test_DS_TryHere()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();	
	 DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
       Dp.click_GetStartedBtn_DSIroduction();
		Dp.click_TimeComplexityBtn();
		Dp.click_DS_TimeComplexity_TryhereBtn();
        String CurURL= BaseClass.getDriver().getCurrentUrl();	    
	    Assert.assertEquals(true, CurURL.contains("tryEditor"));
	}
	
	
	
	@Test  (priority=4)
	void DS_PythonEditor_ValidCodes()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());	   
			Hp.Login_HomePage();	
	
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
		
		logger.info("Clicking the Try Editor Page   ");
		Dp.DS_Pyhton_Editor_Page();
		 logger.info("Entering valid python code..........");
		  		  
		 Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
		 Dp.click_DS_PythonEditor_RunBtn();  
		 Dp.validate_Console_Output();        
	       
	     logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);
	        
	     Assert.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );
	}
	
	
	
	@Test  (priority=5)
	void DS_PythonEditor_InValidCodes()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());		
		Hp.Login_HomePage();	
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());		
		Dp.DS_Pyhton_Editor_Page();
		Dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
		Dp.Validate_OutputConsole_InvalidCodes();
		logger.info("Alert Message in Python Editor " + Dp.Alertmesg);		
        Assert.assertEquals(true, Dp.Alertmesg.contains("bad input on line 1"));
	}
	
	
	
	@Test  (priority=6)
	void DS_TimeComplexity_SignOutBtn()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());		
		Hp.Login_HomePage();	
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());				
		Dp.click_GetStartedBtn_DSIroduction();
		Dp.click_TimeComplexityBtn();
		Dp.click_Signout_Btn();		
		boolean status = Dp.SignOutErrorMessgae();
		Assert.assertTrue(status);
	}
	
	
	
	@Test  (priority=7)
	void DS_PythonEditor_WithoutCodes()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());		
		Hp.Login_HomePage();	
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
	
		  Dp.DS_Pyhton_Editor_Page();
		  Dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		  String crntURL = BaseClass.getDriver().getCurrentUrl();
		  Assert.assertEquals(true, crntURL.contains("tryEditor"));
	}
	
	
}
