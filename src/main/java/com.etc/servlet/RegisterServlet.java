package com.etc.servlet;

import com.etc.model.ErrorException;
import com.etc.service.ShopService;
import com.etc.util.BaseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String telephone = request.getParameter("telephone");
        String pwd1 = request.getParameter("password1");
        String pwd2 = request.getParameter("password2");

        ShopService shopService=new ShopService();
        try {
            System.out.println("log1");
            if (shopService.reg(telephone, pwd1, pwd2)){
                System.out.println("log2");
                response.sendRedirect("login.jsp");
            }
        } catch (BaseException e) {
            request.getSession().setAttribute("errorFlag", ErrorException.REGISTER_ERROR);
            throw new ServletException(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}