package com.ycy.servlet;

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
 * @Date: 2018/12/5 15:09
 * @Version: V1.0
 **/
@WebServlet(name = "ServletClearHistory", urlPatterns = "/ServletClearHistory")
public class ServletClearHistory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("history", "");
        // 设置立即删除
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        //跳转
        response.sendRedirect("product_list.jsp");
    }
}
