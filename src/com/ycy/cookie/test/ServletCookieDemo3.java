package com.ycy.cookie.test;

import com.ycy.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @ClassName: ${NAME}
 * @Description:
 * @Author:
 * @Date: 2018/12/4 9:10
 * @Version: V1.0
 **/
@WebServlet(name = "ServletCookieDemo3", urlPatterns = "/ServletCookieDemo3")
public class ServletCookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter printWriter = response.getWriter();

        if (username.equals("997592750") && password.equals("yyy123654")) {
            Cookie[] cookies = request.getCookies();

            Cookie cookie = CookieUtil.findCookie(cookies, "last");

            //是第一次登录，没有cookie
            if (cookie == null) {
                Cookie c = new Cookie("last", System.currentTimeMillis() + "");
                c.setMaxAge(60 * 60);
                response.addCookie(c);

                printWriter.write("<h1>登录成功</h1> " + username);
            } else {
                long lastVisitTime = Long.parseLong(cookie.getValue());
                printWriter.write("<h1>登录成功</h1> " + username +
                        ",上次来访的时间: " + new Date(lastVisitTime));
                cookie.setValue(System.currentTimeMillis() + "");
                response.addCookie(cookie);
            }
        } else {
            printWriter.write("<h1>登录失败</h1>");
        }
    }
}
