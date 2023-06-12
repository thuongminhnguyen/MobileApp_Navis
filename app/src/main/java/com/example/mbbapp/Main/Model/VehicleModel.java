package com.example.mbbapp.Main.Model;

public class VehicleModel {
    private int id;
    private String licensePlate;
    private int type;
    private int numberCamera;
    private int firstCamPo;
    private int firstCamRotation;
    private int secondCamRotation;
    private int fuel;
    private int unitId;
    private int rfidId;
    private int driverId;
    private int deviceId;
    private String unitName;
    private String driverName;
    private String deviceNumber;
    private String deviceImei;

    public VehicleModel() {
    }

    public VehicleModel(int id, String licensePlate, int type, int numberCamera, int firstCamPo, int firstCamRotation, int secondCamRotation, int fuel, int unitId, int rfidId, int driverId, int deviceId, String unitName, String driverName, String deviceNumber, String deviceImei) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.type = type;
        this.numberCamera = numberCamera;
        this.firstCamPo = firstCamPo;
        this.firstCamRotation = firstCamRotation;
        this.secondCamRotation = secondCamRotation;
        this.fuel = fuel;
        this.unitId = unitId;
        this.rfidId = rfidId;
        this.driverId = driverId;
        this.deviceId = deviceId;
        this.unitName = unitName;
        this.driverName = driverName;
        this.deviceNumber = deviceNumber;
        this.deviceImei = deviceImei;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNumberCamera() {
        return numberCamera;
    }

    public void setNumberCamera(int numberCamera) {
        this.numberCamera = numberCamera;
    }

    public int getFirstCamPo() {
        return firstCamPo;
    }

    public void setFirstCamPo(int firstCamPo) {
        this.firstCamPo = firstCamPo;
    }

    public int getFirstCamRotation() {
        return firstCamRotation;
    }

    public void setFirstCamRotation(int firstCamRotation) {
        this.firstCamRotation = firstCamRotation;
    }

    public int getSecondCamRotation() {
        return secondCamRotation;
    }

    public void setSecondCamRotation(int secondCamRotation) {
        this.secondCamRotation = secondCamRotation;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getRfidId() {
        return rfidId;
    }

    public void setRfidId(int rfidId) {
        this.rfidId = rfidId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getDeviceImei() {
        return deviceImei;
    }

    public void setDeviceImei(String deviceImei) {
        this.deviceImei = deviceImei;
    }
}
