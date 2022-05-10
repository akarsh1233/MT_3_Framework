package com.vTigerGenericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class propertyfiles {

	public static String readpropertyfile(String key) throws Throwable {
		FileInputStream file = new FileInputStream("D:\\seleni\\TYSS_AKARSH\\data.properties");
		Properties prop = new Properties();
		prop.load(file);
		
		return prop.getProperty(key);
		
		

	}

}
