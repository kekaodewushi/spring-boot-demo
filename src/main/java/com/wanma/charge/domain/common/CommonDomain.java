package com.wanma.charge.domain.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zangyy
 * @date 2017/5/19
 * 基础domain
 */
public class CommonDomain implements Serializable {
    private Long id;//自增id

    private Integer isDel;//是否删除标识 0否，1是 默认为0

    private Long createId;//创建人id

    private Long modifyId;//修改人id

    private Date createTime;//创建时间

    private Date modifyTime;//修改时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getModifyId() {
        return modifyId;
    }

    public void setModifyId(Long modifyId) {
        this.modifyId = modifyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
