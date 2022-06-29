package com.ellis.spyder;

import java.io.BufferedWriter;
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
		
	public void writeFile(String fileName, String content) {
		if (fileName.length() == 0) {
			fileName = "home";
		}
		
		File newDir = new File("siliconhtml");
		
		if (!newDir.exists()) {
			newDir.mkdirs();
		}
		
		File newFile = new File(newDir, (fileName + ".html"));
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
			writer.write(content);
			System.out.println("wrote " + fileName + ".html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
