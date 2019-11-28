package com.etc.service;

import com.etc.DAO.OrdersDAO;
import com.etc.model.OrdersEntity;
import com.etc.model.ShopEntity;

import java.util.List;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/24 15:32
 */
public class OrdersService {
    private OrdersDAO ordersDAO = new OrdersDAO();

    public void finish(OrdersEntity order) {
        ordersDAO.finish(order);
    }

    public List<OrdersEntity> viewOrders(ShopEntity shop) {
        return ordersDAO.loadAllOrders(shop);
    }

}
