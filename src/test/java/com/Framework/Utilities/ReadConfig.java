package com.Framework.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	//constructor created to load the config.properties file
	public ReadConfig()
	{
		File src=new File("./Configuration\\config.properties"); // './' represents current project home directory
		
		try{
			FileInputStream fis =new FileInputStream(src);
			
			pro=new Properties();
			
			pro.load(fis); //load is a method which will load all the data from config.properties file
		}
		catch(Exception e)
		{
			System.out.println("Exception is :"+ e.getMessage());
		}
	}

		/*these methods will get value from the config.properties file and it will store in string variable and 
		it will return to base class*/
		public String getApplicationURL()
		{
			String url=pro.getProperty("baseURL");
			return url;
		}
		
		public String getEmail()
		{
			String mail=pro.getProperty("email");
			return mail;
		}
		
		public String getPassword()
		{
			String pass=pro.getProperty("password");
			return pass;
		}
		
		public String getChromePath()
		{
			String chroPath=pro.getProperty("chromepath");
			return chroPath;
		}
		
		public String getfirefoxPath()
		{
			String firepath=pro.getProperty("firefoxpath");
			return firepath;
		}
		public String getIEpath()
		{
			String iepath=pro.getProperty("IEpath");
			return iepath;
		}
	

}



