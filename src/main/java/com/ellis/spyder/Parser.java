package com.ellis.spyder;

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

	public Elements parse(String html) throws Exception{
//		String html = getWebPage("https://www.siliconmtn.com/contact", 443);
		Document doc = Jsoup.parse(html);
		Elements links = doc.select("a[href]");

		return links;		
	}
	
	public List<String> parseLinks(Elements links){
		String regex = "(\\/)([a-zA-Z]+)";
		List<String> resources = new ArrayList<>();
		
		for (int i = 0; i < links.size(); i++) {
			String resource = links.get(i).attr("href");
			
			if (resource.matches(regex) && !resources.contains(resource))
			 resources.add(resource);
		}
		
		System.out.println("resources~> " + resources);
		
		return resources;
	}
}
