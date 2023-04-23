package com.red.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_role", schema = "security_study")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "rolename")
    private String rolename;
    @Basic
    @Column(name = "remark")
    private String remark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role sysRole = (Role) o;
        return id == sysRole.id && Objects.equals(rolename, sysRole.rolename) && Objects.equals(remark, sysRole.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rolename, remark);
    }
}
