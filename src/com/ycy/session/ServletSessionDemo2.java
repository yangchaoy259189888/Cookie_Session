package com.ycy.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ${NAME}
 * @Description:
 * @Author:
 * @Date: 2018/12/5 15:59
 * @Version: V1.0
 **/
@WebServlet(name = "ServletSessionDemo2", urlPatterns = "/ServletSessionDemo2")
public class ServletSessionDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        //1. 获取要添加到购物车的商品id
        String id = request.getParameter("id");

        String[] names = {"IPthon1", "IPthon2", "Pthon3", "IPthon4", "IPthon5", "IPthon6"};
        String name = names[Integer.parseInt(id)];

        //2. 获取购物车存放东西的session  Map<String , Integer>
        //把一个map对象存放到session里面去，并且保证只存一次。
        Map<String, Integer> map = (Map<String, Integer>) request.getSession()
                .getAttribute("cart");
        //session里面没有存放过任何东西。
        if (map == null) {
            map = new HashMap<>();
            request.getSession().setAttribute("cart", map);
        }

        if (map.containsKey(name)) {
            map.put(name, map.get(name) + 1);
        } else {
            map.put(name, 1);
        }

        response.getWriter().write("<a href='product_list_demo.jsp'><h3>继续购物</h3></a>");
        response.getWriter().write("<a href='cart.jsp'><h3>去购物车结算</h3></a>");
    }
}
