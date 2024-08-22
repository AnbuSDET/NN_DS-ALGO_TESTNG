package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;

public class GetStartedPageTests extends BaseClass {
	
	Logger logger = BaseClass.getLogger();
	
	@Test (priority=1)
	public void TestGetStartedButton()  {
		logger.info("Clicking the GetStarted Button.............");
		GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
		sp.clickGetStartedSP();
		HomePage hp = new HomePage(BaseClass.getDriver());
		boolean status = hp.NumpyNinjaLinkDisplay();
		Assert.assertEquals(status, true ,"Home page is not displayed");	
		logger.info("Home page is displayed");
		}
	 
	
	@Test(priority=2)
	public void CopyrightNumpyNinja2021Display(){
		logger.info("Check the display of Copyright@NumpyNinja2021............");
		GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
		boolean status = sp.copyrightDisplay();
		Assert.assertTrue(status); 
		logger.info("Copyright@NumpyNinja2021 is displayed");
	}

}
