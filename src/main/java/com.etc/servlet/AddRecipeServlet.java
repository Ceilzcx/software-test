package com.etc.servlet;

import com.etc.model.ShopEntity;
import com.etc.service.RecipeService;
import com.etc.util.BaseException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class AddRecipeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String recipeName = null;
        String recipePrice = null;
        String recipeRemain = null;
        String recipeDiscount = null;
        String recipeNotice = null;
        InputStream recipeImage = null;
        //这种方法主要通过if (item.isFormField())这个条件判别文件还是非文件
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            throw new ServletException("图片上传失败");
        } // 解析request请求

        for (FileItem item : items)
            if (item.isFormField()) { // 如果是表单域 ，就是非文件上传元素
                String value = item.getString("UTF-8");// 获取value属性的值，这里需要指明UTF-8格式，否则出现中文乱码问题
                if (item.getFieldName().equals("recipe_name")) {// 对应form中属性的名字
                    recipeName = value;
                } else if (item.getFieldName().equals("recipe_price")) {
                    recipePrice = value;
                } else if (item.getFieldName().equals("recipe_remain")) {
                    recipeRemain = value;
                } else if (item.getFieldName().equals("recipe_discount")) {
                    recipeDiscount = value;
                } else if (item.getFieldName().equals("recipe_notice")) {
                    recipeNotice = value;
                }
            } else {
                recipeImage = item.getInputStream();//将文件转为输入流
            }

        Double doublePrice = null;
        Integer intRemain = null;
        Double doubleDiscount = null;

        try {
            assert recipePrice != null;
            doublePrice = Double.valueOf(recipePrice);
            assert recipeRemain != null;
            intRemain = Integer.valueOf(recipeRemain);
            assert recipeDiscount != null;
            doubleDiscount = Double.valueOf(recipeDiscount);
        } catch (NumberFormatException | NullPointerException e) {
            throw new ServletException("价格、余量、折扣设置错误");
        }
        RecipeService recipeService = new RecipeService();
        ShopEntity shopEntity = (ShopEntity) request.getSession().getAttribute("currentLoginShop");
        try {
            recipeService.createRecipe(shopEntity, recipeName, doublePrice, recipeNotice, recipeImage, intRemain, doubleDiscount);
            response.sendRedirect("sidebar.html#recipe_manager");
        } catch (BaseException e) {
            throw new ServletException(e.getMessage());
        }
//
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
