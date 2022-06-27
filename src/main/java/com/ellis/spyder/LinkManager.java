package com.ellis.spyder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/*******************************************************************************
*
*<b>Title:</b> LinkManager.java
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

public class LinkManager {

	private List<String> ltp = new ArrayList<>();
	private List<String> urltp = new ArrayList<>();
	
	/**
	 * @param initialUrl
	 * @throws MalformedURLException
	 */
	public LinkManager(String widgetUrl, String homeUrl) throws MalformedURLException {
		urltp.add(widgetUrl);
		urltp.add(homeUrl);
	}
	
	/**
	 * 
	 */
	public LinkManager() {
		super();
	}	
	
	/**
	 * @return
	 * @throws MalformedURLException
	 */
	public List<String> formatUrls() throws MalformedURLException{
		
		String baseURL = "https://www.siliconmtn.com";
		
		for (String link : ltp) {
			String toParse = baseURL + link;
			urltp.add(toParse);
		}		
		return urltp;
	}
	
	/**
	 * @param urls
	 * @return
	 */
	public Map<URL, Boolean> mapInit(List<URL> urls){
		
		Map<URL, Boolean> urlMap = new LinkedHashMap<>();
		
		for (URL url : urls) {
			urlMap.put(url, false);
		}
		
		return urlMap;
	}
	
	// hasNext() return boolean if there are elements = false
	
	// getNext() will return the next element = false
	
	/**
	 * @return the ltp
	 */
	public List<String> getLtp() {
		return ltp;
	}

	/**
	 * @param ltp the ltp to set
	 */
	public void setLtp(List<String> ltp) {
		this.ltp = ltp;
	}

	/**
	 * @return the urltp
	 */
	public List<String> getUrltp() {
		return urltp;
	}

	/**
	 * @param urltp the urltp to set
	 */
	public void setUrltp(List<String> urltp) {
		this.urltp = urltp;
	}
}
