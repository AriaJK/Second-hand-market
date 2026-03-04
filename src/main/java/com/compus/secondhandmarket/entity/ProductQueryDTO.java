package com.compus.secondhandmarket.entity;

import lombok.Data;

import java.math.BigDecimal;

// dto/ProductQueryDTO.java
@Data
public class ProductQueryDTO {
    private Long categoryId;
    private String keyword;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer page = 1;
    private Integer size = 10;
    private String sortBy = "created_at";
    private String order = "desc";
}
