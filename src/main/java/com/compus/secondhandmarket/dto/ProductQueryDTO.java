package com.compus.secondhandmarket.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductQueryDTO {
    private Long categoryId;      // 分类ID
    private String keyword;        // 搜索关键词
    private BigDecimal minPrice;   // 最低价格
    private BigDecimal maxPrice;   // 最高价格
    private Integer page = 1;      // 当前页码
    private Integer size = 10;     // 每页数量
    private String sortBy = "created_at"; // 排序字段
    private String order = "desc"; // 排序方式

    // 以下字段不需要前端传，后端计算
    private Integer offset;        // 分页偏移量
}