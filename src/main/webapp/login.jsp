<%--
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

    <link rel="stylesheet" href="static/css/login.css"/>

</head>
<body>

    <div class="login">
        <div class="login_header">
            <img src="static/image/icon.jpg" class="login_icon"></div>
        <div>
            <form class="login_form" action="login" method="post">
                <section class="login_text"><input type="tel" maxlength="11" name="telephone" placeholder="手机号" value="17342019006">
                </section>
                <section class="login_text"><input type="password" maxlength="20" name="password" placeholder="密码" value="123456"></section>
                <div class="login_exception"><p><%=exception != null ? exception.getMessage() : ""%></p></div>
                <button class="login_button">
                    登录
                </button>
                <section class="login_register">
                    还没有登录?点击<a href="register.jsp">注册</a>
                </section>
            </form>
        </div>
    </div>

</body>
</html>
