package com.etc.service;

import com.etc.DAO.ShopEvaluateDAO;
import com.etc.model.ShopEntity;
import com.etc.model.ShopEvaluateEntity;

import java.util.List;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/24 16:13
 */
public class ShopEvaluateService {
    private ShopEvaluateDAO shopEvaluateDAO = new ShopEvaluateDAO();

    public List<ShopEvaluateEntity> viewShopEvaluations(ShopEntity shop) {
        return shopEvaluateDAO.loadAllEvaluations(shop);
    }
}
