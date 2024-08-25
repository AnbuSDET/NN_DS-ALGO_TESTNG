package testCases;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import factory.BaseClass;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;
import utilities.DataProviders;

public class HomePageTests extends BaseClass{
	
	Logger logger = BaseClass.getLogger();
	
	  @Test (priority=1, groups ={"smoke","regression"}, dataProvider="GetStartedTopics", dataProviderClass=DataProviders.class)
	  public void clickGetStartedButtonWithoutSignIn(String topic) {
			logger.info("Clicking GetStarted button of any topic without Login....");
			GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
			sp.clickGetStartedSP();
			logger.info("Clicking the GetStarted Button at home page.............");
			HomePage hp = new HomePage(BaseClass.getDriver());
			hp.clickAnyGetStarted(topic);
			logger.info("Check the display of 'You are notlogged in' error message.............");
			boolean status = hp.NotLoggedInErrorMsg();
			Assert.assertTrue(status);				
	   }
	
	
      @Test (priority=2, groups ="regression", dataProvider="GetStartedTopics", dataProviderClass=DataProviders.class)
	  public void clickGetStartedButtonAfterSignIn(String topic) throws IOException {
			logger.info("Clicking GetStarted button of any topic AFTER Login....");
			HomePage hp = new HomePage(BaseClass.getDriver());
			hp.Login_HomePage();
			hp.clickAnyGetStarted(topic);
			logger.info("Verify that the "+topic+" page is displayed............");
			boolean status = false;
			status = hp.displayTopicPageOnGetStartedClick(topic);
			Assert.assertTrue(status);				
	   }
	
       @Test (priority=3, groups ="regression", dataProvider="DropdownTopics", dataProviderClass=DataProviders.class)
	   public void selectDataStructureDropdownTopicWithoutSignIn(String topic) throws InterruptedException {
			GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
			sp.clickGetStartedSP();
		    logger.info("User selects "+topic+" value of DataStructure dropdown....");
			HomePage hp = new HomePage(BaseClass.getDriver());
			hp.selectDropdownTopic(topic);
			logger.info("Check the display of 'You are notlogged in' error message.............");
			boolean status = hp.NotLoggedInErrorMsg();
			Assert.assertTrue(status);
    	}
	
	    @Test (priority=4, groups ={"smoke","regression"}, dataProvider="DropdownTopics", dataProviderClass=DataProviders.class)
    	public void selectDataStructureDropdownTopicAfterSignIn(String topic) throws InterruptedException, IOException {
			HomePage hp = new HomePage(BaseClass.getDriver());
			hp.Login_HomePage();
		    logger.info("User selects "+topic+" value of DataStructure dropdown....");
			hp.selectDropdownTopic(topic);
			logger.info("Verify that the "+topic+" page is displayed............");
			boolean status = false;
			status = hp.displayTopicPageOnGetStartedClick(topic);
			Assert.assertTrue(status);	
    	}
	
	    @Test (priority=5, dataProvider="GetStartedTopics", dataProviderClass=DataProviders.class)
		public void clickNumpyNinjaLinkFromTopicPagesAfterSignIn(String topic) throws IOException {
	    	logger.info("Clicking GetStarted button of "+topic+" AFTER Login....");
			HomePage hp = new HomePage(BaseClass.getDriver());
			hp.Login_HomePage();
			hp.clickAnyGetStarted(topic);
			logger.info("User clicks Numpy NInja link at top from "+topic+" page.........");
			hp.clickNumpyNinjaLink();
			logger.info("The Start page should be displayed.........");
			GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
			boolean status = sp.checkStartPageDisplay();
			Assert.assertTrue(status);				
		   }
		
		@Test (priority=6, groups ="regression")
		public void clickNumpyNinjaLinkFromHomePagesBeforeSignIn() {
			logger.info("Clicking NumpyNinja link from Home page without signing in....");
			GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
			sp.clickGetStartedSP();
			logger.info("The Start page should be displayed.............");
			HomePage hp = new HomePage(BaseClass.getDriver());
			hp.clickNumpyNinjaLink();
			boolean status = sp.checkStartPageDisplay();
			Assert.assertTrue(status);				
		}
		
		@Test (priority=7, groups ="regression")
		public void clickNumpyNinjaLinkFromHomePagesAfterSignIn() throws IOException {
			logger.info("Clicking NumpyNinja link from Home page AFTER signing in....");
			HomePage hp = new HomePage(BaseClass.getDriver());
			hp.Login_HomePage();
	    	logger.info("The Start page should be displayed...............");
			hp.clickNumpyNinjaLink();
			GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
			boolean status = sp.checkStartPageDisplay();
			Assert.assertTrue(status);				
		}
		
		@Test (priority=8, groups ="regression")
		public void clickNumpyNinjaLinkFromSignInPage() {
			  logger.info("Clicking NumpyNinja link from SignIn Page........");
			  GetStartedPage gsp = new GetStartedPage(BaseClass.getDriver());
			  gsp.clickGetStartedSP();
			  HomePage hp = new HomePage(BaseClass.getDriver());
			  hp.clickSigIn();
			  hp.clickNumpyNinjaLink();
			  GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
			  boolean status = sp.checkStartPageDisplay();
			  Assert.assertTrue(status);						
		}
			
		@Test (priority=9, groups ="regression")
		public void clickNumpyNinjaLinkFromRegisterPage() {
			  logger.info("Clicking NumpyNinja link from Register Page........");
			  GetStartedPage gsp = new GetStartedPage(BaseClass.getDriver());
			  gsp.clickGetStartedSP();
			  HomePage hp = new HomePage(BaseClass.getDriver());
			  hp.clickRegisterLink();
			  hp.clickNumpyNinjaLink();
			  boolean status = gsp.checkStartPageDisplay();
			  Assert.assertTrue(status);						
		}

}
