package com.etc.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "orders", schema = "blm", catalog = "")
public class OrdersEntity {
    private int orderId;
    private Integer temporaryId;
    private Timestamp orderStartTime;
    private Timestamp orderFinishTime;
    private String orderStatus;
    private String orderRemark;
    private ShopEntity shop;
    private UserEntity user;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "temporary_id", nullable = true)
    public Integer getTemporaryId() {
        return temporaryId;
    }

    public void setTemporaryId(Integer temporaryId) {
        this.temporaryId = temporaryId;
    }

    @Basic
    @Column(name = "order_start_time", nullable = true)
    public Timestamp getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(Timestamp orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    @Basic
    @Column(name = "order_finish_time", nullable = true)
    public Timestamp getOrderFinishTime() {
        return orderFinishTime;
    }

    public void setOrderFinishTime(Timestamp orderFinishTime) {
        this.orderFinishTime = orderFinishTime;
    }

    @Basic
    @Column(name = "order_status", nullable = true, length = 20)
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "order_remark", nullable = true, length = 200)
    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        com.etc.model.OrdersEntity that = (com.etc.model.OrdersEntity) o;

        if (orderId != that.orderId) return false;
        if (temporaryId != null ? !temporaryId.equals(that.temporaryId) : that.temporaryId != null) return false;
        if (orderStartTime != null ? !orderStartTime.equals(that.orderStartTime) : that.orderStartTime != null)
            return false;
        if (orderFinishTime != null ? !orderFinishTime.equals(that.orderFinishTime) : that.orderFinishTime != null)
            return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;
        if (orderRemark != null ? !orderRemark.equals(that.orderRemark) : that.orderRemark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (temporaryId != null ? temporaryId.hashCode() : 0);
        result = 31 * result + (orderStartTime != null ? orderStartTime.hashCode() : 0);
        result = 31 * result + (orderFinishTime != null ? orderFinishTime.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (orderRemark != null ? orderRemark.hashCode() : 0);
        return result;
    }

}
