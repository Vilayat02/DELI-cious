package com.pluralsight.model;

public class Topping extends Item{

    public Topping(int type) {
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
}
