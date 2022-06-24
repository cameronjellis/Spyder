package com.ellis.spyder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	private Set<String> ltp = new HashSet<>();
	private List<URL> urltp = new ArrayList<>();
	
	public LinkManager(String initialUrl) throws MalformedURLException {
		urltp.add(new URL(initialUrl));
	}
	
	
	/**
	 * @return
	 * @throws MalformedURLException
	 */
	public List<URL> formatUrls() throws MalformedURLException{
		
		String baseURL = "https://www.siliconmtn.com";
		
		for (String link : ltp) {
			URL toParse = new URL(baseURL + link);
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
	
	/**
	 * @return the ltp
	 */
	public Set<String> getLtp() {
		return ltp;
	}

	/**
	 * @param ltp the ltp to set
	 */
	public void setLtp(Set<String> ltp) {
		this.ltp = ltp;
	}

	/**
	 * @return the urltp
	 */
	public List<URL> getUrltp() {
		return urltp;
	}

	/**
	 * @param urltp the urltp to set
	 */
	public void setUrltp(List<URL> urltp) {
		this.urltp = urltp;
	}
}
