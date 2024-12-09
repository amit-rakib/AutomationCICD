package amit.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import amit.resources.ExtendReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtendReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread safe
	
	@Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub	
		
	test = extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test); // unique thread id(ErrorValidationTest)->test
        		
    }	
	@Override		
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub	
		extentTest.get().log(Status.PASS, "Test Passed");
        		
    }	
	@Override		
	public void onTestFailure(ITestResult result) {					
	    // TODO Auto-generated method stub		
	//	test.log(Status.FAIL, "Test Failed");
		
		extentTest.get().fail(result.getThrowable());
		
		//Screenshot
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String filePath = getScreenshot(result.getMethod().getMethodName(), driver);
			extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	        		
	}	
	
	
    @Override		
    public void onFinish(ITestContext context) {					
        // TODO Auto-generated method stub		
    	extent.flush();
        		
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

  	

    @Override		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    

    
	

}