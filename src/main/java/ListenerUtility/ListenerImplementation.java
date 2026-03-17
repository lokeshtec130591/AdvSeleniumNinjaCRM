package ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BastTest.BaseClass;

public class ListenerImplementation implements ITestListener, ISuiteListener {

	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	
	
	@Override
	public void onStart(ISuite suite) {
		
		
		
		Date date = new Date();
		String newDate = date.toString().replace(" ", "_").replace(":","_");
		spark = new ExtentSparkReporter("./AdvancedReport/report_"+newDate+".html");
		spark.config().setDocumentTitle("Ninza CRM TestResults");
		spark.config().setReportName("CRM Reports");
		spark.config().setTheme(Theme.DARK);
		
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 11");
		
		Reporter.log("Report Config" , true);
		
	}

	@Override
	public void onFinish(ISuite suite) {
		
		report.flush();
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		
		test = report.createTest(testName);
		test.log(Status.INFO, ""+testName+"Execution STARTED");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test.log(Status.PASS, ""+testName+"Execution SUCCESS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();

		Date date = new Date();
		String newDate = date.toString().replace(" ", "_").replace(":","_");

		
		TakesScreenshot ts =  (TakesScreenshot) BaseClass.sdriver;
		 String temp = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp);
	//	File perm = new File("./ScreenShots/"+testName+"_"+newDate+".png");
		

		
		test.log(Status.FAIL, ""+testName+"Execution FAILED");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		test.log(Status.SKIP, ""+testName+"Execution SKIPPED");
		
	}

	
	
	
	
}
