package com.testfairy.app;

import org.apache.http.cookie.Cookie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CookieUtils {

	private Pattern cookiePattern = Pattern.compile("([^=]+)=([^\\;]*);?\\s?");

	public Map<String, String> parseCookieString(String cookies) {

		HashMap<String, String> out = new HashMap<String, String>();

		Matcher matcher = cookiePattern.matcher(cookies);
		while (matcher.find()) {
			String key = matcher.group(1);
			String value = matcher.group(2);
			out.put(key, value);
		}

		return out;
	}
}
