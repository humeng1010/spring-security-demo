package cn.wuluwulu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户角色中间表
 * 一个用户可以有多个角色
 * 一个角色可以有多个用户
 */
@Data
@TableName("sys_role_user")
public class RoleUser {
    private Long uid;
    private Long rid;
}
