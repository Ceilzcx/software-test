<%@ page import="com.etc.model.ErrorException" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="static/css/shop_modify_pwd.css"/>

    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>

</head>
<body>

<%
    String errorFlag = (String) session.getAttribute("errorFlag");
    String errorMessage = (String) session.getAttribute("errorMessage");
    String message = "";

    if (errorFlag != null && errorMessage != null){
        if(errorFlag.equals(ErrorException.MODIFYPWD_ERROR)) {
            message = errorMessage;
            session.setAttribute("errorMessage", "");
        }
    }
%>

<h3>修改密码</h3>

<form id="shop_pwd" action="ModifyPwdServlet" method="post">

    <div class="newPwd" align="center">
        输入新密码:<input type="password" class="newPwd1" name="newPwd1">
    </div>

    <div class="newPwd" align="center">
        确认新密码:<input type="password" class="newPwd2" name="newPwd2">
    </div>

    <div class="modifyPwd_exception"><p><%=message%></p></div>

    <div align="center">
        <button id="ok">确认</button>
    </div>

</form>

</body>
</html>
