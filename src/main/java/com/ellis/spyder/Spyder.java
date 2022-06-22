package com.ellis.spyder;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
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

public class Spyder {
	
	List<String> initialUrls = new ArrayList<>();
	
	private SpyderLogger spyLog = new SpyderLogger();
	
	private Connection connection = new Connection();
	private Parser parser = new Parser();
	private LinkManager linkMgr = new LinkManager();
	
	
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("~spyder~");
		
		Spyder spyder1 = new Spyder();
		
		spyder1.spy();
	}
	
	/**
	 * this is the flow control method, will instantiate and call all other 
	 * classes and methods
	 * @throws Exception
	 */
	public void spy() throws Exception {
		
		spyLog.log("this is the spyder.spy() method");	
		
		String html = connection.getWebPage("https://www.siliconmtn.com", 443);
		
		Elements linkList = parser.parse(html);
		
		// loop linkList and only add abs:links starting with siliconmtn
//		for (Element link : linkList) {
//			spyLog.log("~rel~> " + link);
//			String absHref = link.attr("abs:href");
//			spyLog.log("~abs~> " + absHref);
//		}
//		
//		linkMgr.ltp.addAll(linkList);
		
		
		
		
		spyLog.log("~~linkMgr.ltp~~ " + linkMgr.ltp);
		
	// connect with the initial list item from linkManager
		
	// send all links as urls to LinkManager to add to list
		
	// conditional for if url == https://smt-stage.qa.siliconmtn.com/admintool
	// method is post - login, navigate to widget and write to file
	// widget tool - https://smt-stage.qa.siliconmtn.com/sb/admintool?cPage=index&actionId=MODULE
	}
}
