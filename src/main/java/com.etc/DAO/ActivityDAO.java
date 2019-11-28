package com.etc.DAO;

import com.etc.model.ActivityEntity;
import com.etc.model.ShopEntity;
import com.etc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/23 22:23
 */
public class ActivityDAO {
    public void addActivity(ShopEntity shop, Double fullMoney,Double reduceMoney){
        /**
         *
         *
         * @description:
         * @param shop
         * @param fullMoney
         * @param reduceMoney
         * @return: void
         * @author: hejw
         * @time: 2019/11/23 22:27
         */
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            ActivityEntity activityEntity=new ActivityEntity();
            activityEntity.setShop(shop);
            activityEntity.setFullMoney(fullMoney);
            activityEntity.setReduceMoney(reduceMoney);
            session.save(activityEntity);
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
}
