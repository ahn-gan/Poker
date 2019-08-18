package com.oocl.poker;

public class Poker {
    private Integer value;

    private Character category;

    public Poker(Integer value, Character category) {
        this.value = value;
        this.category = category;
    }

    public Integer getValue() {
        return value;
    }

    public Character getCategory() {
        return category;
    }
}
