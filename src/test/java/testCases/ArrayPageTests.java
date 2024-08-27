package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import factory.BaseClass;
import pageObjects.ArrayPage;
import pageObjects.DataStructurePage;
import pageObjects.HomePage;

public class ArrayPageTests extends BaseClass{
	
	Logger logger = BaseClass.getLogger();	

	List<HashMap<String, String>> datamap;

	
	@Test (priority=0)
	public void Test_ArraysInPython()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());	
	    
			Hp.Login_HomePage();
		
	    Hp.clickArrayGetStarted();
	    ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
	    Ap.Click_ArraysInPython_Btn();
	   
	    String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    AssertJUnit.assertEquals(true, CurrentURL.contains("python"));
	}
	
	
	@Test  (priority=1)
	public void Test_ArraysUsingList() 
	{
		
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
		Ap.Click_ArraysUsingList_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    AssertJUnit.assertEquals(true, CurrentURL.contains("using"));
	}
	
	@Test  (priority=2)
	public void Test_BasicOpeartions() 
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
		Ap.Click_BasicOperations_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    AssertJUnit.assertEquals(true, CurrentURL.contains("operations"));
	}
	
	@Test  (priority=3)
	public void Test_ApplicationsOfArray() 
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
		Ap.Click_ApplicationsOfArray_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    AssertJUnit.assertEquals(true, CurrentURL.contains("applications"));
	}
	
	
	
	// ********* Arrays in Python Page Scenarios
	
	
	@Test  (priority=4)
	public void Test_TryHere_arraysInpython() 
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_TryhereBtn();
		 String CurURL= BaseClass.getDriver().getCurrentUrl();	    
		 AssertJUnit.assertEquals(true, CurURL.contains("tryEditor"));
		
	}
	
	@Test  (priority=5)
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
	        
	     AssertJUnit.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );
		
	}
	
	@Test  (priority=6)
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
        AssertJUnit.assertEquals(true, Dp.Alertmesg.contains("bad input on line 1"));
		
	}
	
	@Test  (priority=7)
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
		AssertJUnit.assertEquals(true, crntURL.contains("tryEditor"));
	}
	
	
	//  Arrays using list page Scenarios
	
	
	@Test  (priority=8)
	public void Test_TryHere_arraysUsingList() 
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysUsingList_Btn();
		Ap.Click_TryhereBtn();
		 String CurURL= BaseClass.getDriver().getCurrentUrl();	    
		 AssertJUnit.assertEquals(true, CurURL.contains("tryEditor"));
		
	}
	
	
	@Test  (priority=9)
	public void Test_arraysUsingList_EditorPage_ValidCodes()
	{
		
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysUsingList_Btn();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
		Ap.Click_TryhereBtn();
		Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
		Dp.click_DS_PythonEditor_RunBtn();  
		Dp.validate_Console_Output();       
	       
	    logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);
	        
	     AssertJUnit.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );
		
	}
	
	
	
	@Test  (priority=10)
	public void Test_arraysUsingList_EditorPage_InValidCodes()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();	
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysUsingList_Btn();
		Ap.Click_TryhereBtn();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());		
		Dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
		Dp.Validate_OutputConsole_InvalidCodes();
		logger.info("Alert Message in Python Editor " + Dp.Alertmesg);		
        AssertJUnit.assertEquals(true, Dp.Alertmesg.contains("bad input on line 1"));
		
	}
	
	
	@Test  (priority=11)
	public void Test_arraysUsingList_EditorPage_WithoutCodes()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();	
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysUsingList_Btn();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
		Ap.Click_TryhereBtn();
		Dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		String crntURL = BaseClass.getDriver().getCurrentUrl();
		AssertJUnit.assertEquals(true, crntURL.contains("tryEditor"));
	}
	
	
	
	// Basic Operations Page Scenarios
	
	
	@Test  (priority=12)
	public void Test_TryHere_basicOpeartions() 
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_BasicOperations_Btn();		
		Ap.Click_TryhereBtn();
		 String CurURL= BaseClass.getDriver().getCurrentUrl();	    
		 AssertJUnit.assertEquals(true, CurURL.contains("tryEditor"));
		
	}
	
	
	@Test  (priority=13)
	public void Test_basicOpeartions_EditorPage_ValidCodes()
	{
		
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_BasicOperations_Btn();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
		Ap.Click_TryhereBtn();
		Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
		Dp.click_DS_PythonEditor_RunBtn();  
		Dp.validate_Console_Output();       
	       
	    logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);
	        
	     AssertJUnit.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );
		
	}
	
	
	
	@Test  (priority=14)
	public void Test_basicOpeartions_EditorPage_InValidCodes()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();	
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_BasicOperations_Btn();
		Ap.Click_TryhereBtn();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());		
		Dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
		Dp.Validate_OutputConsole_InvalidCodes();
		logger.info("Alert Message in Python Editor " + Dp.Alertmesg);		
        AssertJUnit.assertEquals(true, Dp.Alertmesg.contains("bad input on line 1"));
		
	}
	
	
	@Test  (priority=15)
	public void Test_basicOpeations_EditorPage_WithoutCodes()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();	
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_BasicOperations_Btn();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
		Ap.Click_TryhereBtn();
		Dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		String crntURL = BaseClass.getDriver().getCurrentUrl();
		AssertJUnit.assertEquals(true, crntURL.contains("tryEditor"));
	}
	
	// Applications of array Page Scenarios
	
	
	
	
	@Test  (priority=16)
	public void Test_TryHere_applicationsOfArray() 
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ApplicationsOfArray_Btn();		
		Ap.Click_TryhereBtn();
		 String CurURL= BaseClass.getDriver().getCurrentUrl();	    
		 AssertJUnit.assertEquals(true, CurURL.contains("tryEditor"));
		
	}
	
	

	@Test  (priority=17)
	public void Test_applicationsOfArray_EditorPage_ValidCodes()
	{
		
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ApplicationsOfArray_Btn();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
		Ap.Click_TryhereBtn();
		Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
		Dp.click_DS_PythonEditor_RunBtn();  
		Dp.validate_Console_Output();       
	       
	    logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);
	        
	     AssertJUnit.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );
		
	}
	
	
	
	
	
	@Test  (priority=18)
	public void Test_applicationsOfarray_EditorPage_InValidCodes()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();	
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ApplicationsOfArray_Btn();
		Ap.Click_TryhereBtn();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());		
		Dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
		Dp.Validate_OutputConsole_InvalidCodes();
		logger.info("Alert Message in Python Editor " + Dp.Alertmesg);		
        AssertJUnit.assertEquals(true, Dp.Alertmesg.contains("bad input on line 1"));
		
	}
	
	

	@Test  (priority=19)
	public void Test_applicationsOfArray_EditorPage_WithoutCodes()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();	
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ApplicationsOfArray_Btn();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
		Ap.Click_TryhereBtn();
		Dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		String crntURL = BaseClass.getDriver().getCurrentUrl();
		AssertJUnit.assertEquals(true, crntURL.contains("tryEditor"));
	}
	
	
	
	// ******* Left Panel links Scenarios
	
	@Test  (priority=20)
	public void Test_LeftPanel_ArraysInPython()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_LeftPanel_ArraysInPyhton_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    AssertJUnit.assertEquals(true, CurrentURL.contains("python"));
		
	}
	
	@Test  (priority=21)
	public void Test_LeftPanel_ArraysUsingList()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_LeftPanel_ArraysUsingList_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    AssertJUnit.assertEquals(true, CurrentURL.contains("using"));
	}
	
	@Test  (priority=22)
	public void Test_LeftPanel_BasicOperations()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_LeftPanel_BasicOpeartionsInList_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    AssertJUnit.assertEquals(true, CurrentURL.contains("operations"));
	}
	
	@Test  (priority=23)
	public void Test_LeftPanel_ApplicationsOfArray()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_LeftPanel_ApplicationsOFArray_Btn();
		String CurrentURL = BaseClass.getDriver().getCurrentUrl();
	    AssertJUnit.assertEquals(true, CurrentURL.contains("applications"));
	}
	
	@Test  (priority=24)
	public void Test_LeftPanel_PracticeQuestions()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		Hp.clickArrayGetStarted();		
		ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
		Ap.Click_ArraysInPython_Btn();
		Ap.Click_PracticeQuestion_Btn();
		String CurrentURL= BaseClass.getDriver().getCurrentUrl();
		AssertJUnit.assertEquals(true, CurrentURL.contains("practice"));
		
	}	
	
	
	/// Python Editor Search the array -> Valid and Invalid --> 
	

	 @Parameters({ "1" })
	 @Test  (priority=25)
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
	 @Test  (priority=26)
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
	 @Test  (priority=27)
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
	 @Test  (priority=28)
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
	 @Test  (priority=29)
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
	 @Test  (priority=30)
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

	 
	 
	 
	//  Python Editor Squares of Sorted array -> Valid and Invalid
	 
	 
	 @Parameters({ "7" })
	 @Test  (priority=31)
	 public void Test_SortedSquares_PythonEditor_ValidCodes(@Optional("7") String Rownumber)
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());
			Hp.Login_HomePage();
			Hp.clickArrayGetStarted();		
			ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
			Ap.Click_ArraysInPython_Btn();
			Ap.Click_PracticeQuestion_Btn();
			Ap.Click_SortedSquared_Ctn();
			Ap.ExcelData_PythonEditor(Rownumber);
			Ap.ExcelData_PythonEditor_OutPutConsole_Validation(Rownumber);
	 }
	 
	 
	 @Parameters({ "8" })
	 @Test  (priority=32)
	 public void Test_SortedSquares_PythonEditor_InValidCodes(@Optional("8") String Rownumber)
	 {
		    HomePage Hp = new HomePage(BaseClass.getDriver());
			Hp.Login_HomePage();
			Hp.clickArrayGetStarted();		
			ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
			Ap.Click_ArraysInPython_Btn();
			Ap.Click_PracticeQuestion_Btn();
			Ap.Click_SortedSquared_Ctn();
			Ap.ExcelData_PythonEditor(Rownumber);			
			Ap.ExcelData_PythonEditor_AlertValidation(Rownumber);
	 }
	 
	 
	 
	// Search the array  ->Submit button # Negative Scenario --> It will fail  --> Bug
	 
	 @Parameters({ "9" })
	 @Test  (priority=33)
	 public void Test_searchThearray_PythonEditor_ValidCodes_SubmitBtn(@Optional("9") String Rownumber)
	 {
		 
		 HomePage Hp = new HomePage(BaseClass.getDriver());
			Hp.Login_HomePage();
			Hp.clickArrayGetStarted();		
			ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
			Ap.Click_ArraysInPython_Btn();
			Ap.Click_PracticeQuestion_Btn();
			Ap.Click_SearchTheArray_Btn();
			Ap.Click_Submit_Btn_ExcelData_ValidCodes(Rownumber);
			Ap.ExcelData_PythonEditor_OutPutConsole_Validation(Rownumber);
	 }
	 
	 
	// Testing the Submit button with valid codes in Max Consecutive one Page Python Editor
		
	
	 @Parameters({ "10" })
	 @Test  (priority=34)
	 public void Test_MaxConsecutive_PythonEditor_ValidCodes_SubmitBtn(@Optional("10") String Rownumber)
	 {		 

		   HomePage Hp = new HomePage(BaseClass.getDriver());
			Hp.Login_HomePage();
			Hp.clickArrayGetStarted();		
			ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
			Ap.Click_ArraysInPython_Btn();
			Ap.Click_PracticeQuestion_Btn();
			Ap.Click_MaxConsecutive_Btn();
			Ap.Click_Submit_Btn_ExcelData_ValidCodes(Rownumber);
			Ap.ExcelData_PythonEditor_OutPutConsole_Validation(Rownumber);
	 }
	 
	// Testing the Submit button with valid codes in Find Numbers with Even number of digits question page Python Editor
	 
	 @Parameters({ "11" })
	 @Test  (priority=35)
	 public void Test_evenNumbers_PythonEditor_ValidCodes_SubmitBtn(@Optional("11") String Rownumber)
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());
			Hp.Login_HomePage();
			Hp.clickArrayGetStarted();		
			ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
			Ap.Click_ArraysInPython_Btn();
			Ap.Click_PracticeQuestion_Btn();
			Ap.Click_EvenNumberQuestion_Btn();
			Ap.Click_Submit_Btn_ExcelData_ValidCodes(Rownumber);
			Ap.ExcelData_PythonEditor_OutPutConsole_Validation(Rownumber);
	 }
	 
	 
	// Testing the Submit button valid codes in Squares of a Sorted Array
	 
	 @Parameters({ "12" }) 
	 @Test  (priority=36)
	 public void Test_sortedSquares_PythonEditor_ValidCodes_SubmitBtn(@Optional("12") String rownumber)
	 {
		 
		 HomePage Hp = new HomePage(BaseClass.getDriver());
			Hp.Login_HomePage();
			Hp.clickArrayGetStarted();		
			ArrayPage Ap = new ArrayPage(BaseClass.getDriver());		
			Ap.Click_ArraysInPython_Btn();
			Ap.Click_PracticeQuestion_Btn();
			Ap.Click_SortedSquared_Ctn();
			Ap.Click_Submit_Btn_ExcelData_ValidCodes(rownumber);
			Ap.ExcelData_PythonEditor_OutPutConsole_Validation(rownumber);
			
	 }
	 
}
