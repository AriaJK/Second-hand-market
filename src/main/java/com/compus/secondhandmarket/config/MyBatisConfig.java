package com.compus.secondhandmarket.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.compus.secondhandmarket.mapper")
public class MyBatisConfig {
}