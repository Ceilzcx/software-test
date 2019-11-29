package com.etc.servlet;

import com.etc.model.RecipeEntity;
import com.etc.model.ShopEntity;
import com.etc.service.RecipeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ViewRecipeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeService recipeService=new RecipeService();
        List<RecipeEntity> recipeEntities=recipeService.viewRecipes((ShopEntity) request.getSession().getAttribute("currentLoginShop"));
//        response.
        HttpSession session=request.getSession();
        session.setAttribute("recipeEntities",recipeEntities);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
