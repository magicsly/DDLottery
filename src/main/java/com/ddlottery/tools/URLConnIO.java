package com.ddlottery.tools;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class URLConnIO {
	public URLConnIO() {

	}

	public static InputStream getSoapInputStream(String requestAddress,
			String requestData) {
		InputStream is = null;
		try {
			URL U = new URL(requestAddress);
			URLConnection conn = U.openConnection();
 			HttpURLConnection httpUrlConnection = (HttpURLConnection)conn; 
			byte[] bts = requestData.getBytes();
			httpUrlConnection.setUseCaches(false);
			httpUrlConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setRequestProperty("Content-Length",Integer.toString(bts.length));  
			httpUrlConnection.setDoOutput(true);
		    httpUrlConnection.connect();
            httpUrlConnection.getOutputStream().write(bts, 0, bts.length);
            httpUrlConnection.getOutputStream().flush();
            httpUrlConnection.getOutputStream().close();
			is = httpUrlConnection.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}
}