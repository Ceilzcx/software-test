package com.etc.service;

import com.etc.DAO.OrderInfDAO;
import com.etc.model.OrderInfEntity;
import com.etc.model.OrdersEntity;

import java.util.List;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/24 16:07
 */
public class OrderInfService {
    private OrderInfDAO orderInfDAO = new OrderInfDAO();

    public List<OrderInfEntity> findOrderInformations(OrdersEntity order) {
        return orderInfDAO.findOrderInformations(order);
    }
}
