package com.ellis.spyder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*******************************************************************************
*
*<b>Title:</b> Properties.java
*<b>Project:</b> Spyder
*<b>Description:</b> ~~!!CHANGE ME!!~~
*<b>Copyright:</b> Copyright (c) 2022
*<b>Company:</b> Silicon Mountain Technologies
*@author Cameron Ellis
*@version 3.1
*@since Jun 27, 2022
*<b>updates:</b>
*
******************************************************************************/

public class ReadPropertyFile {
	
	static Map<String, String> props = new HashMap<>();

	/**
	 * method to return the map of properties ready from config - not working
	 * @return
	 * @throws IOException
	 */
	public static Map<String, String> propMap() throws IOException {
		
//		Properties prop = new Properties();
//		File propFile = new File("config.properties");
//		FileInputStream is = new FileInputStream(propFile.getAbsolutePath());
		
		return props;
	}
}
