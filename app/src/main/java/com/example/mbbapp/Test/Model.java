package com.example.mbbapp.Test;

public class Model {

    private int unitId;
    private int userId;
    private String unitName;
    private String userName;

    public Model() {
    }

    public Model(int unitId, int userId, String unitName, String userName) {
        this.unitId = unitId;
        this.userId = userId;
        this.unitName = unitName;
        this.userName = userName;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
