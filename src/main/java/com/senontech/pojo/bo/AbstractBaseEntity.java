package com.senontech.pojo.bo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @description: 实体类基类
 * @author: gyk
 * @date: 2020/9/25 9:54
 */
public class AbstractBaseEntity implements Serializable {

    /**
     * 删除标记
     */
    private Boolean deleteFlag;

    /**
     * 创建人员id
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    @JSONField(serialize = false,format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新人员id
     */
    @JSONField(serialize = false)
    private Long updateUserId;

    /**
     * 更新时间
     */
    @JSONField(serialize = false,format = "yyyy-MM-dd HH:mm:ss")
    private Date timestamp;

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return Objects.equals(deleteFlag, that.deleteFlag) &&
                Objects.equals(createUserId, that.createUserId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateUserId, that.updateUserId) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deleteFlag, createUserId, createTime, updateUserId, timestamp);
    }

    @Override
    public String toString() {
        return "AbstractBaseEntity{" +
                "deleteFlag=" + deleteFlag +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                ", updateUserId=" + updateUserId +
                ", timestamp=" + timestamp +
                '}';
    }
}
