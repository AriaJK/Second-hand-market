package com.compus.secondhandmarket.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductDTO {
    private String title;          // 商品标题
    private String description;    // 商品描述
    private BigDecimal price;      // 价格
    private BigDecimal originalPrice; // 原价
    private Long categoryId;       // 分类ID
}