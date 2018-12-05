package com.ycy.servlet;

import com.ycy.util.CookieUtil;

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
 * @Date: 2018/12/4 23:01
 * @Version: V1.0
 **/
@WebServlet(name = "ServletProductInfo", urlPatterns = "/ServletProductInfo")
public class ServletProductInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取到用户准备浏览的商品id
        String id = request.getParameter("id");

        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtil.findCookie(cookies, "history");

        if (cookie == null) {
            //相应cookie
            Cookie c = new Cookie("history", id);
            response.addCookie(c);

            //跳转
            response.sendRedirect("product_info.htm");
        } else {
            //第二次
            //获取以前的cookie，以前的cookie，包含浏览记录
            String ids = cookie.getValue();

            //让现在浏览的商品和以前浏览的商品，形成新的cookie新的值
            cookie.setValue(id + "#" + ids);
            response.addCookie(cookie);

            //跳转
            response.sendRedirect("product_info.htm");
        }
    }
}
