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
}
