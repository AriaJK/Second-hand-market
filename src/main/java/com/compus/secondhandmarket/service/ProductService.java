package com.compus.secondhandmarket.service;

import com.compus.secondhandmarket.common.PageResult;
import com.compus.secondhandmarket.dto.ProductDTO;
import com.compus.secondhandmarket.dto.ProductQueryDTO;
import com.compus.secondhandmarket.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDTO productDTO, Long sellerId);
    Product updateProduct(Long id, ProductDTO productDTO);
    boolean updateStatus(Long id, Integer status);
    Product getProductDetail(Long id);
    PageResult<Product> searchProducts(ProductQueryDTO queryDTO);
    List<Product> getSellerProducts(Long sellerId);
}