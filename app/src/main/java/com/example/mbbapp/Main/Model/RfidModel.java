package com.example.mbbapp.Main.Model;

public class RfidModel {

    private int id;
    private String cardNumber;
    private String description;
    private String activationTime;
    private int type;
    private boolean isDistributed;
    private boolean status;
    private int unitId;
    private String unitName;

    public RfidModel(int id, String cardNumber, String description, String activationTime, int type, boolean isDistributed, boolean status, int unitId, String unitName) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.description = description;
        this.activationTime = activationTime;
        this.type = type;
        this.isDistributed = isDistributed;
        this.status = status;
        this.unitId = unitId;
        this.unitName = unitName;
    }

    public int getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getActivationTime() {
        return activationTime;
    }

    public int getType() {
        return type;
    }

    public boolean isDistributed() {
        return isDistributed;
    }

    public boolean getStatus() {
        return status;
    }

    public int getUnitId() {
        return unitId;
    }

    public String getUnitName() {
        return unitName;
    }
}
