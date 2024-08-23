package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;


import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import utilities.DataProviders;

public class SignInPageTests extends BaseClass {
	
	Logger logger = BaseClass.getLogger();		
	@Test (dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void checkValidAndInvalidLoginTest(String user, String pwd, String result ) throws InterruptedException {
		logger.info("Enter the login details and click Login at login page using DDT.............");
		GetStartedPage gsp = new GetStartedPage(BaseClass.getDriver());
		 gsp.clickGetStartedSP();
		
		HomePage hp = new HomePage(BaseClass.getDriver());
		 hp.clickSigIn();
		
		SignInPage sp = new SignInPage(BaseClass.getDriver());	
		 sp.enterUsername(user);
		 sp.enterpassword(pwd);
		 sp.clickLogin();
	
	  	 if (result.equalsIgnoreCase("Valid")){
			 System.out.println("Valid");
			      boolean display = hp.YouAreLoggedInMsg();
					if (display==true) {
						Assert.assertTrue(true);
						logger.info("Test Passed");
					  }
					else{
						Assert.fail();
						logger.error("Test Failed");
					  }
			    }
			
			if (result.equalsIgnoreCase ("Invalid")){
				 System.out.println("InValid");
					boolean display = sp.InvalidUsrNamePwdErrorMsg();
					if (display==true){
						Assert.assertTrue(true);
						logger.info("Test Passed");
					   }
					else {
						Assert.assertTrue(false);
						logger.error("Test Failed");
					   }
		     	}
		
			
	
		 
	}
}

