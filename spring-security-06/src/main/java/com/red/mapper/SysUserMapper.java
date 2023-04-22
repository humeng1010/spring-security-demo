package com.red.mapper;

import com.red.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper {
    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    SysUser getUserByName(@Param("username") String username);
}
