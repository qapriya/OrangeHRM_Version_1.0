package com.HRM.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRM.pages.HRM_HomePage;
import com.HRM.pages.HRM_LoginPage;
import com.HRM.pages.HRM_PIM;
import com.HRM.utilities.BaseClass;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;

public class TC_002_AddNewEmployeeAndVerifyLoginCredentials extends BaseClass
{
	 HRM_PIM pim;
	 HRM_LoginPage lp;
	 HRM_HomePage hp;
	 @ Test(priority=1)
		public void set_LoginCredentials()
		{
			String currentMethodName= new Exception().getStackTrace()[0].getMethodName();
			lp=new HRM_LoginPage(driver);
			setLogger(currentMethodName);
			lp.setUserName(userName);
			log.info("UserName is set");
			customLogger(Status.PASS, "UserName is set successfully", ExtentColor.GREEN);
			lp.setPassword(passWord);
			log.info("passWord is set");
			customLogger(Status.PASS, "Password is set successfully", ExtentColor.GREEN);
		}
		@ Test (priority=2)
		 public void clickOnLoginButton()
		{
			String currentMethodName= new Exception().getStackTrace()[0].getMethodName();
			setLogger(currentMethodName);
			lp.clickonLogin();	
			log.info("Clicked on the login button");	
			customLogger(Status.PASS, "Successfully clicked on login button", ExtentColor.GREEN);
		}	
	 
	 @Test (priority=3)
	 public void addEmployee() throws Exception
	 {
		 String currentMethodName= new Exception().getStackTrace()[0].getMethodName();
		 setLogger(currentMethodName);
		 pim= new HRM_PIM(driver);
		 pim.clickonPIM();
		 log.info("Click on PIM");
		customLogger(Status.PASS, "User clicked on PIM", ExtentColor.GREEN);
		 pim.clickonAddEmployee();
		 log.info("Click on AddEmployee");
		customLogger(Status.PASS, "User clicked on AddEmployee", ExtentColor.GREEN);
		 pim.setFirstName("Test");
		 log.info("FirstName is set");
		customLogger(Status.PASS, "FirstName is set successfully", ExtentColor.GREEN);
		 pim.setMiddleName("LKG");
		 log.info("MiddleName is set");
		customLogger(Status.PASS, "MiddleName is set successfully", ExtentColor.GREEN);
		 pim.setLastName("Student");
		 log.info("LastName is set");
		customLogger(Status.PASS, "LastName is set successfully", ExtentColor.GREEN);
		 pim.setEmployeeID("0613");
		 log.info("EmployeeID is set");
		customLogger(Status.PASS, "EmployeeID is set successfully", ExtentColor.GREEN);
		 pim.clickonLoginDetails();
		 log.info("Click on LoginDetails");
		customLogger(Status.PASS, "User clicked on LoginDetails", ExtentColor.GREEN);
		 pim.setUserName("TestStudent");
		 log.info("UserName is set");
		customLogger(Status.PASS, "UserName is set successfully", ExtentColor.GREEN);
		 pim.setPassword("Test@123");
		 log.info("Password is set");
		customLogger(Status.PASS, "Password is set successfully", ExtentColor.GREEN);
		 pim.setConfirmPassword("Test@123");
		 log.info("ConfirmPassword is set");
			customLogger(Status.PASS, "ConfirmPassword is set successfully", ExtentColor.GREEN);
		 pim.clickonSaveButton();
		 Thread.sleep(3000);
		 log.info("Click on SaveButton");
			customLogger(Status.PASS, "User clicked on SaveButton", ExtentColor.GREEN);
	 }
	 
	 @ Test (priority=4)
	 public void LogoutFromApp() throws Exception
	 {
		 String currentMethodName= new Exception().getStackTrace()[0].getMethodName();
		setLogger(currentMethodName);
		 hp=new HRM_HomePage(driver);
		 hp.ClickOnWelcome();
		 log.info("Clicked on Welcome text");
		 customLogger(Status.PASS, "Clicked on Welcome Text", ExtentColor.GREEN);
		 Thread.sleep(5000);
		 hp.Logout();
		 log.info("Clicked on Logout button");
		 customLogger(Status.PASS, "Logout button is clicked successfully", ExtentColor.GREEN);
	 }
	 
	 @ Test(priority=5)
		public void LoginWithNewEmployee()
		{
			String currentMethodName= new Exception().getStackTrace()[0].getMethodName();
			setLogger(currentMethodName);
			lp.setUserName("Test01");
			log.info("UserName is set");
			customLogger(Status.PASS, "UserName is set successfully", ExtentColor.GREEN);
			lp.setPassword("Test@123");
			log.info("passWord is set");
			customLogger(Status.PASS, "Password is set successfully", ExtentColor.GREEN);
			lp.clickonLogin();	
			log.info("Clicked on the login button");	
			customLogger(Status.PASS, "Successfully clicked on login button", ExtentColor.GREEN);
			String ExpectedTitle="OrangeHRM";
			if (driver.getTitle().equals(ExpectedTitle))
			{
				log.info("Actual Title: "+ driver.getTitle()+"  Matched with Expected Title: "+ExpectedTitle);
				customLogger(Status.PASS,"Actual Title: "+ driver.getTitle()+"  Matched with Expected Title: "+ExpectedTitle, ExtentColor.GREEN);
				Assert.assertTrue(true,"Expected Title and Actual Title has matched");
			}	
			else
			{
				takescreenshot(currentMethodName, driver);
				log.info("Actual Title: "+ driver.getTitle()+"  didnot matched with Expected Title: "+ExpectedTitle);
				customLogger(Status.FAIL,"Actual Title: "+ driver.getTitle()+"  didnot matched with Expected Title: "+ExpectedTitle, ExtentColor.RED);
				Assert.assertTrue(false,"Expected Title and Actual Title did not match");
			}
			
		}
}
 
