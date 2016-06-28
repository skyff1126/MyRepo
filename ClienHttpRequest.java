package com.movieclub.android.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
import org.apache.http.NameValuePair;

import android.text.TextUtils;
import android.util.Log;

public class ClienHttpRequest {
	
	public static String TAG = "ClienHttpRequest";
//	public static String HOST_PORT = "http://172.19.50.129:8080/";
// ÄÚÍø
//	public static String HOST_PORT = "http://172.19.50.75:8080/";
//	public static String IP = "172.19.50.129";
//	public static String PORT = ":8080/";
	//wai wang
//	public static String IP = "58.210.98.46";
//	public static String PORT = ":8082/";
	// could
	public static String IP = "161.202.31.102";
	public static String PORT = ":8080/";
	//dev
//	public static String HOST_PORT = "http://172.19.50.87:8080/";
//	public static String HOST_PORT = "http://161.202.31.102:8080/";
	
	public static String HOST_PORT = "http://"+ IP + PORT;
	
	public static String IMAGE_URL = HOST_PORT + "upload/";
	
	public static boolean DEBUG = false;
	
	public static String getRequestBody(String url) {
        String result = null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            HttpGet httpGet = new HttpGet(HOST_PORT+url);
            httpGet.addHeader("Content-Type", "application/json;charset=UTF-8");
            HttpResponse httpResponse = httpClient.execute(httpGet);
            
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = 
                    new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), Charset.forName("UTF-8")));
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                builder.append(s);
            }
            result = builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.getConnectionManager().shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(url))
		{
        	Log.d("http:", url);
		}
        if (!TextUtils.isEmpty(result))
		{
        	Log.d("http:", result);
		}
        return result;
    }
	
	public static String postRequestBody(String url, String content) {
        String result = null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost httpPost = new HttpPost(HOST_PORT+url);
            if (content != null && !"".equals(content) && content.length() > 0) {
                httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
                StringEntity se = new StringEntity(content, HTTP.UTF_8);
                httpPost.setEntity(se);
            }
            HttpResponse httpResponse = httpClient.execute(httpPost);

            StringBuilder builder = new StringBuilder();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), Charset.forName("UTF-8")));
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                builder.append(s);
            }
            result = builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.getConnectionManager().shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(url))
		{
        	Log.d("http:", url);
		}
        if (!TextUtils.isEmpty(result))
		{
        	Log.d("http:", result);
		}
        return result;
    }
	
	public static String postRequestBodyForContent(String url, JSONObject json) {
        String result = null;
        Log.d("json:", json.toString());
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost httpPost = new HttpPost(HOST_PORT+url);
            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
            
            if (json != null) {
            	StringEntity requestHttpEntity = new StringEntity(json.toString());
                httpPost.setEntity(requestHttpEntity);
            }
            HttpResponse httpResponse = httpClient.execute(httpPost);

            StringBuilder builder = new StringBuilder();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), Charset.forName("UTF-8")));
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                builder.append(s);
            }
            result = builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.getConnectionManager().shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(url))
		{
        	Log.d("http:", url);
		}
        if (!TextUtils.isEmpty(result))
		{
        	Log.d("http:", result);
		}
        return result;
    }
	
	public static String putRequestBodyForContent(String url, JSONObject json) {
        String result = null;
        Log.d("json:", json.toString());
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
        	HttpPut httpPut = new HttpPut(HOST_PORT+url);
        	httpPut.addHeader("Content-Type", "application/json;charset=UTF-8");
            
            if (json != null) {
            	StringEntity requestHttpEntity = new StringEntity(json.toString());
            	httpPut.setEntity(requestHttpEntity);
            }
            HttpResponse httpResponse = httpClient.execute(httpPut);

            StringBuilder builder = new StringBuilder();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), Charset.forName("UTF-8")));
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                builder.append(s);
            }
            result = builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.getConnectionManager().shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(url))
		{
        	Log.d("http:", url);
		}
        if (!TextUtils.isEmpty(result))
		{
        	Log.d("http:", result);
		}
        return result;
    }
	
}
