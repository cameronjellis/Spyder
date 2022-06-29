package com.ellis.spyder;

import java.util.logging.Level; 
import java.util.logging.Logger; 


/*******************************************************************************
*
*<b>Title:</b> SpyderLogger.java
*<b>Project:</b> Spyder
*<b>Description:</b> ~~!!CHANGE ME!!~~
*<b>Copyright:</b> Copyright (c) 2022
*<b>Company:</b> Silicon Mountain Technologies
*@author Cameron Ellis
*@version 3.1
*@since Jun 21, 2022
*<b>updates:</b>
*
******************************************************************************/

public class SpyderLogger {

	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	/**
	 * @param s - the string to log
	 */
	public void log(String s) {
		logger.log(Level.WARNING, s);
	}

//	public static void main(String[] args) {
////		SpyderLogger spyderLog = new SpyderLogger();
//
//		LogManager slg = LogManager.getLogManager();
//		Logger log = slg.getLogger(Logger.GLOBAL_LOGGER_NAME);
//		log.log(Level.WARNING, "Hi! Welcome from SPYDER");
//	}
}
