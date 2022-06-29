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
	
	/**
	 * @param html
	 * @return Elements that were parsed based on passed tag
	 * @throws Exception
	 */
	public Elements parse(String html, String tag){
		Document doc = Jsoup.parse(html);

		return doc.select(tag);		
	}
	
	/**
	 * takes the elements selected in parse() and turns them into usable 
	 * resources ex /about, /services
	 * @param links to parse 
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

		return resources;
	}
	
	/**
	 * will parse a string and pull out the header fields
	 * @param html
	 * @return headerFields as a string separated by "\n"
	 */
	public String parseHeader(String html){
	
		return html.split("\n\n")[0];
	}
	
	/**
	 * will take a header and pull out all cookies to pass back in later
	 * @param header
	 * @return cookies in an unformatted string
	 */
	public String parseCookies(String header) {
		String regex = "(?:Set-Cookie: )([a-zA-Z0-9]+(=)[a-zA-Z0-9\\/+]+)";
		StringBuilder cookies = new StringBuilder();
		String[] cookieFields = header.split("\n");

		for (String cookie : cookieFields) {

			String[] fields = cookie.split(";");
			for (String field : fields) {

				if (field.matches(regex)) {
					cookies.append(field);
				}
			}
		}

		return cookies.toString();
	}
}
