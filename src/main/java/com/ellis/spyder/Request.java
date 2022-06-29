package com.ellis.spyder;

import java.util.HashMap;
import java.util.Map;

/*******************************************************************************
*
*<b>Title:</b> Request.java
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

public class Request {
	
	Map<String, String> reqBody = new HashMap<>();
	
	public String formatBody(String emailAddress, String password) {
		this.reqBody.put("emailAddress", emailAddress);
		this.reqBody.put("password", password);
		return this.reqBody.toString();
	}

	public void getRequest() {
		
	}
	
	public void postRequest() {
		
	}
	
}
