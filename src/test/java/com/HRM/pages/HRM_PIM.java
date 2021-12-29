package com.HRM.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HRM_PIM 
{
  WebDriver driver;
  
  @FindBy(how=How.XPATH,using="//input[@id='firstName']")
  WebElement FirstName;
  
  @FindBy (how=How.XPATH, using="//input[@id='middleName']")
  WebElement MiddleName;
  
  @FindBy (how=How.XPATH, using="//input[@id='lastName']")
  WebElement lastname;
  
  @FindBy (how=How.XPATH, using="//input[@id='employeeId']")
  WebElement empID;
  
  @FindBy (how=How.XPATH, using="//a[@id='menu_pim_viewPimModule']")
  WebElement PIMOption;
 
  @FindBy (how=How.XPATH, using="//a[@id='menu_pim_addEmployee']")
  WebElement addEmployee;
  
  @FindBy (how=How.XPATH, using="//input[@id='chkLogin']")
  WebElement LoginDetails;
  
  @FindBy (how=How.XPATH, using="//input[@id='user_name']")
  WebElement UserName;
  
  @FindBy (how=How.XPATH, using="//input[@id='user_password']")
  WebElement Password;
  
  @FindBy (how=How.XPATH, using="//input[@id='re_password']")
  WebElement ConfirmPassword;
  
  @FindBy (how=How.XPATH, using="//input[@id='btnSave']")
  WebElement SaveButton;
  
  public HRM_PIM(WebDriver d)
  {
	  driver =d;
	  PageFactory.initElements(driver,this);
  }
  
  public void setFirstName(String FirstNameValue)
  {
	  try 
	  {
		  FirstName.sendKeys(FirstNameValue);
	  }
	  catch (Exception e)
	  {
		  System.out.println("Unable to set values"+e);
	  }
	  
  }

public void setMiddleName(String MiddleNameValue)
  {
	try
	{
		MiddleName.sendKeys(MiddleNameValue);
	}
	 catch (Exception e)
	  {
		  System.out.println("Unable to set values"+e);
	  }
  }
  
  public void setLastName(String lastnameValue)
  {
	 
	  try
	  {
		  lastname.sendKeys(lastnameValue);
	  }
	  catch (Exception e)
	  {
		  System.out.println("Unable to set values"+e);
	  }
  }
  
  public void setEmployeeID(String empIDValue)
  {
	  try
	  {
	  empID.sendKeys(empIDValue);
	  }
	  catch (Exception e)
	  {
		  System.out.println("Unable to set values"+e);
	  }
  }
  
  public void setUserName(String UserNameValue)
  {
	  try
	  {
	  UserName.sendKeys(UserNameValue);
	  }
	  catch (Exception e)
	  {
		  System.out.println("Unable to set values"+e);
	  }
  }
  
  public void setPassword(String PasswordValue)
  {
	  try
	  {
	  Password.sendKeys(PasswordValue);
	  }
	  catch (Exception e)
	  {
		  System.out.println("Unable to set values"+e);
	  }
  }
  
  public void setConfirmPassword(String ConfirmPasswordValue)
  {
	  try
	  {
	  ConfirmPassword.sendKeys(ConfirmPasswordValue);
	  }
	  catch (Exception e)
	  {
		  System.out.println("Unable to set values"+e);
	  }
  }
  
  public void clickonPIM()
  {
	  try
	  {
		  PIMOption.click();  
	  }
	  catch (Exception e)
	  {
		  System.out.println("Unable to click on option" +e);
	  }
  } 
  
  public void clickonAddEmployee()
  {
	  try
	  {
	  addEmployee.click();
	  }
	  catch (Exception e)
	  {
		  System.out.println("Unable to click on option" +e);
	  }
  } 
  
  public void clickonLoginDetails()
  {
	  try
	  {
	  LoginDetails.click();
	  }
	  catch (Exception e)
	  {
		  System.out.println("Unable to click on option" +e);
	  }
 } 
  
  public void clickonSaveButton()
  {
	 try
	 {
	  SaveButton.click();
	 }
	 catch (Exception e)
	  {
		  System.out.println("Unable to click on option" +e);
	  }
	 
  }
  
}
