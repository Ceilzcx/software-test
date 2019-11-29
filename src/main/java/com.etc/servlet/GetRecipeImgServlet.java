package com.etc.servlet;

import com.etc.service.RecipeService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "GetRecipeImgServlet")
public class GetRecipeImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temp = request.getParameter("id");
        int id = Integer.parseInt(temp);

        RecipeService service = new RecipeService();
        InputStream is = service.imageInputStream(id);
        ServletOutputStream sops = response.getOutputStream();
        if (is == null){
            //暂不处理,图片不显示
        }else {
            byte[] buffer = new byte[1024];
            while (is.read(buffer) != -1)
                sops.write(buffer);
            is.close();
            sops.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
