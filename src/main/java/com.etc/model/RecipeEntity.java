package com.etc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "recipe", schema = "blm", catalog = "")
public class RecipeEntity {
    private int recipeId;
    private String recipeName;
    private Double recipePrice;
    private Integer monthlySale;
    private String recipeNotice;
    private String recipeImage;
    private Integer recipeRemain;
    private Double recipeDiscount;
    private String recipeStatus;
    private ShopEntity shop;
    private Set<OrderInfEntity> orderInfs;

    public Set<OrderInfEntity> getOrderInfs() {
        return orderInfs;
    }

    public void setOrderInfs(Set<OrderInfEntity> orderInfs) {
        this.orderInfs = orderInfs;
    }
    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }

    @Id
    @Column(name = "recipe_id", nullable = false)
    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    @Basic
    @Column(name = "recipe_name", nullable = true, length = 50)
    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    @Basic
    @Column(name = "recipe_price", nullable = true, precision = 0)
    public Double getRecipePrice() {
        return recipePrice;
    }

    public void setRecipePrice(Double recipePrice) {
        this.recipePrice = recipePrice;
    }

    @Basic
    @Column(name = "monthly_sale", nullable = true)
    public Integer getMonthlySale() {
        return monthlySale;
    }

    public void setMonthlySale(Integer monthlySale) {
        this.monthlySale = monthlySale;
    }

    @Basic
    @Column(name = "recipe_notice", nullable = true, length = 200)
    public String getRecipeNotice() {
        return recipeNotice;
    }

    public void setRecipeNotice(String recipeNotice) {
        this.recipeNotice = recipeNotice;
    }

    @Basic
    @Column(name = "recipe_image", nullable = true, length = 1024)
    public String getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage;
    }

    @Basic
    @Column(name = "recipe_remain", nullable = true)
    public Integer getRecipeRemain() {
        return recipeRemain;
    }

    public void setRecipeRemain(Integer recipeRemain) {
        this.recipeRemain = recipeRemain;
    }

    @Basic
    @Column(name = "recipe_discount", nullable = true, precision = 0)
    public Double getRecipeDiscount() {
        return recipeDiscount;
    }

    public void setRecipeDiscount(Double recipeDiscount) {
        this.recipeDiscount = recipeDiscount;
    }

    @Basic
    @Column(name = "recipe_status", nullable = true, length = 20)
    public String getRecipeStatus() {
        return recipeStatus;
    }

    public void setRecipeStatus(String recipeStatus) {
        this.recipeStatus = recipeStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeEntity that = (RecipeEntity) o;

        if (recipeId != that.recipeId) return false;
        if (recipeName != null ? !recipeName.equals(that.recipeName) : that.recipeName != null) return false;
        if (recipePrice != null ? !recipePrice.equals(that.recipePrice) : that.recipePrice != null) return false;
        if (monthlySale != null ? !monthlySale.equals(that.monthlySale) : that.monthlySale != null) return false;
        if (recipeNotice != null ? !recipeNotice.equals(that.recipeNotice) : that.recipeNotice != null) return false;
        if (recipeImage != null ? !recipeImage.equals(that.recipeImage) : that.recipeImage != null) return false;
        if (recipeRemain != null ? !recipeRemain.equals(that.recipeRemain) : that.recipeRemain != null) return false;
        if (recipeDiscount != null ? !recipeDiscount.equals(that.recipeDiscount) : that.recipeDiscount != null)
            return false;
        if (recipeStatus != null ? !recipeStatus.equals(that.recipeStatus) : that.recipeStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recipeId;
        result = 31 * result + (recipeName != null ? recipeName.hashCode() : 0);
        result = 31 * result + (recipePrice != null ? recipePrice.hashCode() : 0);
        result = 31 * result + (monthlySale != null ? monthlySale.hashCode() : 0);
        result = 31 * result + (recipeNotice != null ? recipeNotice.hashCode() : 0);
        result = 31 * result + (recipeImage != null ? recipeImage.hashCode() : 0);
        result = 31 * result + (recipeRemain != null ? recipeRemain.hashCode() : 0);
        result = 31 * result + (recipeDiscount != null ? recipeDiscount.hashCode() : 0);
        result = 31 * result + (recipeStatus != null ? recipeStatus.hashCode() : 0);
        return result;
    }
}
