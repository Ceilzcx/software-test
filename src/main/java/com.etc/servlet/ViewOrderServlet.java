package com.etc.servlet;

import com.etc.model.OrdersEntity;
import com.etc.model.ShopEntity;
import com.etc.service.OrdersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ViewOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrdersService ordersService=new OrdersService();
        List<OrdersEntity> ordersEntities= ordersService.viewOrders((ShopEntity) request.getSession().getAttribute("currentLoginShop"));
        HttpSession session=request.getSession();
        session.setAttribute("recipeEntities",ordersEntities);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
