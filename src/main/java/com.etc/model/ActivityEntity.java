package com.etc.model;

import javax.persistence.*;

@Entity
@Table(name = "activity", schema = "blm", catalog = "")
public class ActivityEntity {
    private int activityId;
    private Double fullMoney;
    private Double reduceMoney;

    @Id
    @Column(name = "activity_id", nullable = false)
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "full_money", nullable = true, precision = 0)
    public Double getFullMoney() {
        return fullMoney;
    }

    public void setFullMoney(Double fullMoney) {
        this.fullMoney = fullMoney;
    }

    @Basic
    @Column(name = "reduce_money", nullable = true, precision = 0)
    public Double getReduceMoney() {
        return reduceMoney;
    }

    public void setReduceMoney(Double reduceMoney) {
        this.reduceMoney = reduceMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityEntity that = (ActivityEntity) o;

        if (activityId != that.activityId) return false;
        if (fullMoney != null ? !fullMoney.equals(that.fullMoney) : that.fullMoney != null) return false;
        if (reduceMoney != null ? !reduceMoney.equals(that.reduceMoney) : that.reduceMoney != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = activityId;
        result = 31 * result + (fullMoney != null ? fullMoney.hashCode() : 0);
        result = 31 * result + (reduceMoney != null ? reduceMoney.hashCode() : 0);
        return result;
    }
}
