package com.test.springbootmall.util;

import java.util.List;

public class ProductPage<T> {
    private Integer limit;//一頁顯示多少筆
    private Integer offset;//顯示的從第幾筆開始算
    private Integer tatol;//總數幾筆
    private List<T> results;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTatol() {
        return tatol;
    }

    public void setTatol(Integer tatol) {
        this.tatol = tatol;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }



}
