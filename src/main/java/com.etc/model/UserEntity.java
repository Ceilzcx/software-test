package com.etc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user", schema = "blm", catalog = "")
public class UserEntity {
    private int userId;
    private String userName;
    private String userPwd;
    private String userTel;
    private String userAddress;
    private String userImage;
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

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_pwd", nullable = true, length = 50)
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "user_tel", nullable = true, length = 20)
    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @Basic
    @Column(name = "user_address", nullable = true, length = 100)
    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Basic
    @Column(name = "user_image", nullable = true, length = 1024)
    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPwd != null ? !userPwd.equals(that.userPwd) : that.userPwd != null) return false;
        if (userTel != null ? !userTel.equals(that.userTel) : that.userTel != null) return false;
        if (userAddress != null ? !userAddress.equals(that.userAddress) : that.userAddress != null) return false;
        if (userImage != null ? !userImage.equals(that.userImage) : that.userImage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPwd != null ? userPwd.hashCode() : 0);
        result = 31 * result + (userTel != null ? userTel.hashCode() : 0);
        result = 31 * result + (userAddress != null ? userAddress.hashCode() : 0);
        result = 31 * result + (userImage != null ? userImage.hashCode() : 0);
        return result;
    }
}
