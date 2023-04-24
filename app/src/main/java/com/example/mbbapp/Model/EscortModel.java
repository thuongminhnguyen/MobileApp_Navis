package com.example.mbbapp.Model;

public class EscortModel {
    private int id;
    private String avatar;
    private String employeeCode;
    private String name;
    private String sexStr;
    private String phone;
    private String email;
    private String status;
    private int unitId;
    private int rfidId;
    private String unitName;
    private String cardNumber;
    private boolean expandble;

    public EscortModel(int id, String avatar, String employeeCode, String name, String sexStr, String phone, String email, String status, int unitId, int rfidId, String unitName, String cardNumber) {
        this.id = id;
        this.avatar = avatar;
        this.employeeCode = employeeCode;
        this.name = name;
        this.sexStr = sexStr;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.unitId = unitId;
        this.rfidId = rfidId;
        this.unitName = unitName;
        this.cardNumber = cardNumber;
    }

    public EscortModel() {
    }

    public EscortModel(String avatar, String employeeCode, String name, String phone, String email, String unitName, String cardNumber) {
        this.avatar = avatar;
        this.employeeCode = employeeCode;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.unitName = unitName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
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
