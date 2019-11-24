package com.etc.DAO;

import com.etc.model.ShopEntity;
import com.etc.model.ShopEvaluateEntity;
import com.etc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/24 12:44
 */
public class ShopEvaluateDAO {
    public List<ShopEvaluateEntity> loadAllEvaluations(ShopEntity shop) {
        /**
         *
         *
         * @description:
         * @param shop
         * @return: java.util.List<com.etc.model.ShopEvaluateEntity>
         * @author: hejw
         * @time: 2019/11/24 12:56
         */
        Session session = null;
        List<ShopEvaluateEntity> shopEvaluateEntityList = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            String hql = "from ShopEvaluateEntity where ShopEntity.shopId=" + shop.getShopId();
            Query query = session.createQuery(hql);
            shopEvaluateEntityList = (List<ShopEvaluateEntity>)query.list();
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
        return shopEvaluateEntityList;
    }
}
