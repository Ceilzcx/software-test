package com.etc.DAO;

import com.etc.model.OrdersEntity;
import com.etc.model.ShopEntity;
import com.etc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/23 21:13
 */
public class OrdersDAO {
    public void finish(OrdersEntity order) {
        /**
         *
         *
         * @description: 商家完成订单
         * @param order
         * @return: void
         * @author: hejw
         * @time: 2019/11/23 21:18
         */
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            OrdersEntity o = session.get(OrdersEntity.class, order.getOrderId());
            o.setOrderStatus("已完成");
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

    public List<OrdersEntity> loadAllOrders(ShopEntity shop) {
        /**
         *
         *
         * @description: 加载所属商家的所有订单
         * @param shop
         * @return: java.util.List<com.etc.model.OrdersEntity>
         * @author: hejw
         * @time: 2019/11/23 21:35
         */
        Session session = null;
        List<OrdersEntity> ordersEntityList = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            String hql = "from OrdersEntity where shop.shopId=" + shop.getShopId();
            ordersEntityList = (List<OrdersEntity>) session.createQuery(hql).list();
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
        return ordersEntityList;
    }

//    public List<OrdersEntity> search(ShopEntity shop,)
}
