<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 西邮陈冠希
  Date: 2018/12/5
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>购物车商品如下：</h2>
<%
    //1. 先获取到map
    Map<String, Integer> map = (Map<String, Integer>) session.getAttribute("cart");
    //2. 遍历map
    if (map != null) {
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            //key :商品名称 ， vlaue : 商品个数
            //<h3>名称：iphone7   数量:6</h3>
%>
            <h3>名称：<%=key%> 数量:<%=value%></h3><br>
<%
        }
    }
%>
<a href="ServletClearCart"><h4>清空购物车</h4></a>
</body>
</html>
