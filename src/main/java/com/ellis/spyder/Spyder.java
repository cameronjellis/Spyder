package com.ellis.spyder;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.select.Elements;

/*******************************************************************************
*
*<b>Title:</b> Spyder.java
*<b>Project:</b> spyder
*<b>Description:</b> ~~!!CHANGE ME!!~~
*<b>Copyright:</b> Copyright (c) 2022
*<b>Company:</b> Silicon Mountain Technologies
*@author Cameron Ellis
*@version 3.1
*@since Jun 14, 2022
*<b>updates:</b>
*
******************************************************************************/

// handle exceptions
// clean comments
// javadocs
// filesystem save
// post function
// clean errors/warnings/sonarlints

public class Spyder {
	
	List<String> initialUrls = new ArrayList<>();
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		Spyder spyder1 = new Spyder();
		spyder1.spy();
		System.out.println("~spyder~");
	}

	/**
	 * this is the flow control method, will instantiate and call all other 
	 * classes and methods
	 * @throws Exception
	 */
	public void spy() throws Exception {
			
		SpyderLogger spyLog = new SpyderLogger();
		Connection connection = new Connection();
		Parser parser = new Parser();
		LinkManager linkMgr = new LinkManager();
		
		spyLog.log("this is the spyder.spy() method");	
		
		String homeHtml = connection.getWebPage(new URL("https://www.siliconmtn.com"), 443);
		
		Elements linkList = parser.parse(homeHtml);
		
		linkMgr.getLtp().addAll(parser.parseLinks(linkList));
		linkMgr.formatUrls();
		
		spyLog.log("~~linkMgr.ltp~~ " + linkMgr.getLtp());
		spyLog.log("~~linkMgr.urltp~~ " + linkMgr.getUrltp());
		
		
		// loop linkList and only add abs:links starting with siliconmtn
//		for (Element link : linkList) {
//			spyLog.log("~rel~> " + link);
//			String absHref = link.attr("abs:href");
//			spyLog.log("~abs~> " + absHref);
//		}
//		linkMgr.ltp.addAll(linkList);
		
	
	// connect with the initial list item from linkManager
		
	// send all links as urls to LinkManager to add to list
		
	// conditional for if url == https://smt-stage.qa.siliconmtn.com/admintool
	// method is post - login, navigate to widget and write to file
	// widget tool - https://smt-stage.qa.siliconmtn.com/sb/admintool?cPage=index&actionId=MODULE
	}
}
