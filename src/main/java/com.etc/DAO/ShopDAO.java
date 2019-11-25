package com.etc.DAO;

import com.etc.model.ShopEntity;
import com.etc.util.BaseException;
import com.etc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * @description:
 * @author: hejw
 * @time: 2019/11/17 15:28
 */
public class ShopDAO {
    public ShopEntity login(String shopTel, String shopPwd) throws BaseException {
        /**
         *
         *
         * @description: 商家登录, 修改数据库商家状态
         * @param shopTel
         * @param shopPwd
         * @return: com.etc.model.ShopEntity
         * @author: hejw
         * @time: 2019/11/17 15:59
         */
        ShopEntity shop = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            String hql = "from ShopEntity where shopTel='" + shopTel + "' and shopPwd='" + shopPwd + "'";
            Query query = session.createQuery(hql);
            if (query.list().size() != 0) {
                System.out.println(true);
                ShopEntity s = (ShopEntity) query.list().get(0);
                ShopEntity tmpShop = session.get(ShopEntity.class, s.getShopId());
                tmpShop.setShopStatus("在线");
                shop = tmpShop;
                tx.commit();
            } else {
                throw new BaseException("手机号或密码错误");
            }
        } catch (BaseException e) {
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
        return shop;
    }

    public ShopEntity reg(String shopPwd, String shopTel) throws BaseException {
        /**
         *
         *
         * @description: 商家注册
         * @param shopPwd1
         * @param shopPwd2
         * @param shopTel
         * @return: com.etc.model.ShopEntity
         * @author: hejw
         * @time: 2019/11/23 10:55
         */
        ShopEntity shop = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            String hql = "from ShopEntity where shopTel='" + shopTel + "'";
            Query query = session.createQuery(hql);
            if (query.list().size() != 0) {
                throw new BaseException("该手机号已注册");
            } else {
                shop = new ShopEntity();
                shop.setShopTel(shopTel);
                shop.setShopPwd(shopPwd);
                session.save(shop);
            }
            tx.commit();
        } catch (BaseException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return shop;
    }

    public ShopEntity modifyPwd(ShopEntity shop, String pwd){
        /**
         *
         *
         * @description: 修改登录密码
         * @param shop
         * @param pwd
         * @return: com.etc.model.ShopEntity
         * @author: hejw
         * @time: 2019/11/17 18:55
         */
        Session session = null;
        Transaction tx = null;
        ShopEntity tmpShop = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            ShopEntity s = session.get(ShopEntity.class, shop.getShopId());
            s.setShopPwd(pwd);
            tmpShop = s;
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
        return tmpShop;
    }

    public ShopEntity modifyShopMess(ShopEntity shop, String shopName, String shopPwd, String shopAddr, String shopTrademark) throws BaseException {
        /**
         *
         *
         * @description: 修改店铺信息
         * @param shop
         * @param shopName
         * @param shopPwd
         * @param shopAddr
         * @param shopTrademark
         * @return: void
         * @author: hejw
         * @time: 2019/11/17 18:42
         */
        Session session = null;
        Transaction tx = null;
        ShopEntity tmpShop = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            if (shop.getShopName().equals(shopName) == false) {
                String hql = "from ShopEntity where shopName='" + shopName + "'";
                Query query = session.createQuery(hql);
                if (query.list().size() != 0) {
                    throw new BaseException("店名已存在");
                }
            }
            ShopEntity s = session.get(ShopEntity.class, shop.getShopId());
            s.setShopPwd(shopPwd);
            s.setShopName(shopName);
            s.setShopAddress(shopAddr);
            s.setShopTrademark(shopTrademark); //存疑
            tmpShop = s;
            tx.commit();
        } catch (BaseException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tmpShop;
    }

    public ShopEntity announce(ShopEntity shop, String notice) {
        /**
         *
         *
         * @description: 商家发布公告（含修改公告）
         * @param shop
         * @param notice
         * @return: com.etc.model.ShopEntity
         * @author: hejw
         * @time: 2019/11/17 19:02
         */
        Session session = null;
        Transaction tx = null;
        ShopEntity tmpShop = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            ShopEntity s = session.get(ShopEntity.class, shop.getShopId());
            s.setShopNotice(notice);
            tmpShop = s;
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
        return tmpShop;
    }


}
