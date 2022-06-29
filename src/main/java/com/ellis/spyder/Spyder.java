package com.ellis.spyder;

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
	}

	/**
	 * this is the flow control method, will instantiate and call all other 
	 * classes and methods - gets original html to parse for links, 
	 * @throws Exception
	 */
	public void spy() throws Exception {
		
		Save saver = new Save();
		SpyderLogger spyLog = new SpyderLogger();
		Connection connection = new Connection();
		Parser parser = new Parser();
		LinkManager linkMgr = new LinkManager("https://smt-stage.qa.siliconmtn.com"
				+ "/sb/admintool?cPage=index&actionId=MODULE", "www.siliconmtn.com");
		
		String homeHtml = connection.getWebPage("/");
		Elements linkList = parser.parse(homeHtml, "a[href]");
		
		linkMgr.getLtp().addAll(parser.parseLinks(linkList));
		linkMgr.formatUrls();
		
		spyLog.log("~~linkMgr.ltp~~ " + linkMgr.getLtp());
		spyLog.log("~~linkMgr.urltp~~ " + linkMgr.getUrltp());
		
		// add this logic to saver!
		for (int i = 0; i < linkMgr.getLtp().size(); i++) {
			
			String link = linkMgr.getLtp().get(i);
			
			if (link.equals("/admintool")) {
				String content = connection.getWebPage(link, "https://smt-stage.qa."
						+ "siliconmtn.com/admintool");				
				String fileName = link.substring(1 , link.length());
				
				String headers = parser.parseHeader(content);
				String cookie = parser.parseCookies(parser.parseHeader(content));
				
				System.out.println("\n~ headers ~\n" + headers);	
				System.out.println("\n~ cookies ~\n" + cookie + "\n");
				
				// move this to parser?
//				if (connection.getCookie() == null) {
//					connection.setCookie(parser.parseCookies(parser.parseHeader(content)).substring(12).trim());
//				}
				
				saver.writeFile(fileName, content);
				htmls.add(content);			
			} else {
				String content = connection.getWebPage(link);				
				String fileName = link.substring(1 , link.length());
				
				String headers = parser.parseHeader(content);
				String cookie = parser.parseCookies(parser.parseHeader(content));
				
				System.out.println("\n~ headers ~\n" + headers);	
				System.out.println("\n~ cookies ~\n" + cookie + "\n");
				
				// move this logic to parser? or separate method in Spyder
				// formats the cookie to be able to be passed into the headers
				if (connection.getCookie() == null) {
					connection.setCookie(cookie.substring(12).replace("Set-Cookie: ", "; ").trim());
				}
				
				saver.writeFile(fileName, content);
				htmls.add(content);
			}
		}		
		System.out.println(htmls.size());
		// connection.close();
	}	
	// try catch finally
}
