<%@ page import="com.etc.model.ErrorException" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/6
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="static/css/register.css"/>

</head>
<body>

    <%
        String errorFlag = (String) session.getAttribute("errorFlag");
        String errorMessage = (String) session.getAttribute("errorMessage");
        String message = "";

        if (errorFlag != null && errorMessage != null){
            if(errorFlag.equals(ErrorException.REGISTER_ERROR)) {
                message = errorMessage;
                session.setAttribute("errorMessage", "");
            }
        }
    %>

    <div class="register">
        <div class="register_header">
            <img src="static/image/icon.jpg" class="register_icon">
        </div>
        <div>
            <form class="register_form" action="register" method="post">
                <section class="register_text"><input type="tel" maxlength="11" name="telephone" placeholder="手机号"></section>
                <section class="register_text"><input type="password" maxlength="20" name="password" placeholder="密码"></section>
                <section class="register_text"><input type="password" maxlength="20" name="password" placeholder="密码"></section>
                <div class="register_exception"><p><%=exception != null ? exception.getMessage() : ""%></p></div>
                <button class="register_button">
                    注册
                </button>
            </form>
        </div>
    </div>

</body>
</html>
