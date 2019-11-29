package com.etc.servlet;

import com.etc.model.ErrorException;
import com.etc.model.ShopEntity;
import com.etc.service.ShopService;
import com.etc.util.BaseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改密码,从前端传入两个密码
 */
@WebServlet(name = "ModifyServlet",urlPatterns = "/ModifyServlet")
public class ModifyPwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pwd1 = request.getParameter("newPwd1");
        String pwd2 = request.getParameter("newPwd2");

        ShopService service = new ShopService();

        try {
            service.modifyPwd((ShopEntity) request.getSession().getAttribute("CurrentLoginShop"), pwd1, pwd2);
            response.sendRedirect("sidebar.html#modify_pwd");
        } catch (BaseException e) {
            request.getSession().setAttribute("errorFlag", ErrorException.MODIFYPWD_ERROR);
            throw new ServletException(e.getMessage());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
