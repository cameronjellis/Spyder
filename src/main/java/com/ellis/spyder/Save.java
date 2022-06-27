package com.ellis.spyder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*******************************************************************************
*
*<b>Title:</b> Save.java
*<b>Project:</b> Spyder
*<b>Description:</b> ~~!!CHANGE ME!!~~
*<b>Copyright:</b> Copyright (c) 2022
*<b>Company:</b> Silicon Mountain Technologies
*@author Cameron Ellis
*@version 3.1
*@since Jun 15, 2022
*<b>updates:</b>
*
******************************************************************************/

public class Save {
	// create folder in root directory
	
	public void writeFile(String fileName, String content) {
		// add check for if file exists 		
		
		File newDir = new File(System.getProperty("siliconhtml"));
		
		File newFile = new File(newDir.getAbsolutePath() + File.separator + "siliconmtn" + fileName + ".html");
		
		try (FileWriter writer = new FileWriter(newFile)) {
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// iterate over list and write file with the name of siliconmtn + the resource -"/"
}
