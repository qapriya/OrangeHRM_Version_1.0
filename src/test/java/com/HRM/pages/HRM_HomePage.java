package com.HRM.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HRM_HomePage 
{
  WebDriver driver;
  
  @FindBy (how=How.XPATH, using="//a[text()='Logout']")
  WebElement Logout;
  
  @FindBy (how=How.XPATH, using="//a[@id='welcome']")
  WebElement welcome;
 
  public HRM_HomePage(WebDriver d)
  {
	  driver =d;
	  PageFactory.initElements(driver,this);
  }
  
  public void Logout()
  {
	  Logout.click();
  }
  
  public void ClickOnWelcome()
  {
	  welcome.click();
  }
  
 
  
}
