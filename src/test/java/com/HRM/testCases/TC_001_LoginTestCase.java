package com.HRM.testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRM.pages.HRM_LoginPage;
import com.HRM.utilities.BaseClass;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;

public class TC_001_LoginTestCase extends BaseClass
{
	HRM_LoginPage lp;
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
	
	@ Test (priority=3)
	public void verifyTheTitle_HomePage() 
	{
		String currentMethodName= new Exception().getStackTrace()[0].getMethodName();
		setLogger(currentMethodName);
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
