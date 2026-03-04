package com.compus.secondhandmarket.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product {
    private Long id;
    private String title;          // 商品标题
    private String description;    // 商品描述
    private BigDecimal price;      // 价格
    private BigDecimal originalPrice; // 原价
    private Long categoryId;       // 分类ID
    private Long sellerId;         // 卖家ID
    private Integer status;        // 状态：1-上架 2-下架 3-已售出
    private Integer viewCount;     // 浏览数
    private Boolean isRecommended; // 是否推荐
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 关联信息（查询时用）
    private String sellerName;     // 卖家用户名
    private String categoryName;   // 分类名称
}