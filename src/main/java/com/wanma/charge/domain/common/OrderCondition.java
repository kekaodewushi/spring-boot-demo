package com.wanma.charge.domain.common;

/**
 * @author zangyy
 * 排序条件
 */
public class OrderCondition {
    private String column;

    private String orderBy;

    OrderCondition(String column, String orderBy) {
        super();
        this.column = column;
        this.orderBy = orderBy;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
