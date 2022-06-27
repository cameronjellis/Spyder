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
		
		Save saver = new Save();
		SpyderLogger spyLog = new SpyderLogger();
		Connection connection = new Connection();
		Parser parser = new Parser();
		LinkManager linkMgr = new LinkManager("https://smt-stage.qa.siliconmtn.com"
				+ "/sb/admintool?cPage=index&actionId=MODULE", "www.siliconmtn.com");
		
		spyLog.log("this is the spyder.spy() method");	
		
		String homeHtml = connection.getWebPage("/");
		System.out.println("homeHTML" + homeHtml);
		Elements linkList = parser.parse(homeHtml);
		
		linkMgr.getLtp().addAll(parser.parseLinks(linkList));
		linkMgr.formatUrls();
		
		spyLog.log("~~linkMgr.ltp~~ " + linkMgr.getLtp());
		spyLog.log("~~linkMgr.urltp~~ " + linkMgr.getUrltp());
		
		
		for (int i = 0; i < linkMgr.getLtp().size(); i++) {
			
			String link = linkMgr.getLtp().get(i);
			
			if (link.equals("https://smt-stage.qa.siliconmtn.com/sb/admintool?cPage=index&actionId=MODULE")) {
				continue;
			}
			
			String content = connection.getWebPage(link);
			
//			saver.writeFile(linkMgr.getLtp().get(i).substring(0 , linkMgr.getLtp().get(i).length() -1), content);
			
			htmls.add(content);
//			htmls.add(connection.postWidget(link, link));
		}		
		System.out.println(htmls.size());

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
