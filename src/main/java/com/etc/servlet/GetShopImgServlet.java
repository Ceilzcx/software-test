package com.etc.servlet;

import com.etc.model.ShopEntity;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "GetShopImgServlet")
public class GetShopImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopEntity shopEntity = (ShopEntity) request.getSession().getAttribute("currentLoginShop");
        byte[] buffer = shopEntity.getShopTrademark();
        ServletOutputStream sops = response.getOutputStream();
        if (buffer != null)
            sops.write(buffer);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
