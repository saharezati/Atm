package com.sahar.atmspring.entity.enums;

public enum AccountType {
    JARI(1),
    SEPORDE(2),
    GHARZOL_HASANE(3);
    private Integer value;

    AccountType(Integer value) {
        this.value = value;
    }
}
