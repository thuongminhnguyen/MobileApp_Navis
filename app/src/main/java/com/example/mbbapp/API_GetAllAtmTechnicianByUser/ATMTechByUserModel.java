package com.example.mbbapp.API_GetAllAtmTechnicianByUser;

public class ATMTechByUserModel {
    private String id;
    private String avatar;
    private String employeeCode;
    private String name;
    private String sexStr;
    private String phone;
    private String email;
    private String status;
    private String unitId;
    private String unitName;
    private String rfidId;
    private String cardNumber;


    public ATMTechByUserModel(String id, String avatar, String employeeCode, String name,
                              String sexStr, String phone, String email, String status, String unitId,
                              String unitName, String rfidId, String cardNumber) {
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
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getRfidId() {
        return rfidId;
    }

    public void setRfidId(String rfidId) {
        this.rfidId = rfidId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


}
