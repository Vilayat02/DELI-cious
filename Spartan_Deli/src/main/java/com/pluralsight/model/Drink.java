package com.pluralsight.model;

import com.pluralsight.service.PricingService;

public class Drink  extends Item{

    public Drink(int type) {
        super(type, false);
    }

    @Override
    public double getPrice(int size) {
        return PricingService.drinkBasePrice(size);
    }

    @Override
    public double getExtraPrice(int size) {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Drink(size=%d, price=%.2f)", getType(), getPrice(getType()));
    }

    public String getName() {
        return switch (getType()) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "None";
        };
    }
}
