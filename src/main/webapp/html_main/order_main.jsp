<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/6
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="../static/css/oder_main.css"/>

    <script type="text/javascript" src="../static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="../static/js/showtime.js"></script>
</head>
<body>

    <div id="page1"></div>
    <script>$("#page1").load("header.html")</script>

    <div id="main">

        <div id="page2"></div>
        <script>$("#page2").load("sidebar.html")</script>

        <div id="content">

            <h3>今日订单</h3>

            <div id="order_main_detail">

                <h4>订单详情</h4>
                <div id="showtime" onload="showTime()"></div>

            </div>

        </div>

    </div>

</body>
</html>
