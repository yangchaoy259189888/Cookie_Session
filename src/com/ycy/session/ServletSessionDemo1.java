package com.ycy.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName: ${NAME}
 * @Description:
 * @Author:
 * @Date: 2018/12/5 15:18
 * @Version: V1.0
 **/
@WebServlet(name = "ServletSessionDemo1", urlPatterns = "/ServletSessionDemo1")
public class ServletSessionDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        String id = request.getSession().getId();
        System.out.println("sessionId = " + id);


        response.getWriter().write("收到请求了...");
//        HttpSession session = request.getSession();
//        // 得到会话id
//        String id = session.getId();
//        System.out.println("id = " + id);
//        // 存值
//        session.setAttribute("name", 123143242);
//        // 取值
//        Object name = session.getAttribute("name");
//        System.out.println(name);
//        // 移除值
//        session.removeAttribute("name");
//        System.out.println(name);
    }
}
