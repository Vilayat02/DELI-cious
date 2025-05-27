package com.pluralsight.model;

import com.pluralsight.service.PricingService;

public class Sauce extends Item{

    public Sauce(int type) {
        super(type, false);
    }

    @Override
    public double getPrice(int size) {
        return 0;
    }

    @Override
    public double getExtraPrice(int size) {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Topping(type=%d)", getType());
    }
}
