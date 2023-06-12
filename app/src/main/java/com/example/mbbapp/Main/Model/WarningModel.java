package com.example.mbbapp.Main.Model;

public class WarningModel {
    private int id;
    private String warningName;
    private String warningCode;
    private int warningLevel;
    private String description;
    private String reason;
    private String startTime;
    private String endTime;
    private double startLatitude;
    private double startLongitude;
    private double endLatitude;
    private double endLongitude;
    private int scheduleId;
    private String scheduleName;
    private String sampleCode;
    private String sampleName;
    private String sampleDetail;
    private int unitId;
    private String unitName;
    private int carId;
    private String licensePlate;
    private Integer driverId;
    private String driverName;
    private Integer ownerId;
    private String ownerName;
    private Integer escortId;
    private String escortName;
    private String ktvAtmName;
    private String securityName;

    public WarningModel() {
    }

    public WarningModel(int id, String warningName, String warningCode, int warningLevel, String description, String reason, String startTime, String endTime, double startLatitude, double startLongitude, double endLatitude, double endLongitude, int scheduleId, String scheduleName, String sampleCode, String sampleName, String sampleDetail, int unitId, String unitName, int carId, String licensePlate, Integer driverId, String driverName, Integer ownerId, String ownerName, Integer escortId, String escortName, String ktvAtmName, String securityName) {
        this.id = id;
        this.warningName = warningName;
        this.warningCode = warningCode;
        this.warningLevel = warningLevel;
        this.description = description;
        this.reason = reason;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.endLatitude = endLatitude;
        this.endLongitude = endLongitude;
        this.scheduleId = scheduleId;
        this.scheduleName = scheduleName;
        this.sampleCode = sampleCode;
        this.sampleName = sampleName;
        this.sampleDetail = sampleDetail;
        this.unitId = unitId;
        this.unitName = unitName;
        this.carId = carId;
        this.licensePlate = licensePlate;
        this.driverId = driverId;
        this.driverName = driverName;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.escortId = escortId;
        this.escortName = escortName;
        this.ktvAtmName = ktvAtmName;
        this.securityName = securityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWarningName() {
        return warningName;
    }

    public void setWarningName(String warningName) {
        this.warningName = warningName;
    }

    public String getWarningCode() {
        return warningCode;
    }

    public void setWarningCode(String warningCode) {
        this.warningCode = warningCode;
    }

    public int getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(int warningLevel) {
        this.warningLevel = warningLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getSampleCode() {
        return sampleCode;
    }

    public void setSampleCode(String sampleCode) {
        this.sampleCode = sampleCode;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getSampleDetail() {
        return sampleDetail;
    }

    public void setSampleDetail(String sampleDetail) {
        this.sampleDetail = sampleDetail;
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

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getEscortId() {
        return escortId;
    }

    public void setEscortId(Integer escortId) {
        this.escortId = escortId;
    }

    public String getEscortName() {
        return escortName;
    }

    public void setEscortName(String escortName) {
        this.escortName = escortName;
    }

    public String getKtvAtmName() {
        return ktvAtmName;
    }

    public void setKtvAtmName(String ktvAtmName) {
        this.ktvAtmName = ktvAtmName;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }
}
