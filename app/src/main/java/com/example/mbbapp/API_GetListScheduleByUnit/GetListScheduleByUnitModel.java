package com.example.mbbapp.API_GetListScheduleByUnit;

public class GetListScheduleByUnitModel {
    private int id;
    private int sampleId;
    private String sampleCode;
    private String scheduleName;
    private String lstPoint;
    private String lstTimeLabel;
    private int sampleType;
    private int unitId;
    private String unitName;
    private int carId;
    private String carPlateNumber;
    private String securityName;
    private int driverId;
    private String driverName;
    private int ownerId;
    private String ownerName;
    private int escortId;
    private String escortName;
    private int atmTechnicanId;
    private String ktvAtmName;
    private String unlimitedTime;
    private String assignedDate;
    private String startTime;
    private String endTime;
    private String runningDate;

    public GetListScheduleByUnitModel(int id, int sampleId, String sampleCode, String scheduleName, String lstPoint, String lstTimeLabel, int sampleType, int unitId, String unitName, int carId, String carPlateNumber, String securityName, int driverId, String driverName, int ownerId, String ownerName, int escortId, String escortName, int atmTechnicanId, String ktvAtmName, String unlimitedTime, String assignedDate, String startTime, String endTime, String runningDate) {
        this.id = id;
        this.sampleId = sampleId;
        this.sampleCode = sampleCode;
        this.scheduleName = scheduleName;
        this.lstPoint = lstPoint;
        this.lstTimeLabel = lstTimeLabel;
        this.sampleType = sampleType;
        this.unitId = unitId;
        this.unitName = unitName;
        this.carId = carId;
        this.carPlateNumber = carPlateNumber;
        this.securityName = securityName;
        this.driverId = driverId;
        this.driverName = driverName;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.escortId = escortId;
        this.escortName = escortName;
        this.atmTechnicanId = atmTechnicanId;
        this.ktvAtmName = ktvAtmName;
        this.unlimitedTime = unlimitedTime;
        this.assignedDate = assignedDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.runningDate = runningDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSampleId() {
        return sampleId;
    }

    public void setSampleId(int sampleId) {
        this.sampleId = sampleId;
    }

    public String getSampleCode() {
        return sampleCode;
    }

    public void setSampleCode(String sampleCode) {
        this.sampleCode = sampleCode;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getLstPoint() {
        return lstPoint;
    }

    public void setLstPoint(String lstPoint) {
        this.lstPoint = lstPoint;
    }

    public String getLstTimeLabel() {
        return lstTimeLabel;
    }

    public void setLstTimeLabel(String lstTimeLabel) {
        this.lstTimeLabel = lstTimeLabel;
    }

    public int getSampleType() {
        return sampleType;
    }

    public void setSampleType(int sampleType) {
        this.sampleType = sampleType;
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

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getEscortId() {
        return escortId;
    }

    public void setEscortId(int escortId) {
        this.escortId = escortId;
    }

    public String getEscortName() {
        return escortName;
    }

    public void setEscortName(String escortName) {
        this.escortName = escortName;
    }

    public int getAtmTechnicanId() {
        return atmTechnicanId;
    }

    public void setAtmTechnicanId(int atmTechnicanId) {
        this.atmTechnicanId = atmTechnicanId;
    }

    public String getKtvAtmName() {
        return ktvAtmName;
    }

    public void setKtvAtmName(String ktvAtmName) {
        this.ktvAtmName = ktvAtmName;
    }

    public String getUnlimitedTime() {
        return unlimitedTime;
    }

    public void setUnlimitedTime(String unlimitedTime) {
        this.unlimitedTime = unlimitedTime;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
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

    public String getRunningDate() {
        return runningDate;
    }

    public void setRunningDate(String runningDate) {
        this.runningDate = runningDate;
    }
}
