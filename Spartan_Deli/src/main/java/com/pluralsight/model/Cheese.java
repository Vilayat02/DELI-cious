package com.pluralsight.model;

import com.pluralsight.service.PricingService;

public class Cheese extends Item{

    public Cheese(int type, boolean extra) {
        super(type, extra);
    }

    @Override
    public double getPrice(int size) {
        return PricingService.cheeseBasePrice(size);
    }

    @Override
    public double getExtraPrice(int size) {
        return isExtra() ? PricingService.cheeseExtraPrice(size) : 0;
    }

    @Override
    public String toString() {
        return String.format("Cheese(type = %d, extra = %b)", getType(), isExtra());
    }

    public String getName() {
        return switch (getType()) {
            case 1 -> "American";
            case 2 -> "Provolone";
            case 3 -> "Cheddar";
            case 4 -> "Swiss";
            default -> "None";
        };
    }
}
