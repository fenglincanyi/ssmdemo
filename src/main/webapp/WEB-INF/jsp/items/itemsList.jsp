<%@ page import="com.gjr.po.ItemsCustom" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/items/queryItems" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td><input type="submit" value="查询"/></td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <% List<ItemsCustom> list = (List) request.getAttribute("itemsList");%>

        <%for (int i = 0; i < list.size(); i++) {%>
        <tr>
            <td><%out.print(list.get(i).getName());%></td>
            <td><%out.print(list.get(i).getPrice());%></td>
            <td><%out.print(list.get(i).getCreatetime());%></td>
            <td><%out.print(list.get(i).getDetail());%></td>


            <td><a href="http://localhost:8080/ssmdemo/items/editItems?id=1">修改</a></td>
        </tr>
        <%}%>


    </table>
</form>
</body>

</html>