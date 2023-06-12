package com.example.mbbapp.API_GetAllDevice;

public class GetAlllDeviceModel {
    private String id;
    private String deviceNumber;
    private String imei;
    private String phone;
    private String carrierId;
    private String carrierName;
    private String activationTime;
    private String unitId;
    private String unitName;
    private boolean isActive;
    private boolean allowUpdate;
    private String licensePlate;


    public GetAlllDeviceModel(String id, String deviceNumber, String imei, String phone, String carrierId, String carrierName, String activationTime, String unitId, String unitName, boolean isActive, boolean allowUpdate, String licensePlate) {
        this.id = id;
        this.deviceNumber = deviceNumber;
        this.imei = imei;
        this.phone = phone;
        this.carrierId = carrierId;
        this.carrierName = carrierName;
        this.activationTime = activationTime;
        this.unitId = unitId;
        this.unitName = unitName;
        this.isActive = isActive;
        this.allowUpdate = allowUpdate;
        this.licensePlate = licensePlate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(String activationTime) {
        this.activationTime = activationTime;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isAllowUpdate() {
        return allowUpdate;
    }

    public void setAllowUpdate(boolean allowUpdate) {
        this.allowUpdate = allowUpdate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
