package com.etc.DAO;

import com.etc.model.OrderInfEntity;
import com.etc.model.OrdersEntity;
import com.etc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/23 21:46
 */
public class OrderInfDAO {
    public List<OrderInfEntity> loadOrderInf(OrdersEntity order){
        /**
         *
         *
         * @description: 查看订单详情
         * @param order
         * @return: java.util.List<com.etc.model.OrderInfEntity>
         * @author: hejw
         * @time: 2019/11/23 21:47
         */
        Session session = null;
        List<OrderInfEntity> orderInfEntityList = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            String hql = "from OrderInfEntity where order.orderId=" + order.getOrderId();
            orderInfEntityList = (List<OrderInfEntity>) session.createQuery(hql).list();
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
        return orderInfEntityList;
    }
}
