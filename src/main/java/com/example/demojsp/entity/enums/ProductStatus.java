package com.example.demojsp.entity.enums;

public enum ProductStatus {
    DEACTIVE(0), ACTIVE(1), DELETED(-1), UNDEFINE(-2);

    private int value;
    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static ProductStatus of(int value){
        for (ProductStatus status:
                ProductStatus.values()) {
            if (status.getValue() == value){
                return status;
            }
        }
        return null;
    }
}
