package com.HRM.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class BaseClass
{
	public WebDriver driver;
	ReadConfigFile pro=new ReadConfigFile();
	public String URL= pro.getAppurl();
	public String userName=pro.getuserName();
	public String passWord=pro.getpassWord();
	public Logger log;
	static String timeStamp;
	static String ScreenshotName;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
 @ Parameters("browser")
 @ BeforeClass
   public void setup(String br)
   {
	 try 
	 {
		 if (br.equalsIgnoreCase("chrome"))
		 {
			 log= LogManager.getLogger();
			 reporterOnStart();
			 System.setProperty("webdriver.chrome.driver",pro.getchromedriverpath());
		      driver= new ChromeDriver();
		      driver.manage().window().maximize();
		      driver.get(URL);
		      log.info("Browser launched successfully"); 
		 }
		 else if (br.equalsIgnoreCase("firefox"))
		 {
			 log= LogManager.getLogger();
			 System.setProperty("webdriver.gecko.driver",pro.getfirefoxdriverpath());
		      driver= new FirefoxDriver();
		      driver.manage().window().maximize();
		      driver.get(URL);
		      log.info("Browser launched successfully"); 
		 }
	 }
	 catch (Exception e)
	 {
	 log.error("Failed to launch the browser"+e);
	 }
   }
 
 @ AfterClass
  public void teardown()
  {
	 try
	 {  
		 driver.quit();
		 extent.flush();
		 log.info("Browser closed successfully");
	 }
	 catch (Exception e)
	 {
		 log.error("Failed to close the browser"+e);
	 }
  }
 
   public void reporterOnStart()
   {
	   String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Customized User_Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/extentReports/"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-reports.xml"); // load the XML file
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Test");
		
		htmlReporter.config().setDocumentTitle("Orange HRM TestUser Project"); // Tile of report
		htmlReporter.config().setReportName("Customized Regression Test Automation Report"); // name of the report
		htmlReporter.config().setTheme(Theme.DARK);	
	}
 
     public void setLogger (String testname)
     {
    	 logger= extent.createTest(testname);
     }
     
     public void customLogger(Status status, String message, ExtentColor color)
     {
    	 logger.log(status, MarkupHelper.createLabel(message, color));
     }
     
     public void onTestFailure(String name, WebDriver driver)
     {
    	 try
    	 {
    		 takescreenshot(name, driver);
    		 String screenshotPath=System.getProperty("user.dir")+"\\ScreenShots\\"+name+".png";
    		 logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));   	
    	 }
    	 catch (Exception e)
    	 {
    		 System.out.println("Unable to capture screenshot" +e);
    	 }
    	 
     }
    public void takescreenshot(String name, WebDriver driver)
    {
    	try
    	{
    	timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		ScreenshotName =name+"-"+timeStamp;
    	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File dest= new File(".\\ScreenShots\\"+ ScreenshotName +".png");
    	FileHandler.copy(src, dest);
    	}
    	catch (Exception e)
    	{
    		System.out.println("Unable to capture screenshot" +e);
    	}
    }
}
