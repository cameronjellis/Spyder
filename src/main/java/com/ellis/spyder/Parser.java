package com.ellis.spyder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

/*******************************************************************************
*
*<b>Title:</b> Parse.java
*<b>Project:</b> Spyder
*<b>Description:</b> ~~!!CHANGE ME!!~~
*<b>Copyright:</b> Copyright (c) 2022
*<b>Company:</b> Silicon Mountain Technologies
*@author Cameron Ellis
*@version 3.1
*@since Jun 14, 2022
*<b>updates:</b>
*
******************************************************************************/

public class Parser {
	
	/**
	 * @param html
	 * @return
	 * @throws Exception
	 */
	public Elements parse(String html, String tag) throws Exception{
//		String html = getWebPage("https://www.siliconmtn.com/contact", 443);
		Document doc = Jsoup.parse(html);
//		Elements links = doc.select("a[href]");
//		System.out.println("parser```" + doc.select(tag));
		return doc.select(tag);		
	}
	
	/**
	 * @param links
	 * @return
	 */
	public List<String> parseLinks(Elements links){
		String regex = "(\\/)([a-zA-Z]+)";
		List<String> resources = new ArrayList<>();
		
		// put these two lines into the constructor for linkManager
		resources.add("/admintool");
		resources.add("/");		
		
		for (int i = 0; i < links.size(); i++) {
			String resource = links.get(i).attr("href");
			
			if (resource.matches(regex) && !resources.contains(resource))
			 resources.add(resource);
		}
		
		System.out.println("resources~> " + resources);
		
		return resources;
	}
	
	public String parseHeader(String html){
		
		String headerFields = html.split("\n\n")[0];
	
		return headerFields;
	}
	
	public String parseCookies(String header) {
		String regex = "(?:Set-Cookie: )([a-zA-Z0-9]+(=)[a-zA-Z0-9\\/+]+)";
		StringBuilder cookies = new StringBuilder();
		String[] cookieFields = header.split("\n");

		for (String cookie : cookieFields) {
//			System.out.println("cookie" + cookie);
			String[] fields = cookie.split(";");
			for (String field : fields) {
//				System.out.println("field" + field);
				if (field.matches(regex)) {
					cookies.append(field);
				}
			}
		}

		return cookies.toString();
	}
}
