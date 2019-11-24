package com.etc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shop", schema = "blm", catalog = "")
public class ShopEntity {
    public static ShopEntity currentLoginShop = null;
    private int shopId;
    private String shopName;
    private String shopPwd;
    private String shopAddress;
    private String shopTel;
    private Double shopCore;
    private String shopNotice;
    private String shopTrademark;
    private String shopStatus;
    private Set<RecipeEntity> recipes;
    private Set<ActivityEntity> activities;
    private Set<OrdersEntity> orders;
    private Set<ShopEvaluateEntity> shopEvaluations;

    public Set<ShopEvaluateEntity> getShopEvaluations() {
        return shopEvaluations;
    }

    public void setShopEvaluations(Set<ShopEvaluateEntity> shopEvaluations) {
        this.shopEvaluations = shopEvaluations;
    }

    public Set<OrdersEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrdersEntity> orders) {
        this.orders = orders;
    }

    public Set<ActivityEntity> getActivities() {
        return activities;
    }

    public void setActivities(Set<ActivityEntity> activities) {
        this.activities = activities;
    }

    public Set<RecipeEntity> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<RecipeEntity> recipes) {
        this.recipes = recipes;
    }

    @Id
    @Column(name = "shop_id", nullable = false)
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "shop_name", nullable = true, length = 50)
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Basic
    @Column(name = "shop_pwd", nullable = true, length = 50)
    public String getShopPwd() {
        return shopPwd;
    }

    public void setShopPwd(String shopPwd) {
        this.shopPwd = shopPwd;
    }

    @Basic
    @Column(name = "shop_address", nullable = true, length = 255)
    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    @Basic
    @Column(name = "shop_tel", nullable = true, length = 20)
    public String getShopTel() {
        return shopTel;
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel;
    }

    @Basic
    @Column(name = "shop_core", nullable = true, precision = 0)
    public Double getShopCore() {
        return shopCore;
    }

    public void setShopCore(Double shopCore) {
        this.shopCore = shopCore;
    }

    @Basic
    @Column(name = "shop_notice", nullable = true, length = 500)
    public String getShopNotice() {
        return shopNotice;
    }

    public void setShopNotice(String shopNotice) {
        this.shopNotice = shopNotice;
    }

    @Basic
    @Column(name = "shop_trademark", nullable = true, length = 1024)
    public String getShopTrademark() {
        return shopTrademark;
    }

    public void setShopTrademark(String shopTrademark) {
        this.shopTrademark = shopTrademark;
    }

    @Basic
    @Column(name = "shop_status", nullable = true, length = 20)
    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopEntity that = (ShopEntity) o;

        if (shopId != that.shopId) return false;
        if (shopName != null ? !shopName.equals(that.shopName) : that.shopName != null) return false;
        if (shopPwd != null ? !shopPwd.equals(that.shopPwd) : that.shopPwd != null) return false;
        if (shopAddress != null ? !shopAddress.equals(that.shopAddress) : that.shopAddress != null) return false;
        if (shopTel != null ? !shopTel.equals(that.shopTel) : that.shopTel != null) return false;
        if (shopCore != null ? !shopCore.equals(that.shopCore) : that.shopCore != null) return false;
        if (shopNotice != null ? !shopNotice.equals(that.shopNotice) : that.shopNotice != null) return false;
        if (shopTrademark != null ? !shopTrademark.equals(that.shopTrademark) : that.shopTrademark != null)
            return false;
        if (shopStatus != null ? !shopStatus.equals(that.shopStatus) : that.shopStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shopId;
        result = 31 * result + (shopName != null ? shopName.hashCode() : 0);
        result = 31 * result + (shopPwd != null ? shopPwd.hashCode() : 0);
        result = 31 * result + (shopAddress != null ? shopAddress.hashCode() : 0);
        result = 31 * result + (shopTel != null ? shopTel.hashCode() : 0);
        result = 31 * result + (shopCore != null ? shopCore.hashCode() : 0);
        result = 31 * result + (shopNotice != null ? shopNotice.hashCode() : 0);
        result = 31 * result + (shopTrademark != null ? shopTrademark.hashCode() : 0);
        result = 31 * result + (shopStatus != null ? shopStatus.hashCode() : 0);
        return result;
    }
}
