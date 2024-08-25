package testCases;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.ArrayPage;
import pageObjects.HomePage;

public class ArrayPageTests extends BaseClass{
	
	Logger logger = BaseClass.getLogger();	

	
	
	@Test
	public void Test_ArraysInPython()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());			
	    try {
			Hp.Login_HomePage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	
	
	

}
