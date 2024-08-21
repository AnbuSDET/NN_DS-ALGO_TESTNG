package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
	       	  //features={".//FeatureFiles/"},
		      //features={".//FeatureFiles/GetStarted.feature"},
		  	  features={".//FeatureFiles/Home.feature"},
			  //features ={".//FeatureFiles/Register.feature"},
		      //features ={".//FeatureFiles/SignIn.feature"},
			  //features={".//FeatureFiles/DataStructure.feature"},
		      //features={".//FeatureFiles/Array.feature"},
	          //features={".//FeatureFiles/LinkedList.feature"},
		      //features={".//FeatureFiles/Stack.feature"},
		      //features={".//FeatureFiles/Queue.feature"},
		 	  //features={".//FeatureFiles/Tree.feature"},
			  //features={".//FeatureFiles/Graph.feature"},
				     
			  glue = "stepDefinitions",
			  plugin = {"pretty", "html:reports/myreport.html", //----Cucumber Report
					   "rerun:target/rerun.txt",
					   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",//---Extent Report 
                       "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",//----Allure Report
					   "timeline:target/timeline" //-----Timeline report
					    },
			  dryRun = false,
			  monochrome = true,
			  publish = true
			  //tags="@sanity" 
			  //tags="@regression"
			  //tags="@sanity and @regression" 
			  //tags="@sanity and not @regression" 
			  //tags="@sanity or @regression"
			  
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	
  
  
}
