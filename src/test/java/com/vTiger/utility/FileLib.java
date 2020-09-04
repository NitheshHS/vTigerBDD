package com.vTiger.utility;

import java.io.FileInputStream;
import java.util.Properties;

import com.vTiger.Constant.Constants;
/**
 * 
 * @author Nithesh Gowda
 *
 */
public class FileLib {
	/**
	 * This method read key and provide value from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream file=new FileInputStream(Constants.sysDir+"/resources/commonData.properties");
		Properties prop=new Properties();
		prop.load(file);
		
		String value=prop.getProperty(key);
		return value;
	}

}
