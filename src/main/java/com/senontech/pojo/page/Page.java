package com.senontech.pojo.page;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @description: 通用分页对象
 * @author: gyk
 * @date: 2020/9/25 11:09
 */
public class Page<T> {

    /**
     * 页码
     */
    private Integer page;

    /**
     * 一页的大小
     */
    private Integer size;

    /**
     * 当前起始数据下标（前端展示从1开始）
     */
    private Long countNow;

    /**
     * 当前起始数据下标（数据库从0开始）
     */
    @JSONField(serialize = false)
    private Long startNum;

    /**
     * 一页内的数据
     */
    private List<T> list;

    /**
     * 数据总数
     */
    private Long total;

    /**
     * 页数总数
     */
    private Long totalPage;

    /**
     * 分页查询条件
     */
    @JSONField(serialize = false)
    private String condition;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getCountNow() {
        return countNow;
    }

    public void setCountNow(Long countNow) {
        this.countNow = countNow;
    }

    public Long getStartNum() {
        return startNum;
    }

    public void setStartNum(Long startNum) {
        this.startNum = startNum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", size=" + size +
                ", countNow=" + countNow +
                ", startNum=" + startNum +
                ", list=" + list +
                ", total=" + total +
                ", totalPage=" + totalPage +
                ", condition='" + condition + '\'' +
                '}';
    }
}
