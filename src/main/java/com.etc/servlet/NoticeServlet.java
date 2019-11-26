package com.etc.servlet;

import com.etc.model.ShopEntity;
import com.etc.service.ShopService;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String notice = request.getParameter("notice");
        ShopService shopService=new ShopService();
        shopService.announce((ShopEntity) request.getSession().getAttribute("currentLoginShop"),notice);
        HttpSession session=request.getSession();
        session.setAttribute("currentLoginShop", ShopEntity.currentLoginShop);
//        response.sendRedirect("sidebar.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
