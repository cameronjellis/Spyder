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
	
	List<String> htmls = new ArrayList<>();
	// turn htmls into a hashMap key = resource, value = html
	
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
		LinkManager linkMgr = new LinkManager("https://smt-stage.qa.siliconmtn.com"
				+ "/sb/admintool?cPage=index&actionId=MODULE");
		
		spyLog.log("this is the spyder.spy() method");	
		
		String homeHtml = connection.getWebPage(new URL("https://www.siliconmtn.com"));
		
		Elements linkList = parser.parse(homeHtml);
		
		linkMgr.getLtp().addAll(parser.parseLinks(linkList));
		linkMgr.formatUrls();
		
		spyLog.log("~~linkMgr.ltp~~ " + linkMgr.getLtp());
		spyLog.log("~~linkMgr.urltp~~ " + linkMgr.getUrltp());
		
		for (URL link : linkMgr.getUrltp()) {
			
			if (!link.toString().equals("https://smt-stage.qa.siliconmtn.com/sb/admintool?cPage=index&actionId=MODULE")) {
				continue;
			}
			
			// save.write(connection.getWebPage(link))
			
			htmls.add(connection.postWidget(link, link));
		}		
//		System.out.println(htmls);

	}
}

//
///**
// * key is a URL, value is whether it has been downloaded or not
// * @return
// */
//public URL nextUrl(Map<URL, Boolean> urls) {
//	
//	for (Entry<URL, Boolean> entry : urls.entrySet()) {
//		if (!entry.getValue()) {
////			entry.setValue(true);
//			
//			return entry.getKey();
//		} 
//	} 
//	
//	return null;
//}
//
