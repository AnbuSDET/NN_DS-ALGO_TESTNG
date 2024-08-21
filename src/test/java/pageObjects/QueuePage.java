package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Factory.BaseClass;

public class QueuePage extends BasePage{

	public QueuePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Page Objects
	
	@FindBy (xpath = "//*[text()='Data Structures-Introduction']//following::a[5]")
	WebElement Queue_GetStartedBtn;
	
	// Queue Page Objects
	
	@FindBy (xpath = "//a[contains(text(),'Implementation of Queue in Python')]")
	WebElement ImpofQueue_Btn;
	
	@FindBy (xpath = "//a[contains(text(),'Implementation using collections.deque')]")
	WebElement ImpusingcollectionQueue_Btn;
	
	
	@FindBy (xpath = "//a[contains(text(),'Implementation using array')]")
	WebElement ImpUsingArray_Btn;
	
	
	@FindBy (xpath = "//a[contains(text(),'Queue Operations')]")	
	WebElement QueueOperation_Btn;
	
	
	// Implementation of Queue Page Objects		
	
	
	@FindBy (xpath = "//a[contains(text(),'Practice Questions')]")
	WebElement LeftPanel_PracticeQuestion_Btn;	
	
	
	

	public void Click_ImplementaionOfQueue()
	{
		ImpofQueue_Btn.click();
	}
	
	public void Click_ImplemenUsingCollectionOfQueue()
	{
		ImpusingcollectionQueue_Btn.click();
	}
	
	
	public void Click_ImplemenUsingArry()
	{
		ImpUsingArray_Btn.click();
	}
	
	public void Click_QueueOperation()
	{
		QueueOperation_Btn.click();
	}
	
	
	public void click_PracticeQuestions()
	{
		LeftPanel_PracticeQuestion_Btn.click();
	}
	
	
	
	public void Click_Tryhere()
	{
		DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
		dp.click_DS_TimeComplexity_TryhereBtn();
	}
}
