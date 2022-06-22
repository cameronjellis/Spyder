package com.ellis.spyder;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
	
	
	

	public Elements parse(String html) throws Exception{
//		String html = getWebPage("https://www.siliconmtn.com/contact", 443);
		Document doc = Jsoup.parse(html);
		Element link = doc.select("a").first();
		String absLink = link.attr("abs:href");
		System.out.println("links~> \n" + absLink);
		

		
		List<String> absLinks = new ArrayList<>();
//		for (int i = 0; i < ((CharSequence) links).length() : links) {
//			absLinks.add(e.attr("abs:href"));
//		}
		
//		String link = links.get(1).attr("abs:href");
		
//		System.out.println("absLinks~> \n" + links.get(0).attr("abs:href"));
		
		return null;		
	}
	
	
}
