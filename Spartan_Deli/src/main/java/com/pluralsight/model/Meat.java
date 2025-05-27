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

    /* @Override
    public double getPrice(int choose) {
        return (sandwich.getSize() == 1) ? 1: (sandwich.getSize() == 2) ? 2: (sandwich.getSize() == 3) ? 3: 0;
    }

@Override
public double getPriceWithExtra(int choose, boolean extra) {
        double price = 0;
        if (extra) {
            if (sandwich.getSize() == 1) {
                price = getPrice(choose) + 0.50;
            } else if (sandwich.getSize() == 2) {
                price = getPrice(choose) + 1;
            } else if (sandwich.getSize() == 3) {
                price = getPrice(choose) + 1.50;
            } else System.out.println("Wrong size!");
        }

    return price;
}*/


}

