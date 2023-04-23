package com.red.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    List<String> queryPermissionsByUserId(@Param("userId") Long userId);
}
