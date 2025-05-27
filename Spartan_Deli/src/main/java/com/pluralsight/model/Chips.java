package com.pluralsight.model;

import com.pluralsight.service.PricingService;

public class Chips extends Item{

    public Chips(int type) {
        super(type, false);
    }

    @Override
    public double getPrice(int size) {
        return PricingService.chipsBasePrice(type);
    }

    @Override
    public double getExtraPrice(int size) {
        return 0;
    }

    public String getName() {
        return switch (getType()) {
            case 1 -> "Lays";
            case 2 -> "Pringles";
            case 3 -> "Doritos";
            case 4 -> "Cheetos";
            case 5 -> "Ruffles";
            case 6 -> "Tostitos";
            default -> "None";
        };
    }
}
