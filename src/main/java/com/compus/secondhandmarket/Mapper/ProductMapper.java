package com.compus.secondhandmarket.Mapper;

import com.compus.secondhandmarket.entity.Product;
import com.compus.secondhandmarket.entity.ProductQueryDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    // 简单查询用注解
    @Select("SELECT * FROM product WHERE id = #{id}")
    Product findById(Long id);

    @Select("SELECT * FROM product WHERE seller_id = #{sellerId} ORDER BY created_at DESC")
    List<Product> findBySellerId(Long sellerId);

    @Insert("INSERT INTO product (title, description, price, original_price, " +
            "category_id, seller_id, status) VALUES (#{title}, #{description}, " +
            "#{price}, #{originalPrice}, #{categoryId}, #{sellerId}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Product product);

    @Update("UPDATE product SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);

    // 复杂查询用XML
    List<Product> selectProducts(ProductQueryDTO queryDTO);
    int countProducts(ProductQueryDTO queryDTO);
}