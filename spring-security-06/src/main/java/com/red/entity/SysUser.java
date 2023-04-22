package com.red.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysUser implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private String sex;
    private String address;
    private Integer enable;
    private Integer accountNoExpired;
    private Integer credentialsNoExpired;
    private Integer AccountNoLocked;
}
