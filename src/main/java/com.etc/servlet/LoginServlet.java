package com.etc.servlet;

import com.etc.model.ShopEntity;
import com.etc.service.ShopService;
import com.etc.util.BaseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String shopTel = request.getParameter("telephone");
        String shopPwd = request.getParameter("password");

        ShopService shopService=new ShopService();
        try {
            if (shopService.login(shopTel, shopPwd)){
                HttpSession session=request.getSession();
                session.setAttribute("currentLoginShop", ShopEntity.currentLoginShop);
                response.sendRedirect("sidebar.html");
            }
        } catch (BaseException e) {
            throw new ServletException(e.getMessage());
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}