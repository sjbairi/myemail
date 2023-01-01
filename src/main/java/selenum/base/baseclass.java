package selenum.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	public static WebDriver driver;
	public static String time = getCurrentTime();
	public static String reportPath = "./reports/report" + time + "/";
	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@AfterSuite
	public void closeExtent() {
		Reporter.log("Terminating extend report class", true);
		ExtentReportManager.endReport();
	}
	
	@BeforeTest
	public void extentReport() {
		try {
			ExtentReportManager.setExtentReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Extent Report initialize", true);
	}
	
	public static String getCurrentTime() {
		Date date = new Date();
		String currentTime = new SimpleDateFormat("yyyy-MM-dd kkmm").format(date);
		Reporter.log(currentTime, true);
		return currentTime;
	}
	
	public static String screenShot(WebDriver driver, String filename) throws IOException {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = "./reports/report" + time + "/Screenshots/" + filename + "_" + getCurrentTime() + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public static String screenShot(WebDriver driver) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		return takesScreenshot.getScreenshotAs(OutputType.BASE64); 
	/*	String imageBase64 = null;
		try {
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1200)).takeScreenshot(driver);
			ByteArrayOutputStream out = new  ByteArrayOutputStream(); 
			ImageIO.write(screenshot.getImage(),"PNG", out);
			byte[] bytes = out.toByteArray();
			return imageBase64 = Base64.encodeBase64String(bytes);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return imageBase64;  */
	}
}
