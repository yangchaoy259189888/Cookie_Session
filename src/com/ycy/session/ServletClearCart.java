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
 * @Date: 2018/12/5 17:51
 * @Version: V1.0
 **/
@WebServlet(name = "ServletClearCart", urlPatterns = "/ServletClearCart")
public class ServletClearCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("cart");
        response.sendRedirect("cart.jsp");
    }
}
