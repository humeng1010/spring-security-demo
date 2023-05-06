package cn.wuluwulu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 角色-权限中间表
 * 一个角色可以有多个权限
 * 一个权限可以有多个角色掌控
 */
@Data
@TableName("sys_role_menu")
public class RoleMenu {
    // 角色id
    private Long rid;
    // 权限id
    private Long mid;
}
