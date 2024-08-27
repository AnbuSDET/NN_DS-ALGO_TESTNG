
package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import factory.Hooks;
import pageObjects.DataStructurePage;
import pageObjects.HomePage;
import pageObjects.LinkedListPage;
import pageObjects.QueuePage;
import pageObjects.SignInPage;
import pageObjects.TreePage;


public class TreePageTests extends Hooks {

	Logger logger = BaseClass.getLogger();
	public void checkValidAndInvalidLoginTest(String user, String pwd) {
		SignInPage sp= new SignInPage(BaseClass.getDriver());
		logger.info("Enter the username at login page.............");
		 sp.enterUsername(user);
		 sp.enterpassword(pwd);
		 sp.clickLogin();
		}
	//TreeGetStarted

	 @Test(groups="regression")

	public void check_TreeHomePagelink()
	{
		
		HomePage Hp = new HomePage(BaseClass.getDriver());		
	    Hp.Login_HomePage();
	    Hp.clickTreeGetStarted();
	    TreePage Tp = new TreePage (BaseClass.getDriver()); 

	    Tp.check_TreeHomePagelink();

		 boolean status = Tp.check_TreeHomePagelink();
		 Assert.assertEquals(status, true);
		 logger.info("treeHomePage is displayed");
		
	}
	//OverviewofTree

	 @Test(groups="regression")

	 public void check_Overview_of_TreePage()
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());		
	     Hp.Login_HomePage();
	     TreePage Tp = new TreePage (BaseClass.getDriver());
		    Tp.click_TreeGetstarted();
		    Tp.click_OverviewofTreeLink();
		    logger.info("Overviewoftrees is displayed");
		    Tp.check_Overview_of_TreePage();
		    logger.info("Redirecting to OverviewofTreeLink page..............");
			boolean status = Tp.check_Overview_of_TreePage();
		    Assert.assertEquals(status, true);
		    logger.info("Overviewoftrees is displayed");
	 }
	//TryHereButton

	 @Test(groups="regression")

	 public void check_TryHereButton() 
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());		
	     Hp.Login_HomePage();
	     TreePage Tp = new TreePage (BaseClass.getDriver());
		 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	
		    Tp.click_TreeGetstarted();
		    Tp.click_OverviewofTreeLink();
		    Tp.check_Overview_of_TreePage();
		    Tp.clickTryHerebutton();
		    boolean status=Tp.check_TryEditorPage();
			 Assert.assertEquals(status, true);
			 logger.info("TryEditor page is displayed");
	 }
	 //PythonEditorValidInput

	 @Test(groups="regression")

	 public void check_PythonEditorValidInput() 
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());		
		 Hp.Login_HomePage();
		 TreePage Tp = new TreePage (BaseClass.getDriver());
		 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	
		 Tp.click_TreeGetstarted();
		    Tp.click_OverviewofTreeLink();
		    Tp.check_Overview_of_TreePage();
		    Tp.clickTryHerebutton();
		 logger.info("Entering valid python code..........");
		  ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
		  ds.click_DS_PythonEditor_RunBtn();  
		  ds.validate_Console_Output();     
			
			  logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
			  Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );
			  
	 }
	 //PythonEditorInvalidInput

	 @Test(groups="regression")

	 public void check_PythonEditorInvalidInput() 
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());		
	     Hp.Login_HomePage();
	     TreePage Tp = new TreePage (BaseClass.getDriver());
		 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	
		    Tp.click_TreeGetstarted();
		    Tp.click_OverviewofTreeLink();
		    Tp.check_Overview_of_TreePage();
		    Tp.clickTryHerebutton();
		 logger.info("User Entering invalid pythod code on the editor ..... ");
		 ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
		 ds.Validate_OutputConsole_InvalidCodes();
		 logger.info("Alert Message in Python Editor " + ds.Alertmesg);		
	     Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));
	        
	 }
	// PythonEditorNoInput

	 @Test(groups="regression")

	 public void check_PythonEditorNoInput() 
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());		
	     Hp.Login_HomePage();
	     TreePage Tp = new TreePage (BaseClass.getDriver());
		 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	
		    Tp.click_TreeGetstarted();
		    Tp.click_OverviewofTreeLink();
		    logger.info("user clicked OverviewofTreeLink link.........");
		    Tp.check_Overview_of_TreePage();
		    logger.info("Redirecting to OverviewofTreeLink page..............");
		    Tp.clickTryHerebutton();
		 ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		 String Current_URL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, Current_URL.contains("tryEditor"));
	
	 }
	 //terminologies


	 @Test(groups="regression")

	 public void check_terminologiesPage()
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());		
	     Hp.Login_HomePage();
	     TreePage Tp = new TreePage (BaseClass.getDriver());
	     Tp.click_TreeGetstarted();
	     Tp.click_terminologiesLink();
	     logger.info("user clicked  Terminologies link.........");
		    Tp.check_terminologiesPage();
      	logger.info("Redirecting to Terminologies page..............");
		 boolean Check_URL=Tp. check_terminologiesPage();
		Assert.assertEquals(Check_URL, true);
		logger.info("Terminologies page displayed......"); 
	 
	 }
	 
	//types_of_trees

	 @Test(groups="regression")

	 public void check_types_of_treesPage(){
		 HomePage Hp = new HomePage(BaseClass.getDriver());		
	     Hp.Login_HomePage();
	     TreePage Tp = new TreePage (BaseClass.getDriver());
	     Tp.click_TreeGetstarted();
	     Tp.click_types_of_treesLink();
	     
	     logger.info("user clicked  Typesoftree link.........");
		    Tp.check_types_of_treesPage();
      	logger.info("Redirecting to Typesoftree page..............");
		 boolean Check_URL=Tp.check_types_of_treesPage();
		Assert.assertEquals(Check_URL, true);
		logger.info("Typesoftree page displayed......"); 
	 
	 } 
	//tree-traversals

	 @Test(groups="regression")

	 public void click_tree_traversalsLink(){
		 HomePage Hp = new HomePage(BaseClass.getDriver());		
	     Hp.Login_HomePage();
	     TreePage Tp = new TreePage (BaseClass.getDriver());
	     Tp.click_TreeGetstarted();
	     Tp.click_tree_traversalsLink();;
	     
	     logger.info("user clicked  treetraversals Link .........");
		    Tp.check_tree_traversalsPage();
      	logger.info("Redirecting to treetraversals page..............");
		 boolean Check_URL=Tp.check_tree_traversalsPage();
		Assert.assertEquals(Check_URL, true);
		logger.info("treetraversals page displayed......"); 
	 
	 } 
		//traversals-illustration

	 @Test(groups="regression")

	 public void click_traversals_illustrationLink(){
		 HomePage Hp = new HomePage(BaseClass.getDriver());		
	     Hp.Login_HomePage();
	     TreePage Tp = new TreePage (BaseClass.getDriver());
	     Tp.click_TreeGetstarted();
	     Tp.click_traversals_illustrationLink();;
	     
	     logger.info("user clicked  traversals_illustrations Link .........");
		    Tp.check_traversals_illustrationPage();
      	logger.info("Redirecting to traversals_illustration page..............");
		 boolean Check_URL=Tp.check_traversals_illustrationPage();
		Assert.assertEquals(Check_URL, true);
		logger.info("traversals_illustration page displayed......"); 
	 
	 } 
		//binary-trees 

	 @Test(groups="regression")

	 public void click_binary_treesLink(){
		 HomePage Hp = new HomePage(BaseClass.getDriver());		
	     Hp.Login_HomePage();
	     TreePage Tp = new TreePage (BaseClass.getDriver());
	     Tp.click_TreeGetstarted();
	     Tp.click_binary_treesLink();
	      logger.info("user clicked  binary-trees  Link .........");
		    Tp.check_binary_treesPage();
      	logger.info("Redirecting to binary-trees  page..............");
		 boolean Check_URL=Tp.check_binary_treesPage();
		Assert.assertEquals(Check_URL, true);
		logger.info("binary-trees  page displayed......"); 
	 
	 } 
	 
		//types-of-binary-trees

	 @Test(groups="regression")

	 public void click_types_of_binary_treesLink() {
		 HomePage Hp = new HomePage(BaseClass.getDriver());		
	     Hp.Login_HomePage();
	     TreePage Tp = new TreePage (BaseClass.getDriver());
	     Tp.click_TreeGetstarted();
	     Tp.click_types_of_binary_treesLink();
	      logger.info("user clicked  types-of-binary-trees Link .........");
		    Tp.check_types_of_binary_treesPage();
      	logger.info("Redirecting to types-of-binary-trees  page..............");
		 boolean Check_URL=Tp.check_types_of_binary_treesPage();
		Assert.assertEquals(Check_URL, true);
		logger.info("types-of-binary-trees  page displayed......"); 
	 
	 } 
	//implementation-in-python

	 @Test(groups="regression")

	 public void click_implementation_in_pythonLink(){
		 HomePage Hp = new HomePage(BaseClass.getDriver());		
	     Hp.Login_HomePage();
	     TreePage Tp = new TreePage (BaseClass.getDriver());
	     Tp.click_TreeGetstarted();
	     Tp.click_implementation_in_pythonLink();
	      logger.info("user clicked  implementation-in-python Link .........");
		    Tp.check_implementation_in_pythonPage();
      	logger.info("Redirecting to implementation-in-python  page..............");
		 boolean Check_URL=Tp.check_implementation_in_pythonPage();
		Assert.assertEquals(Check_URL, true);
		logger.info("implementation-in-python  page displayed......"); 
	 
	 } 
	//Binary Tree Traversals

		 @Test(groups="regression")

		 public void click_BinaryTreeTraversalsLink(){
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
		     Hp.Login_HomePage();
		     TreePage Tp = new TreePage (BaseClass.getDriver());
		     Tp.click_TreeGetstarted();
		     Tp.click_BinaryTreeTraversalsLink();
		      logger.info("user clicked  Binary Tree Traversals Link .........");
			    Tp.check_BinaryTreeTraversalsPage();
	      	logger.info("Redirecting to Binary Tree Traversals  page..............");
			 boolean Check_URL=Tp.check_BinaryTreeTraversalsPage();
			Assert.assertEquals(Check_URL, true);
			logger.info("Binary Tree Traversals page displayed......"); 
		 
		 } 
		//Implementation of Binary Trees

		 @Test(groups="regression")

		 public void click_ImplementationofBinaryTreesLink(){
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
		     Hp.Login_HomePage();
		     TreePage Tp = new TreePage (BaseClass.getDriver());
		     Tp.click_TreeGetstarted();
		     Tp.click_ImplementationofBinaryTreesLink();
		      logger.info("user clicked Implementation of Binary Trees Link .........");
			    Tp.check_ImplementationofBinaryTreesPage();
			 boolean Check_URL= Tp.check_ImplementationofBinaryTreesPage();
			Assert.assertEquals(Check_URL, true);
			logger.info("Implementation of Binary Trees page displayed......"); 
		 
		 } 
		//Applications of Binary trees

		 @Test(groups="regression")

		 public void click_ApplicationsofBinarytreesLink(){
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
		     Hp.Login_HomePage();
		     TreePage Tp = new TreePage (BaseClass.getDriver());
		     Tp.click_TreeGetstarted();
		     Tp.click_ApplicationsofBinarytreesLink();
		      logger.info("user clicked Applications of Binary trees Link .........");
			    Tp.check_ApplicationsofBinarytreesPage();
			 boolean Check_URL=   Tp.check_ApplicationsofBinarytreesPage();
			Assert.assertEquals(Check_URL, true);
			logger.info("Applications of Binary trees page displayed......"); 
		 
		 }  
		//Binary Search Trees

		 @Test(groups="regression")

		 public void click_BinarySearchTreesLink(){
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
		     Hp.Login_HomePage();
		     TreePage Tp = new TreePage (BaseClass.getDriver());
		     Tp.click_TreeGetstarted();
		     Tp.click_BinarySearchTreesLink();
		      logger.info("user clicked Binary Search Trees Link .........");
			    Tp.check_BinarySearchTreesPage();
			 boolean Check_URL=   Tp.check_BinarySearchTreesPage();
			Assert.assertEquals(Check_URL, true);
			logger.info("Binary Search Trees page displayed......"); 
		 
		 }  
		//ImplementationOfBST

		 @Test(groups="regression")

		 public void click_ImplementationOfBSTLink() {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
		     Hp.Login_HomePage();
		     TreePage Tp = new TreePage (BaseClass.getDriver());
		     Tp.click_TreeGetstarted();
		     Tp.click_ImplementationOfBSTLink();
		      logger.info("user clicked ImplementationOfBST Link .........");
			    Tp.check_ImplementationOfBSTPage();
			 boolean Check_URL= Tp.check_ImplementationOfBSTPage();
			Assert.assertEquals(Check_URL, true);
			logger.info("ImplementationOfBST page displayed......"); 
		 
		 }
		//PracticeQns

		 @Test(groups="regression")

		 public void click_PracticeQnsLink()
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
			 Hp.Login_HomePage();
			 
			 TreePage Tp = new TreePage (BaseClass.getDriver());
			 Tp.click_TreeGetstarted();
			 Tp.click_ImplementationOfBSTLink();
		
			Tp.click_PracticeQnsLink();
			 logger.info("user clicked PracticeQns Link .........");
			Tp.check_PracticeQnsPage();
			boolean status = Tp.check_PracticeQnsPage();
			Assert.assertEquals(status, true);
			logger.info("redirected to practice qn page............");
				
			 
		 }
		
		 
}
