package com.pritamecom.utilities;

import java.io.FileInputStream;
import java.util.Properties;



public class ReadConfig {
	 //to read properties file there is class present in java(named properties) for that we created object of it
	Properties properties;
	
	//we want path of property file, for reading that file.. so create path by using string
	String path= "C:\\Users\\Arjun\\eclipse-workspace\\com.pritamecom\\Confiuration\\config.properties";
	
	//now create an constructor in that we have to initialize object of properties variable that we created earlier
	public ReadConfig() {
		try {
		properties = new Properties(); //import java.util pacakage
		
			FileInputStream fis = new FileInputStream(path); //to read file we create an object and pass path of file as parameter
			
			//now we have to load property file
			properties.load(fis);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
//Now, create methods to read keys in property file (i.e. for base url & for browser)
	
	public String getBaseUrl() 
	{
		String value = properties.getProperty("baseurl");
		
		// to check value is null or not so use if-else condition
		if (value!=null)
			return value;
		else
			throw new  RuntimeException("url not specified in config file");
	}
	
	
	public String getBrowser() 
	{
		String value = properties.getProperty("browser");
		
		if (value!=null)
			return value;
		else
			throw new  RuntimeException("browseer not specified in config file");
	}
}
