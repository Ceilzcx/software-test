<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/17
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="../static/css/shop_information.css"/>

    <script type="text/javascript" src="../static/js/jquery-3.4.1.js"></script>

</head>
<body>

    <h3>个人信息</h3>

    <form action="" id="shop_information">

        <div class="information">
            <div class="label_name">
                <label>店铺名称:</label>
            </div>

            <input type="text">
        </div>

        <div class="information">
            <div class="label_name">
                <label>地址:</label>
            </div>

            <input type="text">
        </div>

        <div class="information">
            <div class="label_name">
                <label>联系电话:</label>
            </div>

            <label>15669032560</label>
        </div>

        <div class="information">
            <div class="label_name">
                <label>评分:</label>
            </div>

            <label>9.4</label>
        </div>

        <style>
            #shop_trademark{
                background:url("../../image/icon.jpg");
                background-size: 100% 100%;
                cursor: pointer;
            }
        </style>

        <div class="information" id="information_img">
            <div class="label_name">
                <label>图标:</label>
            </div>

            <div id="shop_trademark" >
                <input type="file" name="" alt="点击切换图标">
            </div>
        </div>

        <input type="submit" value="保存">

    </form>
</body>
</html>
