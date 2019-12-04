package com.etc.servlet;

import com.etc.model.ShopEntity;
import com.etc.service.ShopService;
import com.etc.util.BaseException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ShopInformationModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shopName = null;
        String shopAddr = null;
        InputStream shopTrademark = null;

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            throw new ServletException("图片上传失败");
        }

        for (FileItem item : items) {
            if (item.isFormField()) {
                String value = item.getString("UTF-8");
                if (item.getFieldName().equals("shopName")) {
                    shopName = value;
                } else if (item.getFieldName().equals("shopAddr")) {
                    shopAddr = value;
                }
            } else {
                shopTrademark = item.getInputStream();
            }
        }

        ShopService shopService = new ShopService();
        ShopEntity shopEntity = (ShopEntity) request.getSession().getAttribute("currentLoginShop");
        try {
            assert shopName != null;
            assert shopAddr != null;
            shopService.modifyShopMess(shopEntity, shopName, shopAddr, shopTrademark);
            HttpSession session = request.getSession();
            session.setAttribute("currentLoginShop", ShopEntity.currentLoginShop);
            response.sendRedirect("sidebar.html#information");
        } catch (BaseException | NullPointerException e) {
            throw new ServletException(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
