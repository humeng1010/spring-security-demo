package com.red.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysMenu {
    private Long id;
    private Long pid;
    private String name;
    private String code;
    private Integer type;
}
