package utilities;

import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import io.qameta.allure.Attachment;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import factory.BaseClass;

	public class AllureReportManager implements ITestListener{
		
		WebDriver driver = factory.BaseClass.getDriver();

		private static String getTestMethodName(ITestResult iTestResult) {
			return iTestResult.getMethod().getConstructorOrMethod().getName();
		}

		// Text attachments for Allure
		@Attachment(value = "PageScreenshot", type = "image/png")
		public void saveScreenshotPNG(WebDriver driver) {	
			Allure.addAttachment("attachment", new ByteArrayInputStream(((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES)));
		}

		// Text attachments for Allure
		@Attachment(value = "{0}", type = "text/plain")
		public static String saveTextLog(String message) {
			return message;
		}

		// HTML attachments for Allure
		@Attachment(value = "{0}", type = "text/html")
		public static String attachHtml(String html) {
			return html;
		}


		@Override
		public void onFinish(ITestContext iTestContext) {
			System.out.println("I am in onFinish method " + iTestContext.getName());
		}

		@Override
		public void onTestStart(ITestResult iTestResult) {
			System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
		}

		@Override
		public void onTestSuccess(ITestResult iTestResult) {
			System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
		}

		@Override
		public void onTestFailure(ITestResult iTestResult)  {
			
			if (iTestResult.getStatus() == ITestResult.FAILURE)
				{
				saveScreenshotPNG(driver);
				}
			
		}

		@Override
		public void onTestSkipped(ITestResult iTestResult) {
			System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
		}


}
