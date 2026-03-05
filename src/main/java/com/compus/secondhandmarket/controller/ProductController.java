package com.compus.secondhandmarket.controller;

import com.compus.secondhandmarket.common.ApiResponse;
import com.compus.secondhandmarket.common.PageResult;
import com.compus.secondhandmarket.dto.ProductDTO;
import com.compus.secondhandmarket.dto.ProductQueryDTO;
import com.compus.secondhandmarket.entity.Product;
import com.compus.secondhandmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // 发布商品（需要卖家登录）
    @PostMapping
    public ApiResponse<Product> createProduct(@RequestBody ProductDTO productDTO,
                                              HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        Integer userRole = (Integer) session.getAttribute("userRole");

        if (userId == null) {
            return ApiResponse.error(401, "请先登录");
        }
        if (userRole != 2) { // 2-卖家
            return ApiResponse.error(403, "只有卖家可以发布商品");
        }

        Product product = productService.createProduct(productDTO, userId);
        return ApiResponse.success(product);
    }

    // 搜索商品（公开接口）
    @GetMapping
    public ApiResponse<PageResult<Product>> searchProducts(ProductQueryDTO queryDTO) {
        PageResult<Product> result = productService.searchProducts(queryDTO);
        return ApiResponse.success(result);
    }

    // 获取商品详情
    @GetMapping("/{id}")
    public ApiResponse<Product> getProductDetail(@PathVariable Long id) {
        Product product = productService.getProductDetail(id);
        return ApiResponse.success(product);
    }

    // 获取卖家的商品列表
    @GetMapping("/seller/{sellerId}")
    public ApiResponse<List<Product>> getSellerProducts(@PathVariable Long sellerId) {
        List<Product> products = productService.getSellerProducts(sellerId);
        return ApiResponse.success(products);
    }

    // 更新商品状态（上架/下架）
    @PutMapping("/{id}/status")
    public ApiResponse<Void> updateStatus(@PathVariable Long id,
                                          @RequestParam Integer status,
                                          HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        // 检查权限（只能操作自己的商品）
        // ...
        productService.updateStatus(id, status);
        return ApiResponse.success(null);
    }
}