package com.etc.DAO;

import com.etc.model.RecipeEntity;
import com.etc.model.ShopEntity;
import com.etc.service.RecipeService;
import com.etc.util.BaseException;
import com.etc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/17 16:53
 */
public class RecipeDAO {
    public List<RecipeEntity> loadAllRecipes(ShopEntity shop) {
        /**
         *
         *
         * @description: 加载所有菜品
         * @param shop
         * @return: java.util.List<com.etc.model.RecipeEntity>
         * @author: hejw
         * @time: 2019/11/17 21:16
         */
        Session session = null;
        List<RecipeEntity> recipeList = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            String hql = "from RecipeEntity where shop.shopId=" + shop.getShopId() /*+ " and recipeStatus not like '" + "已删除" + "'"*/;
            recipeList = (List<RecipeEntity>) session.createQuery(hql).list();
            tx.commit();
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return recipeList;
    }

    public void addRecipe(ShopEntity shop, String recipeName, double recipePrice, String recipeNotice, String recipeImage, int recipeRemain, double recipeDiscount) throws BaseException {
        /**
         *
         *
         * @description: 添加菜品
         * @param shop
         * @param recipeName
         * @param recipePrice
         * @param recipeNotice
         * @param recipeImage
         * @param recipeRemain
         * @param recipeDiscount
         * @return: void
         * @author: hejw
         * @time: 2019/11/23 11:26
         */
        Session session = null;
        Transaction tx = null;
        RecipeEntity recipe = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            String hql = "from RecipeEntity where recipeName='" + recipeName + "' and recipeStatus not like '" + "已删除" + "'";
            Query query = session.createQuery(hql);
            if (query.list().size() != 0) {
                throw new BaseException("菜品已存在");
            }
            hql = "from RecipeEntity where recipeName='" + recipeName + "' and recipeStatus like '" + "已删除" + "'";
            query = session.createQuery(hql);
            if (query.list().size() != 0) {
                recipe = (RecipeEntity) query.list().get(0);
                recipe = session.get(RecipeEntity.class, recipe.getRecipeId());
                recipe.setMonthlySale(0);
                recipe.setRecipePrice(recipePrice);
                recipe.setRecipeDiscount(recipeDiscount);
                recipe.setRecipeImage(recipeImage);
                recipe.setRecipeName(recipeName);
                recipe.setRecipeNotice(recipeNotice);
                recipe.setShop(shop);
                recipe.setRecipeRemain(recipeRemain);
                recipe.setRecipeStatus(null);
            } else {
                recipe = new RecipeEntity();
                recipe.setMonthlySale(0);
                recipe.setRecipePrice(recipePrice);
                recipe.setRecipeDiscount(recipeDiscount);
                recipe.setRecipeImage(recipeImage);
                recipe.setRecipeName(recipeName);
                recipe.setRecipeNotice(recipeNotice);
                recipe.setShop(shop);
                recipe.setRecipeRemain(recipeRemain);
                session.save(recipe);
            }

            tx.commit();
        } catch (BaseException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteRecipe(RecipeEntity recipe) {
        /**
         *
         *
         * @description: 删除菜品
         * @param recipe
         * @return: void
         * @author: hejw
         * @time: 2019/11/23 20:55
         */
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            RecipeEntity r = session.get(RecipeEntity.class, recipe.getRecipeId());
            r.setRecipeStatus("已删除");
            tx.commit();
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void modifyRecipe(RecipeEntity recipe, String recipeName, Double recipePrice, Integer monthlySale, String recipeNotice, String recipeImage, Integer recipeRemain, Double recipeDiscount) {
        /**
         *
         *
         * @description: 修改菜品
         * @param recipe
         * @param recipeName
         * @param recipePrice
         * @param monthlySale
         * @param recipeNotice
         * @param recipeImage
         * @param recipeRemain
         * @param recipeDiscount
         * @param recipeStatus
         * @return: void
         * @author: hejw
         * @time: 2019/11/23 21:02
         */
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            RecipeEntity r = session.get(RecipeEntity.class, recipe.getRecipeId());
            r.setRecipeName(recipeName);
            r.setRecipePrice(recipePrice);
            r.setMonthlySale(monthlySale);
            r.setRecipeNotice(recipeNotice);
            r.setRecipeImage(recipeImage);
            r.setRecipeRemain(recipeRemain);
            r.setRecipeDiscount(recipeDiscount);
            tx.commit();
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ShopEntity entity = new ShopEntity();
        entity.setShopId(1);
        RecipeDAO dao = new RecipeDAO();
        List<RecipeEntity> entities = dao.loadAllRecipes(entity);
        for (int i = 0; i < entities.size(); i++) {
            System.out.println(entities.get(i).getRecipeName());
        }
    }
}
