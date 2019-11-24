package com.etc.service;

import com.etc.DAO.ActivityDAO;
import com.etc.model.ShopEntity;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/24 16:10
 */
public class ActivityService {
    private ActivityDAO activityDAO = new ActivityDAO();

    public void createActicity(ShopEntity shop, Double fullMoney, Double reduceMoney) {
        activityDAO.addActivity(shop, fullMoney, reduceMoney);
    }
}
