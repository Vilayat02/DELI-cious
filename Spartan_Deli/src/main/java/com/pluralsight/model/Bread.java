package com.pluralsight.model;

import com.pluralsight.service.PricingService;

public class Bread extends Item{

    public Bread(int type) {
        super(type,false);
    }

    public int getType() {
        return type;
    }

    @Override
    public double getPrice(int size) {
        return 0;
    }

    //TODO don't use this method we don't have extra bread option
    @Override
    public double getExtraPrice(int size) {
        return 0;
    }
}
