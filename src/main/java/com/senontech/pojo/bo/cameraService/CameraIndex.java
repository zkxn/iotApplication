package com.senontech.pojo.bo.cameraService;

import com.senontech.pojo.bo.AbstractBaseEntity;

import java.io.Serializable;
import java.util.List;


/**
 * @description: 摄像头预设点表实体类
 * @author: gyk
 * @date: 2020-11-17 13:13:36
 */

public class CameraIndex extends AbstractBaseEntity implements Serializable {

    private Integer cameraIndexId;

    private Integer cameraId;

    private Integer cameraIndex;

    private String indexName;

    private List<Integer> cameraIndexIdList;

    public List<Integer> getCameraIndexIdList() {
        return cameraIndexIdList;
    }

    public void setCameraIndexIdList(List<Integer> cameraIndexIdList) {
        this.cameraIndexIdList = cameraIndexIdList;
    }

    public Integer getCameraIndexId() {
        return cameraIndexId;
    }

    public void setCameraIndexId(Integer cameraIndexId) {
        this.cameraIndexId = cameraIndexId;
    }

    public Integer getCameraId() {
        return cameraId;
    }

    public void setCameraId(Integer cameraId) {
        this.cameraId = cameraId;
    }

    public Integer getCameraIndex() {
        return cameraIndex;
    }

    public void setCameraIndex(Integer cameraIndex) {
        this.cameraIndex = cameraIndex;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
}