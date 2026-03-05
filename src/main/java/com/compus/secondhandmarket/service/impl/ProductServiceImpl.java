package com.compus.secondhandmarket.service.impl;

import com.compus.secondhandmarket.common.PageResult;
import com.compus.secondhandmarket.dto.ProductDTO;
import com.compus.secondhandmarket.dto.ProductQueryDTO;
import com.compus.secondhandmarket.entity.Product;
import com.compus.secondhandmarket.mapper.ProductMapper;
import com.compus.secondhandmarket.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public Product createProduct(ProductDTO productDTO, Long sellerId) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        product.setSellerId(sellerId);
        product.setStatus(1); // 默认上架
        product.setViewCount(0);

        productMapper.insert(product);
        return product;
    }

    @Override
    public Product updateProduct(Long id, ProductDTO productDTO) {
        Product product = productMapper.findById(id);
        if (product == null) {
            throw new RuntimeException("商品不存在");
        }
        BeanUtils.copyProperties(productDTO, product);
        // update逻辑...
        return product;
    }

    @Override
    public boolean updateStatus(Long id, Integer status) {
        return productMapper.updateStatus(id, status) > 0;
    }

    @Override
    public Product getProductDetail(Long id) {
        Product product = productMapper.findById(id);
        if (product == null) {
            throw new RuntimeException("商品不存在");
        }
        // 增加浏览量
        product.setViewCount(product.getViewCount() + 1);
        // 更新浏览量（可以异步处理）
        return product;
    }

    @Override
    public PageResult<Product> searchProducts(ProductQueryDTO queryDTO) {
        // 计算分页偏移量
        int offset = (queryDTO.getPage() - 1) * queryDTO.getSize();
        queryDTO.setOffset(offset);

        // 查询商品列表
        List<Product> products = productMapper.selectProducts(queryDTO);

        // 查询总数
        int total = productMapper.countProducts(queryDTO);

        return new PageResult<>((long) total, products, queryDTO.getPage(), queryDTO.getSize());
    }

    @Override
    public List<Product> getSellerProducts(Long sellerId) {
        return productMapper.findBySellerId(sellerId);
    }
}