package com.ycy.cookie.test;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: ${NAME}
 * @Description:
 * @Author:
 * @Date: 2018/12/4 7:39
 * @Version: V1.0
 **/
public class ServletSkipDemo1 extends HttpServlet {
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
//            添加cookie
            Cookie cookie = new Cookie("aa", "bb");
            response.addCookie(cookie);

//            获取客户端带过来的cookie
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    String name = c.getName();
                    String value = c.getValue();
                    System.out.println(name + "=" + value);
                }
            }

//            response.setStatus(302);
//            response.setHeader("Location", "view/login_success.html");

//            重定向写法，地址上显示的是最后的那个资源的路径地址
//            response.sendRedirect("view/login_success.html");

//            请求转发，地址上显示的是请求servlet的地址。  返回200 ok
            request.getRequestDispatcher("view/login_success.html").forward(request, response);
        } else {
            printWriter.write("<h1>登录失败</h1>");
        }
    }
}
