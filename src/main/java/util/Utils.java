package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Utils {
	public static String getUserId(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String userId = null;
		if (cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userId")) {
					userId = cookie.getValue();
					break;
				}
			}
		}
		return userId;
	}
}
