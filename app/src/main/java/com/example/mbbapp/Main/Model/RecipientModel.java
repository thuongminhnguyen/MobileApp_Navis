package com.example.mbbapp.Main.Model;

public class RecipientModel {
    private int id;
    private String staffCode;
    private String name;
    private String phone;
    private String email;
    private String position;
    private String unitId;
    private String isActive;
    private String avatar;
    private String sexStr;
    private boolean status;
    private String unitName;
    private boolean expandble;

    public RecipientModel() {
    }

    public RecipientModel(int id, String staffCode, String name, String phone, String email, String position, String unitId, String isActive, String avatar, String sexStr, boolean status, String unitName) {
        this.id = id;
        this.staffCode = staffCode;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.unitId = unitId;
        this.isActive = isActive;
        this.avatar = avatar;
        this.sexStr = sexStr;
        this.status = status;
        this.unitName = unitName;
    }

    public RecipientModel(String staffCode, String name, String phone, String email, String position, String avatar, boolean status, String unitName) {
        this.staffCode = staffCode;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.avatar = avatar;
        this.status = status;
        this.unitName = unitName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public boolean isExpandble() {

        return expandble;
    }


    public void setExpandble(boolean expandble) {
        this.expandble = expandble;
    }
}
