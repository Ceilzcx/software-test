package com.etc.model;

import javax.persistence.*;

@Entity
@Table(name = "shop_evaluate", schema = "blm", catalog = "")
public class ShopEvaluateEntity {
    private int shopEvaluateId;
    private Integer shopEvaluateOrder;
    private Double shopGrade;
    private String shopEvaluateContent;
    private String shopEvaluateImage;
    private ShopEntity shop;
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }

    @Id
    @Column(name = "shop_evaluate_id", nullable = false)
    public int getShopEvaluateId() {
        return shopEvaluateId;
    }

    public void setShopEvaluateId(int shopEvaluateId) {
        this.shopEvaluateId = shopEvaluateId;
    }

    @Basic
    @Column(name = "shop_evaluate_order", nullable = true)
    public Integer getShopEvaluateOrder() {
        return shopEvaluateOrder;
    }

    public void setShopEvaluateOrder(Integer shopEvaluateOrder) {
        this.shopEvaluateOrder = shopEvaluateOrder;
    }

    @Basic
    @Column(name = "shop_grade", nullable = true, precision = 0)
    public Double getShopGrade() {
        return shopGrade;
    }

    public void setShopGrade(Double shopGrade) {
        this.shopGrade = shopGrade;
    }

    @Basic
    @Column(name = "shop_evaluate_content", nullable = true, length = 1024)
    public String getShopEvaluateContent() {
        return shopEvaluateContent;
    }

    public void setShopEvaluateContent(String shopEvaluateContent) {
        this.shopEvaluateContent = shopEvaluateContent;
    }

    @Basic
    @Column(name = "shop_evaluate_image", nullable = true, length = 1024)
    public String getShopEvaluateImage() {
        return shopEvaluateImage;
    }

    public void setShopEvaluateImage(String shopEvaluateImage) {
        this.shopEvaluateImage = shopEvaluateImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopEvaluateEntity that = (ShopEvaluateEntity) o;

        if (shopEvaluateId != that.shopEvaluateId) return false;
        if (shopEvaluateOrder != null ? !shopEvaluateOrder.equals(that.shopEvaluateOrder) : that.shopEvaluateOrder != null)
            return false;
        if (shopGrade != null ? !shopGrade.equals(that.shopGrade) : that.shopGrade != null) return false;
        if (shopEvaluateContent != null ? !shopEvaluateContent.equals(that.shopEvaluateContent) : that.shopEvaluateContent != null)
            return false;
        if (shopEvaluateImage != null ? !shopEvaluateImage.equals(that.shopEvaluateImage) : that.shopEvaluateImage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shopEvaluateId;
        result = 31 * result + (shopEvaluateOrder != null ? shopEvaluateOrder.hashCode() : 0);
        result = 31 * result + (shopGrade != null ? shopGrade.hashCode() : 0);
        result = 31 * result + (shopEvaluateContent != null ? shopEvaluateContent.hashCode() : 0);
        result = 31 * result + (shopEvaluateImage != null ? shopEvaluateImage.hashCode() : 0);
        return result;
    }
}
