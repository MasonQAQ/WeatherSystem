package edu.hehai.shuili.weather.util;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by yangyue
 *
 * @Date: 26/10/2017
 * @Time: 11:57 PM
 * @package_name: edu.hehai.shuili.weather.util
 * @Description: 分页工具类
 */
public class Page<T>{

    //总条目
    @JSONField(ordinal = 1)
    private int totalCount;
    //总页数
    @JSONField(ordinal = 2)
    private int totalPage;
    //当前页码
    @JSONField(ordinal = 3)
    private int currentPage;
    //当前页条目
    @JSONField(ordinal = 4)
    private int currentSize;
    //每页大小
    @JSONField(ordinal = 5)
    private int pageSize=20;
    //当前页内容
    @JSONField(ordinal = 6)
    private List<T> list = null;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List <T> getList() {
        return list;
    }

    public void setList(List <T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"totalCount\":")
                .append(totalCount);
        sb.append(",\"totalPage\":")
                .append(totalPage);
        sb.append(",\"currentPage\":")
                .append(currentPage);
        sb.append(",\"currentSize\":")
                .append(currentSize);
        sb.append(",\"pageSize\":")
                .append(pageSize);
        sb.append(",\"list\":")
                .append(list);
        sb.append('}');
        return sb.toString();
    }
}
