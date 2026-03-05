package com.compus.secondhandmarket.common;

import lombok.Data;
import java.util.List;

@Data
public class PageResult<T> {
    private Long total;        // 总记录数
    private List<T> list;      // 当前页数据
    private Integer pageNum;    // 当前页码
    private Integer pageSize;   // 每页大小
    private Integer pages;      // 总页数

    public PageResult(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public PageResult(Long total, List<T> list, Integer pageNum, Integer pageSize) {
        this.total = total;
        this.list = list;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = (int) Math.ceil((double) total / pageSize);
    }
}