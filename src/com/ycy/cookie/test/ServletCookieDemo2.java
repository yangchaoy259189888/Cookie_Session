package com.ycy.cookie.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: ${NAME}
 * @Description:
 * @Author:
 * @Date: 2018/12/4 8:21
 * @Version: V1.0
 **/
@WebServlet(name = "ServletCookieDemo2", urlPatterns = "/ServletCookieDemo2")
public class ServletCookieDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        //取客户端发送过来的cookie.
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " = " + cookie.getValue());
            }
        }

        //1. 先写cookie 可以给客户端返回多个cookie
        Cookie cookie = new Cookie("name", "ycy");

        //2. 这个cookie的有效期。  默认情况下 ，
        //关闭浏览器后，cookie就没有了。 ---> 针对没有设置cookie的有效期。
        //	expiry： 有效 以秒计算。
        //正值 ： 表示 在这个数字过后，cookie将会失效。
        //负值： 关闭浏览器，那么cookie就失效， 默认值是 -1
        cookie.setMaxAge(60 *60);

//        赋值新的值
//        cookie.setValue("ycy");

//        用于指定只有请求了指定的域名，才会带上该cookie
//        cookie.setDomain(".ycy.com");
//        只有访问该域名下的cookieDemo的这个路径地址才会带cookie
//        cookie.setPath("/ServletCookieDemo2");

        response.addCookie(cookie);
    }
}
