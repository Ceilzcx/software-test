<%@ page import="com.etc.service.OrdersService" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.criterion.Order" %>
<%@ page import="com.etc.model.OrdersEntity" %>
<%@ page import="com.etc.model.ShopEntity" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.etc.model.OrderInfEntity" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/24
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="static/css/recipe_manager.css"/>

    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>

</head>
<body>

<%
    OrdersService service = new OrdersService();
    List<OrdersEntity> entities = service.viewOrders((ShopEntity) session.getAttribute("currentLoginShop"));
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<h2>我的订单 My Order</h2>

<div class="search">
    <span>订单时间：</span>
    <input type="text" placeholder="筛选选择时间到现在的订单"/>
    <input type="button" value="查询"/>
</div>
<!--供应商操作表格-->
<table class="providerTable" cellpadding="0" cellspacing="0">
    <tr class="firstTr">
        <th width="20%">订单序号</th>
        <th width="15%">用户名称</th>
        <th width="40%">订单详情</th>
        <th width="25%">下单时间</th>
    </tr>
    <%for (int i = 0; i < entities.size(); i++) {
        Set<OrderInfEntity> infEntities = entities.get(i).getOrderInfs();
        StringBuilder builder = new StringBuilder();
        for (OrderInfEntity entity: infEntities) {
            builder.append(entity.getRecipe().getRecipeName() + "  X"+entity.getOrderRecipeNumber()+",  ");
        }
        builder=builder.deleteCharAt(builder.length()-1);
    %>
    <tr>
        <td><%=entities.get(i).getTemporaryId()%></td>
        <td><%=entities.get(i).getUser().getUserName()%></td>
        <td><%=builder.toString()%></td>
        <td><%=sdf.format(entities.get(i).getOrderFinishTime())%></td>
    </tr>
    <%}%>

</table>

</body>
</html>
