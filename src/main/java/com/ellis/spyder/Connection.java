package com.ellis.spyder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/*******************************************************************************
*
*<b>Title:</b> Connection.java
*<b>Project:</b> Spyder
*<b>Description:</b> This is the connection class that will handle connections 
*to servers based on http vs https
*<b>Copyright:</b> Copyright (c) 2022
*<b>Company:</b> Silicon Mountain Technologies
*@author Cameron Ellis
*@version 3.1
*@since Jun 15, 2022
*<b>updates:</b>
*
******************************************************************************/

public class Connection {

	private URL url;
	private int port;
	private String cookie;
	
	/**
	 * default constructor
	 */
	public Connection() {
		super();
	}

	/**
	 * @param url
	 * @param port
	 */
	public Connection(URL url, int port) {
		super();
		this.url = url;
		this.port = port;
	}

	/**
	 * method to return html from the requested resource /path
	 * @param path - resource to request
	 * @return string of html to be parsed by jsoup
	 * @throws Exception
	 */
	public String getWebPage(String path) throws Exception {
		// sslsocket class that just returns the connection?
		// try catch??

		Socket echoSocket = new Socket("www.siliconmtn.com", 443);
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket sslSocket = (SSLSocket) factory.createSocket(echoSocket, "www.siliconmtn.com", 443, true);

		sslSocket.startHandshake();

		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sslSocket.getOutputStream())));
		BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

		out.println("GET " + path + " HTTP/1.0");
		out.println("Host: www.siliconmtn.com");
		out.println("Cookie: " + this.cookie + "");
		out.println();
		out.flush();
		System.out.println("\n~this.cookie~\n " + this.cookie);


		String inputLine;
		StringBuilder html = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {

			html.append(inputLine).append("\n");
		}

		return html.toString();
	}
	
	/**
	 * method overloading to handle two urls for widget admin - will call 
	 * other getWebPage method if login post was successful 
	 * @param login
	 * @param widget
	 * @return string of html to be parsed by jsoup
	 * @throws Exception 
	 */
	public String getWebPage(String path, String widget, String body) throws Exception {
		// sslsocket class that just returns the connection?
		// try catch finally??
		// password, emailAddress	

		Socket echoSocket = new Socket("smt-stage.qa.siliconmtn.com", 443);
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket sslSocket = (SSLSocket) factory.createSocket(echoSocket, "smt-stage.qa.siliconmtn.com/admintool", 443, true);

		sslSocket.startHandshake();

		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sslSocket.getOutputStream())));
		BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));		
		
		String credentials = "emailAddress:cameron.ellis@siliconmtn.com; password:Smtrul3s!";
		String encodedCreds = Base64.getEncoder().encodeToString(body.getBytes());
		String basicAuth = "Basic " + encodedCreds;
		
		// not in headers in request body
		out.println("POST " + path + " HTTP/1.0");
		out.println("Host: https://smt-stage.qa.siliconmtn.com/admintool");
		out.println("Cookie: " + this.cookie);
		out.println("Content-Type: application/x-www-form-urlencoded");
		out.println("Content-Length: " + body.length());
		out.println("X-Frame-Options: SAMEORIGIN");
		out.println("Authorization: Basic");
		out.println();
		out.println(encodedCreds);
		out.println();
		out.flush();
		System.out.println("\n~this.cookie~\n " + this.cookie);

		String inputLine;
		StringBuilder html = new StringBuilder();


		while ((inputLine = in.readLine()) != null) {
			html.append(inputLine).append("\n");
		}

		return html.toString();
	}
	
//	public void close() {
//		out.close();
//		in.close();
//	}
	
	/**
	 * @return the cookie
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * @param cookie the cookie to set
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	
	/**
	 * @return the url
	 */
	public URL getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(URL url) {
		this.url = url;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
}
