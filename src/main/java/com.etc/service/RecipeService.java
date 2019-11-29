package com.etc.service;

import com.etc.DAO.RecipeDAO;
import com.etc.model.RecipeEntity;
import com.etc.model.ShopEntity;
import com.etc.util.BaseException;
import com.etc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.InputStream;
import java.util.List;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/17 16:53
 */
public class RecipeService {
    private RecipeDAO recipeDAO = new RecipeDAO();

    public List<RecipeEntity> viewRecipes(ShopEntity shop) {
        return recipeDAO.loadAllRecipes(shop);
    }

    public List<RecipeEntity> createRecipe(ShopEntity shop, String recipeName, double recipePrice, String recipeNotice, InputStream recipeImage, int recipeRemain, double recipeDiscount) throws BaseException {
        try {
            recipeDAO.addRecipe(shop, recipeName, recipePrice, recipeNotice, recipeImage, recipeRemain, recipeDiscount);
            System.out.println(shop.getShopName());
        } catch (BaseException e) {
            throw new BaseException(e.getMessage());
        }
        return recipeDAO.loadAllRecipes(shop);
    }

    public List<RecipeEntity> deleteRecipe(RecipeEntity recipe) {
        recipeDAO.deleteRecipe(recipe);
        return recipeDAO.loadAllRecipes(recipe.getShop());
    }

    public void modifyRecipe(RecipeEntity recipe, String recipeName, Double recipePrice, String recipeNotice, String recipeImage, Integer recipeRemain, Double recipeDiscount) throws BaseException {
        recipeDAO.modifyRecipe(recipe, recipeName.trim(), recipePrice, recipeNotice.trim(), recipeImage.trim(), recipeRemain, recipeDiscount);
    }

    public InputStream imageInputStream(int id) {
        return new RecipeDAO().byteToInputStream(id);
    }

}
