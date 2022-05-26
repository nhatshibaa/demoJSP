package com.example.demojsp.entity.enums;

public enum CategoryStatus {
    DEACTIVE(0), ACTIVE(1), DELETED(-1), UNDEFINE(-2);

    private int value;
    CategoryStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static CategoryStatus of(int value){
        for (CategoryStatus status:
             CategoryStatus.values()) {
            if (status.getValue() == value){
                return status;
            }
        }
        return null;
    }
}
