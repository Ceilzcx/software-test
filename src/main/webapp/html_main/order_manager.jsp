<%--
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

    <link rel="stylesheet" href="../static/css/recipe_manager.css"/>

    <script type="text/javascript" src="../static/js/jquery-3.4.1.js"></script>

</head>
<body>

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
        <tr>
            <td>1101110011</td>
            <td>王小二</td>
            <td>红烧肉一份,鸡蛋两个</td>
            <td>2019年11月18日 11:12:30</td>
        </tr>

    </table>

</body>
</html>
