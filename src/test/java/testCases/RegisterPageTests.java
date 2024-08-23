package testCases;

import org.apache.logging.log4j.Logger;

import factory.BaseClass;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class RegisterPageTests extends BaseClass {
	Logger logger = BaseClass.getLogger();
	
	public void checkUsernameLinkDisplayAtHomePageAfterRegister() {
		logger.info("Verify the Username Link display at Home page after Registering a new user.............");
		
		GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
			sp.clickGetStartedSP();
		HomePage hp = new HomePage(BaseClass.getDriver());
			hp.clickRegisterLink();
		RegisterPage rp = new RegisterPage(BaseClass.getDriver());
		   rp.enterUsername(BaseClass.randomeString());
		   String pwd = BaseClass.randomAlphaNumeric();
		   rp.enterPassword(pwd);
		   rp.enterPasswordConfirm(pwd);
	}
	
}
