package cn.zhouyafeng.itchat4j.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpClient {
	String fullUrl = "";
	StringBuffer sb = new StringBuffer();

	public String doGet(String url, Map<String, String> params) {

		if (params != null) {
			for (String param : params.keySet()) {
				sb.append(param);
				sb.append("=");
				sb.append(params.get(param));
				sb.append("&");
			}
		}

		if (sb.toString().length() != 0) {
			fullUrl = url + "?" + sb.toString().substring(0, sb.length() - 1); // 完整的URL
		} else {
			fullUrl = url;
		}

		System.out.println(fullUrl);
		String result = "";
		BufferedReader in = null;
		try {
			URL realUrl = new URL(fullUrl);
			URLConnection urlConnection = realUrl.openConnection();
			HttpURLConnection connection = null;
			if (urlConnection instanceof HttpURLConnection) {
				connection = (HttpURLConnection) urlConnection;
			} else {
				System.out.println("请输入 URL 地址");
				return null;
			}
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String urlString = "";
			String current;
			while ((current = in.readLine()) != null) {
				urlString += current;
			}
			result = urlString;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}