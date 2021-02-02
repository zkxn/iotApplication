package com.senontech.pojo.bo.cameraService;

import com.senontech.pojo.bo.AbstractBaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


/**
 * @description: 摄像头实体类
 * @author: gyk
 * @date: 2020-11-17 12:59:42
 */
public class Camera extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 292049857165410682L;

    private Integer cameraId;

    private String cameraName;

    private Integer channelNo;

    private String companyMark;

    private String deviceSerial;

    private Boolean screenshot;

    private Boolean controlFlag;

    private String brand;

    private String verificationCode;

    private List<Integer> cameraIdList;

    private String accessToken;

    private Integer direction;

    private Integer speed;

    private Integer command;

    private Integer index;

    private List<Integer> cameraIndexBatch;

    private String indexName;

    private Integer pageStart;

    private Integer pageSize;

    private String appKey = "b1b2cacf35464c198803b5e4429d0179";

    private String model;

    private String version;

    private String deviceName;

    private Object cameraInfo;

    private Object device;

    private Object deviceStatus;

    private Object channelNoInfo;

    private Object versionInfo;

    private Object supportEzviz;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public List<Integer> getCameraIndexBatch() {
        return cameraIndexBatch;
    }

    public void setCameraIndexBatch(List<Integer> cameraIndexBatch) {
        this.cameraIndexBatch = cameraIndexBatch;
    }

    public Object getSupportEzviz() {
        return supportEzviz;
    }

    public void setSupportEzviz(Object supportEzviz) {
        this.supportEzviz = supportEzviz;
    }

    public Object getVersionInfo() {
        return versionInfo;
    }

    public void setVersionInfo(Object versionInfo) {
        this.versionInfo = versionInfo;
    }

    public Object getChannelNoInfo() {
        return channelNoInfo;
    }

    public void setChannelNoInfo(Object channelNoInfo) {
        this.channelNoInfo = channelNoInfo;
    }

    public Object getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Object deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public List<Integer> getCameraIdList() {
        return cameraIdList;
    }

    public void setCameraIdList(List<Integer> cameraIdList) {
        this.cameraIdList = cameraIdList;
    }

    public Integer getCameraId() {
        return cameraId;
    }

    public void setCameraId(Integer cameraId) {
        this.cameraId = cameraId;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    public String getCompanyMark() {
        return companyMark;
    }

    public void setCompanyMark(String companyMark) {
        this.companyMark = companyMark;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public Boolean getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(Boolean screenshot) {
        this.screenshot = screenshot;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getCommand() {
        return command;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getControlFlag() {
        return controlFlag;
    }

    public void setControlFlag(Boolean controlFlag) {
        this.controlFlag = controlFlag;
    }

    public Object getCameraInfo() {
        return cameraInfo;
    }

    public void setCameraInfo(Object cameraInfo) {
        this.cameraInfo = cameraInfo;
    }

    public Object getDevice() {
        return device;
    }

    public void setDevice(Object device) {
        this.device = device;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Camera camera = (Camera) o;
        return Objects.equals(cameraId, camera.cameraId) &&
                Objects.equals(cameraName, camera.cameraName) &&
                Objects.equals(channelNo, camera.channelNo) &&
                Objects.equals(companyMark, camera.companyMark) &&
                Objects.equals(deviceSerial, camera.deviceSerial) &&
                Objects.equals(screenshot, camera.screenshot) &&
                Objects.equals(controlFlag, camera.controlFlag) &&
                Objects.equals(brand, camera.brand) &&
                Objects.equals(verificationCode, camera.verificationCode) &&
                Objects.equals(cameraIdList, camera.cameraIdList) &&
                Objects.equals(accessToken, camera.accessToken) &&
                Objects.equals(direction, camera.direction) &&
                Objects.equals(speed, camera.speed) &&
                Objects.equals(command, camera.command) &&
                Objects.equals(index, camera.index) &&
                Objects.equals(cameraIndexBatch, camera.cameraIndexBatch) &&
                Objects.equals(indexName, camera.indexName) &&
                Objects.equals(pageStart, camera.pageStart) &&
                Objects.equals(pageSize, camera.pageSize) &&
                Objects.equals(appKey, camera.appKey) &&
                Objects.equals(model, camera.model) &&
                Objects.equals(version, camera.version) &&
                Objects.equals(deviceName, camera.deviceName) &&
                Objects.equals(cameraInfo, camera.cameraInfo) &&
                Objects.equals(device, camera.device) &&
                Objects.equals(deviceStatus, camera.deviceStatus) &&
                Objects.equals(channelNoInfo, camera.channelNoInfo) &&
                Objects.equals(versionInfo, camera.versionInfo) &&
                Objects.equals(supportEzviz, camera.supportEzviz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cameraId, cameraName, channelNo, companyMark, deviceSerial, screenshot,
                controlFlag, brand, verificationCode, cameraIdList, accessToken, direction, speed, command, index,
                cameraIndexBatch, indexName, pageStart, pageSize, appKey, model, version, deviceName, cameraInfo, device,
                deviceStatus, channelNoInfo, versionInfo, supportEzviz);
    }

    @Override
    public String toString() {
        return "Camera{" +
                "cameraId=" + cameraId +
                ", cameraName='" + cameraName + '\'' +
                ", channelNo=" + channelNo +
                ", companyMark='" + companyMark + '\'' +
                ", deviceSerial='" + deviceSerial + '\'' +
                ", screenshot=" + screenshot +
                ", controlFlag=" + controlFlag +
                ", brand='" + brand + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                ", cameraIdList=" + cameraIdList +
                ", accessToken='" + accessToken + '\'' +
                ", direction=" + direction +
                ", speed=" + speed +
                ", command=" + command +
                ", index=" + index +
                ", cameraIndexBatch=" + cameraIndexBatch +
                ", indexName='" + indexName + '\'' +
                ", pageStart=" + pageStart +
                ", pageSize=" + pageSize +
                ", appKey='" + appKey + '\'' +
                ", model='" + model + '\'' +
                ", version='" + version + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", cameraInfo=" + cameraInfo +
                ", device=" + device +
                ", deviceStatus=" + deviceStatus +
                ", channelNoInfo=" + channelNoInfo +
                ", versionInfo=" + versionInfo +
                ", supportEzviz=" + supportEzviz +
                '}';
    }
}