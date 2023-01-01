package selenum.base;

import java.net.InetAddress;

import org.apache.commons.lang3.SystemUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager extends baseclass {
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static ExtentReports setExtentReport() throws Exception {
		ExtentFactory.getInstance().getExtent();
		htmlReporter = new ExtentSparkReporter(reportPath +"HTML Report"+ baseclass.time + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		htmlReporter.loadXMLConfig("./extent-report.xml");
		String systemName = null;
		
		try {
			systemName = InetAddress.getLocalHost().getHostName();
		} catch (Exception e) {
//			Log.error(e.toString());
			e.getMessage();
		}

		extent.setSystemInfo("HostName", systemName);
		extent.setSystemInfo("OS", SystemUtils.OS_NAME.toUpperCase());
		extent.setSystemInfo("OS", SystemUtils.USER_NAME.toUpperCase());
//		extent.setSystemInfo("Browser", baseclass.property.getProperty("browser").toUpperCase());
		return extent;
	}

	public static void endReport() {
		extent.flush();
	}
}
