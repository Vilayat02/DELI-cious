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
        return String.format("Sauce(type=%d)", getType());
    }

    public String getName() {
        return switch (getType()) {
            case 1 -> "Mayo";
            case 2 -> "Mustard";
            case 3 -> "Ketchup";
            case 4 -> "Ranch";
            case 5 -> "Thousand Islands";
            case 6 -> "Vinaigrette";
            default -> "None";
        };
    }
}
