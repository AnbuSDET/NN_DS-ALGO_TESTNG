package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.SignInPage;

public class SignInPageTests {
	//--Comment
	Logger logger = BaseClass.getLogger();
	SignInPage sp = new SignInPage(BaseClass.getDriver());		
	
	@Test
	public void checkValidAndInvalidLoginTest(String user, String pwd ) {
		logger.info("Enter the username at login page.............");
		 sp.enterUsername(user);
		 sp.enterpassword(pwd);
		 sp.clickLogin();
		 
	}
}
