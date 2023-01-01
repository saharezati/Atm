package com.sahar.atmspring.entity.enums;

import com.sun.jdi.IntegerValue;

public enum TransactionType {
    DEPOSIT(1),WITHDRAW(2);
    private Integer value;

    TransactionType(Integer value) {
        this.value = value;
    }
}
