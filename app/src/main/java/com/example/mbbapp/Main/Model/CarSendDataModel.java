package com.example.mbbapp.Main.Model;

public class CarSendDataModel {
    private int carId;
    private String licensePlate;
    private int unitId;
    private String unitName;
    private int carStatus;
    private boolean strongBoxOpen;
    private boolean engineOn;
    private boolean isSos;
    private boolean isGpsLost;
    private double gpsLat;
    private double gpsLon;
    private String deviceTime;
    private Integer firstCamPo;
    private Integer firstCamRotation;
    private Integer secondCamRotation;
    private int gpsVelocity;
    private int cellId;
    private int lacId;
    private String rfidString;
    private String appVersion;
    private String smallIconState;
    private String bigIconState;
    private String stateName;
    private String carType;
    private int userId;

    public CarSendDataModel() {
    }

    public CarSendDataModel(int carId, String licensePlate, int unitId, String unitName, int carStatus, boolean strongBoxOpen, boolean engineOn, boolean isSos, boolean isGpsLost, double gpsLat, double gpsLon, String deviceTime, Integer firstCamPo, Integer firstCamRotation, Integer secondCamRotation, int gpsVelocity, int cellId, int lacId, String rfidString, String appVersion, String smallIconState, String bigIconState, String stateName, String carType, int userId) {
        this.carId = carId;
        this.licensePlate = licensePlate;
        this.unitId = unitId;
        this.unitName = unitName;
        this.carStatus = carStatus;
        this.strongBoxOpen = strongBoxOpen;
        this.engineOn = engineOn;
        this.isSos = isSos;
        this.isGpsLost = isGpsLost;
        this.gpsLat = gpsLat;
        this.gpsLon = gpsLon;
        this.deviceTime = deviceTime;
        this.firstCamPo = firstCamPo;
        this.firstCamRotation = firstCamRotation;
        this.secondCamRotation = secondCamRotation;
        this.gpsVelocity = gpsVelocity;
        this.cellId = cellId;
        this.lacId = lacId;
        this.rfidString = rfidString;
        this.appVersion = appVersion;
        this.smallIconState = smallIconState;
        this.bigIconState = bigIconState;
        this.stateName = stateName;
        this.carType = carType;
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(int carStatus) {
        this.carStatus = carStatus;
    }

    public boolean isStrongBoxOpen() {
        return strongBoxOpen;
    }

    public void setStrongBoxOpen(boolean strongBoxOpen) {
        this.strongBoxOpen = strongBoxOpen;
    }

    public boolean isEngineOn() {
        return engineOn;
    }

    public void setEngineOn(boolean engineOn) {
        this.engineOn = engineOn;
    }

    public boolean isSos() {
        return isSos;
    }

    public void setSos(boolean sos) {
        isSos = sos;
    }

    public boolean isGpsLost() {
        return isGpsLost;
    }

    public void setGpsLost(boolean gpsLost) {
        isGpsLost = gpsLost;
    }

    public double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(double gpsLat) {
        this.gpsLat = gpsLat;
    }

    public double getGpsLon() {
        return gpsLon;
    }

    public void setGpsLon(double gpsLon) {
        this.gpsLon = gpsLon;
    }

    public String getDeviceTime() {
        return deviceTime;
    }

    public void setDeviceTime(String deviceTime) {
        this.deviceTime = deviceTime;
    }

    public Integer getFirstCamPo() {
        return firstCamPo;
    }

    public void setFirstCamPo(Integer firstCamPo) {
        this.firstCamPo = firstCamPo;
    }

    public Integer getFirstCamRotation() {
        return firstCamRotation;
    }

    public void setFirstCamRotation(Integer firstCamRotation) {
        this.firstCamRotation = firstCamRotation;
    }

    public Integer getSecondCamRotation() {
        return secondCamRotation;
    }

    public void setSecondCamRotation(Integer secondCamRotation) {
        this.secondCamRotation = secondCamRotation;
    }

    public int getGpsVelocity() {
        return gpsVelocity;
    }

    public void setGpsVelocity(int gpsVelocity) {
        this.gpsVelocity = gpsVelocity;
    }

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public int getLacId() {
        return lacId;
    }

    public void setLacId(int lacId) {
        this.lacId = lacId;
    }

    public String getRfidString() {
        return rfidString;
    }

    public void setRfidString(String rfidString) {
        this.rfidString = rfidString;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getSmallIconState() {
        return smallIconState;
    }

    public void setSmallIconState(String smallIconState) {
        this.smallIconState = smallIconState;
    }

    public String getBigIconState() {
        return bigIconState;
    }

    public void setBigIconState(String bigIconState) {
        this.bigIconState = bigIconState;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
