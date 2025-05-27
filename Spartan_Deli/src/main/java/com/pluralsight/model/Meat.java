package com.pluralsight.model;

import com.pluralsight.service.PricingService;

public class Meat extends Item {

    public Meat(int type, boolean extra) {
        super(type, extra);
    }

    @Override
    public double getPrice(int size) {
        return PricingService.meatBasePrice(size);
    }

    @Override
    public double getExtraPrice(int size) {
        return isExtra() ? PricingService.meatExtraPrice(size) : 0;
    }

    @Override
    public String toString() {
        return String.format("Meat(type = %d, extra = %b)", getType(), isExtra());
    }

    public String getName() {
        return switch (getType()) {
            case 1 -> "Steak";
            case 2 -> "Ham";
            case 3 -> "Salami";
            case 4 -> "Roast Beef";
            case 5 -> "Chicken";
            case 6 -> "Bacon";
            default -> "None";
        };
    }




}

