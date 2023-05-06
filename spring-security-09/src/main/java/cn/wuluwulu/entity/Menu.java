package cn.wuluwulu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 权限表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("sys_menu")
public class Menu {
    private Long id;
    private Long pid;
    private String name;
    private String code;
    private Integer type;
    private Integer deleted;
}
