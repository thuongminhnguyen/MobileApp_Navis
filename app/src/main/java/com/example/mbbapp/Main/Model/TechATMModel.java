package com.example.mbbapp.Main.Model;

public class TechATMModel {
    private int id;
    private String avatar;
    private String employeeCode;
    private String name;
    private String sexStr;
    private String phone;
    private String email;
    private boolean status;
    private int unitId;
    private String unitName;
    private int rfidId;
    private String cardNumber;

    private boolean expandble;

    public TechATMModel(int id, String avatar, String employeeCode, String name, String sexStr, String phone, String email, boolean status, int unitId, String unitName, int rfidId, String cardNumber, boolean expandble) {
        this.id = id;
        this.avatar = avatar;
        this.employeeCode = employeeCode;
        this.name = name;
        this.sexStr = sexStr;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.unitId = unitId;
        this.unitName = unitName;
        this.rfidId = rfidId;
        this.cardNumber = cardNumber;
        this.expandble = expandble;
    }

    public TechATMModel(String avatar, String unitName, String employeeCode, String name, String phone, String email, boolean status, String cardNumber) {
        this.avatar = avatar;
        this.employeeCode = employeeCode;
        this.name = name;
        this.unitName = unitName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public boolean isExpandble() {
        return expandble;
    }


    public void setExpandble(boolean expandble) {
        this.expandble = expandble;
    }
}
