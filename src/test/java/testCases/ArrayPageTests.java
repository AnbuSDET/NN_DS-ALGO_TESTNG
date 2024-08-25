package testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.ArrayPage;
import pageObjects.DataStructurePage;
import pageObjects.HomePage;

public class ArrayPageTests extends BaseClass{
	
	Logger logger = BaseClass.getLogger();	

	List<HashMap<String, String>> datamap;
	
	@Test
	public void Test_ArraysInPython()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());	
	    
			Hp.Login_HomePage();
		
	    Hp.clickArrayGetStarted();
	    ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
	    Ap.Click_ArraysInPython_Btn();
	   
	    String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    Assert.assertEquals(true, CurrentURL.contains("python"));
	}
	
	
	@Test
	public void Test_ArraysUsingList() throws IOException
	{
		
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
		Ap.Click_ArraysUsingList_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    Assert.assertEquals(true, CurrentURL.contains("using"));
	}
	
	@Test
	public void Test_BasicOpeartions() throws IOException
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
		Ap.Click_BasicOperations_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    Assert.assertEquals(true, CurrentURL.contains("operations"));
	}
	
	@Test
	public void Test_ApplicationsOfArray() throws IOException
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
		Ap.Click_ApplicationsOfArray_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    Assert.assertEquals(true, CurrentURL.contains("applications"));
	}
	
	
	
	// ********* Arrays in Python Page Scenarios
	
	
	@Test
	public void Test_TryHere_arraysInpython() throws IOException
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_TryhereBtn();
		 String CurURL= BaseClass.getDriver().getCurrentUrl();	    
		 Assert.assertEquals(true, CurURL.contains("tryEditor"));
		
	}
	
	@Test
	public void Test_ArraysInPython_EditorPage_ValidCodes()
	{
		
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
		Ap.Click_TryhereBtn();
		Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
		Dp.click_DS_PythonEditor_RunBtn();  
		Dp.validate_Console_Output();       
	       
	    logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);
	        
	     Assert.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );
		
	}
	
	@Test
	public void Test_ArraysInPython_EditorPage_InValidCodes()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();	
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_TryhereBtn();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());		
		Dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
		Dp.Validate_OutputConsole_InvalidCodes();
		logger.info("Alert Message in Python Editor " + Dp.Alertmesg);		
        Assert.assertEquals(true, Dp.Alertmesg.contains("bad input on line 1"));
		
	}
	
	@Test
	public void Test_ArraysInPython_EditorPage_WithoutCodes()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();	
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
		Ap.Click_TryhereBtn();
		Dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		String crntURL = BaseClass.getDriver().getCurrentUrl();
		Assert.assertEquals(true, crntURL.contains("tryEditor"));
	}
	
	
	
	
	// ******* Left Panel links Scenarios
	
	@Test
	public void Test_LeftPanel_ArraysInPython()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_LeftPanel_ArraysInPyhton_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    Assert.assertEquals(true, CurrentURL.contains("python"));
		
	}
	
	@Test
	public void Test_LeftPanel_ArraysUsingList()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_LeftPanel_ArraysUsingList_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    Assert.assertEquals(true, CurrentURL.contains("using"));
	}
	
	@Test
	public void Test_LeftPanel_BasicOperations()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_LeftPanel_BasicOpeartionsInList_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    Assert.assertEquals(true, CurrentURL.contains("operations"));
	}
	
	@Test
	public void Test_LeftPanel_ApplicationsOfArray()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_LeftPanel_ApplicationsOFArray_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    Assert.assertEquals(true, CurrentURL.contains("applications"));
	}
	
	@Test
	public void Test_LeftPanel_PracticeQuestions()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_PracticeQuestion_Btn();
		String CurrentURL= BaseClass.getDriver().getCurrentUrl();
		Assert.assertEquals(true, CurrentURL.contains("practice"));
		
	}
	
	
	
	
	
	
	
	
	
	
	/// Python Editor Search the array -> Valid and Invalid --> 
	

	 @Parameters({ "1" })
	 @Test
	public void Test_searchTheArray_PythonEditor_ValidCodes(@Optional("1") String Rownumber)
	{		
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_PracticeQuestion_Btn();
		Ap.Click_SearchTheArray_Btn();
		Ap.ExcelData_PythonEditor(Rownumber);
		Ap.ExcelData_PythonEditor_OutPutConsole_Validation(Rownumber);
		
	}
	
	 
	 @Parameters({ "2" })
	 @Test
	 public void Test_searchTheArray_PythonEditor_InValidCodes(@Optional("2") String Rownumber)
	 {
		   HomePage Hp = new HomePage(BaseClass.getDriver());
			Hp.Login_HomePage();
			Hp.clickArrayGetStarted();		
			ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
			Ap.Click_ArraysInPython_Btn();
			Ap.Click_PracticeQuestion_Btn();
			Ap.Click_SearchTheArray_Btn();
			Ap.ExcelData_PythonEditor(Rownumber);	
            Ap.ExcelData_PythonEditor_AlertValidation(Rownumber);
	 }
	 
	 
	//  Python Editor Max Consecutive one Page -> Valid and Invalid		 
	 
	 
	 @Parameters({ "3" })
	 @Test
	 public void Test_Maxconsectutive_PythonEditor_ValidCodes(@Optional("3") String Rownumber)
	 {
		   HomePage Hp = new HomePage(BaseClass.getDriver());
			Hp.Login_HomePage();
			Hp.clickArrayGetStarted();		
			ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
			Ap.Click_ArraysInPython_Btn();
			Ap.Click_PracticeQuestion_Btn();
			Ap.Click_MaxConsecutive_Btn();
			Ap.ExcelData_PythonEditor(Rownumber);
			Ap.ExcelData_PythonEditor_OutPutConsole_Validation(Rownumber);
	 }
	 
	 
	 @Parameters({ "4" })
	 @Test
	 public void Test_Maxconsectutive_PythonEditor_InValidCodes(@Optional("4") String Rownumber)
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());
			Hp.Login_HomePage();
			Hp.clickArrayGetStarted();		
			ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
			Ap.Click_ArraysInPython_Btn();
			Ap.Click_PracticeQuestion_Btn();
			Ap.Click_MaxConsecutive_Btn();
			Ap.ExcelData_PythonEditor(Rownumber);
			Ap.ExcelData_PythonEditor_AlertValidation(Rownumber);
	 }
	 
	 
	 // ******** Python Editor Find Numbers with Even number of digits -> Valid and Invalid	 
	 
	 
	 
	 @Parameters({ "5" })
	 @Test
	 public void Test_EvenNumbers_PythonEditor_ValidCodes(@Optional("5") String Rownumber)
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());
			Hp.Login_HomePage();
			Hp.clickArrayGetStarted();		
			ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
			Ap.Click_ArraysInPython_Btn();
			Ap.Click_PracticeQuestion_Btn(); 
			Ap.Click_EvenNumberQuestion_Btn();
			Ap.ExcelData_PythonEditor(Rownumber);
			Ap.ExcelData_PythonEditor_OutPutConsole_Validation(Rownumber);
	 }
	 
	 
	 @Parameters({ "6" })
	 @Test
	 public void Test_EvenNumbers_PythonEditor_InValidCodes(@Optional("6") String Rownumber)
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());
			Hp.Login_HomePage();
			Hp.clickArrayGetStarted();		
			ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
			Ap.Click_ArraysInPython_Btn();
			Ap.Click_PracticeQuestion_Btn();
			Ap.Click_EvenNumberQuestion_Btn();
			Ap.ExcelData_PythonEditor(Rownumber);
			Ap.ExcelData_PythonEditor_AlertValidation(Rownumber);
	 }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
