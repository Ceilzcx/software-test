<%@ page import="com.etc.model.ErrorException" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/28
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>

<%
    String errorMessage = exception != null ? exception.getMessage() : "";
    String errorFlag = (String) session.getAttribute("errorFlag");

    session.setAttribute("errorMessage", errorMessage);

    if (errorFlag == null || errorMessage == null) {
        out.write("未知错误信息,点击返回<a href="+"login.jsp"+">登录页面</a>");
    }else {
        switch (errorFlag) {
            case ErrorException.LOGIN_ERROR:
                response.sendRedirect("login.jsp");
                break;
            case ErrorException.REGISTER_ERROR:
                response.sendRedirect("register.jsp");
                break;
            case ErrorException.MODIFYPWD_ERROR:
                response.sendRedirect("sidebar.html#modify_pwd");
                break;
            case ErrorException.MODIFY_SHOPINFO_ERROR:
                response.sendRedirect("sidebar.html#information");
        }
    }

%>