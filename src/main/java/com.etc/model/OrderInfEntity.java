package com.etc.model;

import javax.persistence.*;

@Entity
@Table(name = "order_inf", schema = "blm", catalog = "")
public class OrderInfEntity {
    private int orderInfId;
    private Integer listId;
    private Integer orderRecipeNumber;
    private OrdersEntity order;
    private RecipeEntity recipe;

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    public OrdersEntity getOrder() {
        return order;
    }

    public void setOrder(OrdersEntity order) {
        this.order = order;
    }


    @Id
    @Column(name = "order_inf_id", nullable = false)
    public int getOrderInfId() {
        return orderInfId;
    }

    public void setOrderInfId(int orderInfId) {
        this.orderInfId = orderInfId;
    }

    @Basic
    @Column(name = "list_id", nullable = true)
    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    @Basic
    @Column(name = "order_recipe_number", nullable = true)
    public Integer getOrderRecipeNumber() {
        return orderRecipeNumber;
    }

    public void setOrderRecipeNumber(Integer orderRecipeNumber) {
        this.orderRecipeNumber = orderRecipeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderInfEntity that = (OrderInfEntity) o;

        if (orderInfId != that.orderInfId) return false;
        if (listId != null ? !listId.equals(that.listId) : that.listId != null) return false;
        if (orderRecipeNumber != null ? !orderRecipeNumber.equals(that.orderRecipeNumber) : that.orderRecipeNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderInfId;
        result = 31 * result + (listId != null ? listId.hashCode() : 0);
        result = 31 * result + (orderRecipeNumber != null ? orderRecipeNumber.hashCode() : 0);
        return result;
    }
}
