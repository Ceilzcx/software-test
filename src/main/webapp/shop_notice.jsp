<%@ page import="com.etc.model.ShopEntity" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/17
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="static/css/shop_notice.css"/>

    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>

</head>
<body>

<%
    String content = ((ShopEntity)session.getAttribute("currentLoginShop")).getShopNotice();
%>

<h2>公告</h2>

<form action="notice" method="post">

    <div id="notice_content">
        <textarea class="notice" id="notice" name="notice"></textarea>
    </div>

    <script>
        $("#notice").val("<%=content == null ? "" : content%>")
    </script>

    <div class="notice_button">
        <button id="ok">保存</button>
    </div>
</form>

</body>
</html>
