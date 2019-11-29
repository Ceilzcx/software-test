package com.etc.DAO;

import com.etc.model.RecipeEntity;
import com.etc.model.ShopEntity;
import com.etc.service.RecipeService;
import com.etc.util.BaseException;
import com.etc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.*;
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
            String hql = "from RecipeEntity where shop.shopId=" + shop.getShopId() + " and recipeStatus like '" + "正常" + "'";
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

    public void addRecipe(ShopEntity shop, String recipeName, double recipePrice, String recipeNotice, InputStream recipeImage, int recipeRemain, double recipeDiscount) throws BaseException {
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
            String hql = "from RecipeEntity where recipeName='" + recipeName + "' and recipeStatus like '" + "正常" + "'";
            Query query = session.createQuery(hql);
            if (query.list().size() != 0) {
                throw new BaseException("菜品已存在");
            }
            hql = "from RecipeEntity where recipeName='" + recipeName + "' and recipeStatus like '" + "删除" + "'";
            query = session.createQuery(hql);
            byte[] byteArray = new byte[recipeImage.available()];
            System.out.println(byteArray.length);
            if (query.list().size() != 0) {
                recipe = (RecipeEntity) query.list().get(0);
                recipe = session.get(RecipeEntity.class, recipe.getRecipeId());
                recipe.setMonthlySale(0);
                recipe.setRecipePrice(recipePrice);
                recipe.setRecipeDiscount(recipeDiscount);
                recipe.setRecipeImage(byteArray);
                recipe.setRecipeName(recipeName);
                recipe.setRecipeNotice(recipeNotice);
                recipe.setShop(shop);
                recipe.setRecipeRemain(recipeRemain);
                recipe.setRecipeStatus("正常");
            } else {
                recipe = new RecipeEntity();
                recipe.setMonthlySale(0);
                recipe.setRecipePrice(recipePrice);
                recipe.setRecipeDiscount(recipeDiscount);
                recipe.setRecipeImage(byteArray);
                recipe.setRecipeName(recipeName);
                recipe.setRecipeNotice(recipeNotice);
                recipe.setShop(shop);
                recipe.setRecipeRemain(recipeRemain);
                recipe.setRecipeStatus("正常");
                session.save(recipe);
            }

            tx.commit();
        } catch (BaseException | IOException e) {
            if (e instanceof IOException)
                throw new BaseException("图片上传失败");
            throw new BaseException(e.getMessage());
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
            r.setRecipeStatus("删除");
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

    public void modifyRecipe(RecipeEntity recipe, String recipeName, Double recipePrice, String recipeNotice, String recipeImage, Integer recipeRemain, Double recipeDiscount) throws BaseException {
        /**
         *
         *
         * @description: 修改菜品
         * @param recipe
         * @param recipeName
         * @param recipePrice
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
            FileInputStream fis = new FileInputStream(recipeImage);
            byte[] byteArray = new byte[fis.available()];
            RecipeEntity r = session.get(RecipeEntity.class, recipe.getRecipeId());
            r.setRecipeName(recipeName);
            r.setRecipePrice(recipePrice);
            r.setRecipeNotice(recipeNotice);
            r.setRecipeImage(byteArray);
            r.setRecipeRemain(recipeRemain);
            r.setRecipeDiscount(recipeDiscount);
            tx.commit();
        } catch (FileNotFoundException e) {
            throw new BaseException("找不到图片");
        } catch (IOException e) {
            throw new BaseException("图片上传失败");
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

    public List<RecipeEntity> search(ShopEntity shop, String recipeName) {
        Session session = null;
        Transaction tx = null;
        List<RecipeEntity> recipeEntities = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            String hql = "from RecipeEntity where recipeName like '%" + recipeName + "%'";
            recipeEntities = (List<RecipeEntity>) session.createQuery(hql).list();
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
        return recipeEntities;
    }

    public InputStream byteToInputStream(int id) {
        /**
         *
         *
         * @description: 根据菜返回图片的输入流
         * @param recipeEntity
         * @return: java.io.InputStream
         * @author: hejw
         * @time: 2019/11/29 21:08
         */
        Session session = null;
        Transaction tx = null;
        InputStream inputStream = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            String hql = "from RecipeEntity where recipeId = " + id + "";
            inputStream = new ByteArrayInputStream(((RecipeEntity) session.createQuery(hql).list().get(0)).getRecipeImage());
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
        return inputStream;
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
