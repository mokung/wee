package me.wenkang.wee.components.constant.page;

import java.io.Serializable;

/**
 * Created by wenkang 
 * on 2017/11/16.
 */
public class Pager implements Serializable{

    private static final long serialVersionUID = -1090402301397940810L;

    private int curPage = 1;
    private int pageSize = 50;
    private int total = 0;
    private String orderBy = "";
    private int totalPage = 0;
    private boolean needPage = true;

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        if (curPage < 1){
            throw new IllegalArgumentException("页数小于1");
        }
        this.curPage = curPage;
    }

    private void calTotalPage() {
        if(0 != this.pageSize) {
            this.totalPage = this.total % this.pageSize == 0?this.total / this.pageSize:this.total / this.pageSize + 1;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1){
            throw new IllegalArgumentException("pageSize小于1");
        }
        this.pageSize = pageSize;
        this.calTotalPage();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        this.calTotalPage();
    }


    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public boolean isNeedPage() {
        return needPage;
    }

    public void setNeedPage(boolean needPage) {
        this.needPage = needPage;
    }
}
