package com.compus.secondhandmarket.mapper;

import com.compus.secondhandmarket.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE student_id = #{studentId}")
    User findByStudentId(String studentId);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Long id);

    @Insert("INSERT INTO user (student_id, username, password, role, phone) " +
            "VALUES (#{studentId}, #{username}, #{password}, #{role}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    @Update("UPDATE user SET username=#{username}, phone=#{phone}, avatar=#{avatar} " +
            "WHERE id=#{id}")
    int update(User user);

    @Select("SELECT COUNT(*) FROM user WHERE student_id = #{studentId}")
    int countByStudentId(String studentId);
}