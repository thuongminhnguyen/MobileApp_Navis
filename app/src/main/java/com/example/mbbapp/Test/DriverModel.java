package com.example.mbbapp.Test;

public class DriverModel {
    private int id;
    private String name;
    private String employeeCode;
    private String email;
    private int sex;
    private String sexStr;
    private String phone;
    private int rfidId;
    private String cardNumber;
    private int unitId;
    private String unitName;
    private String avatar;
    private boolean isActive;

    public DriverModel() {
    }

    public DriverModel(String name, String phone, String unitName) {
        this.name = name;
        this.phone = phone;
        this.unitName = unitName;
    }

    public DriverModel(int id, String name, String employeeCode, String email, int sex, String sexStr, String phone, int rfidId, String cardNumber, int unitId, String unitName, String avatar, boolean isActive) {
        this.id = id;
        this.name = name;
        this.employeeCode = employeeCode;
        this.email = email;
        this.sex = sex;
        this.sexStr = sexStr;
        this.phone = phone;
        this.rfidId = rfidId;
        this.cardNumber = cardNumber;
        this.unitId = unitId;
        this.unitName = unitName;
        this.avatar = avatar;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRfidId() {
        return rfidId;
    }

    public void setRfidId(int rfidId) {
        this.rfidId = rfidId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
