package com.ycy.util;

import javax.servlet.http.Cookie;

/**
 * @ClassName: CookieUtil
 * @Description:
 * @Author:
 * @Date: 2018/12/4 9:21
 * @Version: V1.0
 **/
public class CookieUtil {
    public static Cookie findCookie(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }

        return null;
    }
}
