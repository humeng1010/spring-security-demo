package com.red.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "sys_role_menu", schema = "security_study")
public class RoleMenu {
    @Id
    @Column(name = "rid")
    private long rid;
    @Column(name = "mid")
    private long mid;

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleMenu that = (RoleMenu) o;
        return rid == that.rid && mid == that.mid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rid, mid);
    }
}
