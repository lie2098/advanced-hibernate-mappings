package com.lye.hibernate.demo.entity;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum StatusEnum {
    ACTIVE(1),
    INACTIVE(0);

    private final int value;

    StatusEnum(int value) {
        this.value = value;
    }

    public static StatusEnum fromValue(int value) {
        return Arrays.stream(values())
                .filter(val -> val.getValue() == value)
                .findFirst()
                .orElse(null);
    }
}
