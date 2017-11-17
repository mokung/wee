package me.wenkang.wee.components.constant.page;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author wenkang
 * @since 2017/11/16
 *
 * @param <T>
 */
public class Page<T> extends Pager {

    private static final long serialVersionUID = 416180493351359932L;

    private List<T> data = Collections.emptyList();

    public boolean isNotEmpty() {
        return null != this.data && this.data.size() > 0;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Page(Pager pager) {
        this.setCurPage(pager.getCurPage());
        this.setPageSize(pager.getPageSize());
        this.setOrderBy(pager.getOrderBy());
    }
    public Page() {
    }
}
