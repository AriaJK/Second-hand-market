package com.compus.secondhandmarket.mapper;

import com.compus.secondhandmarket.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM category ORDER BY sort ASC")
    List<Category> findAll();

    @Select("SELECT * FROM category WHERE parent_id = #{parentId} ORDER BY sort ASC")
    List<Category> findByParentId(Long parentId);

    @Select("SELECT * FROM category WHERE id = #{id}")
    Category findById(Long id);
}