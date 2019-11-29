<%@ page import="com.etc.model.ShopEntity" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/17
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="static/css/shop_information.css"/>

    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>

</head>
<body>

    <%
        ShopEntity shopEntity = (ShopEntity) session.getAttribute("currentLoginShop");
    %>

    <h3>店家信息</h3>

    <form action="shopInformationModify" id="shop_information" method="post" enctype="multipart/form-data">

        <div class="information">
            <div class="label_name">
                <label>店铺名称:</label>
            </div>

            <input type="text" name="shopName" value="<%=shopEntity.getShopName()%>">
        </div>

        <div class="information">
            <div class="label_name">
                <label>地址:</label>
            </div>

            <input type="text" name="shopAddr" value="<%=shopEntity.getShopAddress()%>">
        </div>

        <div class="information">
            <div class="label_name">
                <label>联系电话:</label>
            </div>

            <label><%=shopEntity.getShopTel()%></label>
        </div>

        <div class="information">
            <div class="label_name">
                <label>评分:</label>
            </div>

            <label><%=shopEntity.getShopCore()%></label>
        </div>

        <style>
            #shop_trademark{
                background:url("static/image/icon.jpg");
                background-size: 100% 100%;
                cursor: pointer;
            }
        </style>

        <div class="information" id="information_img">
            <div class="label_name">
                <label>图标:</label>
            </div>

            <div id="shop_trademark" >
                <input type="file" alt="点击切换图标" name="shopTrademark">
            </div>
        </div>

        <input type="submit" value="保存">

    </form>

</body>
</html>
