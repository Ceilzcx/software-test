package com.etc.service;

import com.etc.DAO.ShopDAO;
import com.etc.model.ShopEntity;
import com.etc.util.BaseException;
import com.etc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/17 15:28
 */
public class ShopService {
    private ShopDAO shopDAO = new ShopDAO();

    public boolean login(String shopTel, String shopPwd) throws BaseException {
        try {
            ShopEntity.currentLoginShop = shopDAO.login(shopTel.trim(), shopPwd);
        } catch (BaseException e) {
            System.out.println(false);
            throw new BaseException(e.getMessage());
        }
        return true;
    }

    public boolean reg(String shopPwd1, String shopPwd2, String shopTel) throws BaseException {
        try {
            if ((shopPwd1 == null || shopPwd1.equals("")) || (shopPwd2 == null || shopPwd2.equals("")) || (shopTel == null || shopTel.equals(""))) {
                throw new BaseException("请填写完整的注册信息");
            }

            shopTel = shopTel.trim();
            String regex = ".*[a-zA-Z]+.*";
            Matcher m = Pattern.compile(regex).matcher(shopTel);
            if (shopTel.length() != 11 || m.matches()) {
                throw new BaseException("请填写正确的手机号");
            }

            if (!shopPwd1.equals(shopPwd2)) {
                throw new BaseException("密码不匹配");
            }
            ShopEntity.currentLoginShop = shopDAO.reg(shopPwd1, shopTel);
        } catch (BaseException e) {
            throw new BaseException(e.getMessage());
        }
        return true;
    }

    public boolean modifyPwd(ShopEntity shop, String shopPwd1, String shopPwd2) throws BaseException {
        if (shopPwd1.equals("") || shopPwd2.equals(""))
            throw new BaseException("密码输入为空");
        if (!shopPwd1.equals(shopPwd2)) {
            throw new BaseException("密码不匹配");
        }
        ShopEntity.currentLoginShop = shopDAO.modifyPwd(shop, shopPwd1);
        return true;
    }

    public boolean modifyShopMess(ShopEntity shop, String shopName, String shopAddr, InputStream shopTrademark) throws BaseException {
        try {
            ShopEntity.currentLoginShop = shopDAO.modifyShopMess(shop, shopName.trim(), shopAddr.trim(), shopTrademark);
        } catch (BaseException e) {
            throw new BaseException(e.getMessage());
        }
        return true;
    }

    public void announce(ShopEntity shop, String notice) {
        ShopEntity.currentLoginShop = shopDAO.announce(shop, notice.trim());
    }

}
