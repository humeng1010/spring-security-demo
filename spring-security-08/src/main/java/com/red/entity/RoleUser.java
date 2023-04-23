package com.red.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "sys_role_user", schema = "security_study")
public class RoleUser {
    @Id
    @Column(name = "uid")
    private long uid;
    @Column(name = "rid")
    private long rid;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleUser that = (RoleUser) o;
        return uid == that.uid && rid == that.rid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, rid);
    }
}
