package com.etc.service;

import com.etc.model.RecipeEntity;
import com.etc.model.ShopEntity;
import com.etc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/17 16:53
 */
public class RecipeService {
    public List<RecipeEntity> loadAllRecipes(ShopEntity shop){
        /**
         *
         *
         * @description: 加载所有菜品
         * @param shop
         * @return: java.util.List<com.etc.model.RecipeEntity>
         * @author: hejw
         * @time: 2019/11/17 21:16
         */
        Session session=null;
        List<RecipeEntity> recipeList=null;
        Transaction tx=null;
        try {
            session= HibernateUtil.getSession();
            tx=session.beginTransaction();
            String hql="from RecipeEntity ";
        }catch (Exception e){

        }
        return null;
    }
}
