package testing;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import selenum.base.baseclass;

public class emailreporting extends baseclass{
	
	@Test
	public void myemailof() throws InterruptedException {
		driver.get("www.facebook.com");
		Thread.sleep(5000);
		
		selenum.base.ExtentReportManager.test.info("GW PC Login Page").log(Status.PASS,
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot(driver)).build());
	}

}
