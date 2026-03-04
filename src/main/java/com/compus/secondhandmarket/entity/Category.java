package com.compus.secondhandmarket.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Category {
    private Long id;
    private String name;           // 分类名称
    private Long parentId;         // 父分类ID
    private String icon;           // 图标
    private Integer sort;          // 排序
    private LocalDateTime createdAt;
}