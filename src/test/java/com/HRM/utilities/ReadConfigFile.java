package com.HRM.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile 
{
	Properties po;
	public ReadConfigFile() 
   {
	   File src= new File(".\\Configuration\\config.properties");
	   try
	   {
	   FileInputStream fi= new FileInputStream(src);
	    po= new Properties();
	    po.load(fi);
	   }
	   catch (Exception e)
	   {
		   System.out.println("Unable to load file" +e);
	   }
	}	   
	public String getAppurl()
	   {
		   String value= po.getProperty("url");
		   return value;
	   }

	public String getuserName()
	   {
		   String value= po.getProperty("userName");
		   return value;
	   }
	public String getpassWord()
	   {
		   String value= po.getProperty("passWord");
		   return value;
	   }
	public String getchromedriverpath()
	   {
		   String value= po.getProperty("chrome");
		   return value;
	   }	
	public String getfirefoxdriverpath()
	   {
		   String value= po.getProperty("firefox");
		   return value;
	   }

}

