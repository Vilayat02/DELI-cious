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

    @Override
    public String toString() {
        return String.format("Topping(type=%d)", getType());
    }

    public String getName() {
        return switch (getType()) {
            case 1 -> "Lettuce";
            case 2 -> "Peppers";
            case 3 -> "Onions";
            case 4 -> "Tomatoes";
            case 5 -> "Jalapenos";
            case 6 -> "Cucumbers";
            case 7 -> "Pickles";
            case 9 -> "Guacamole";
            case 10 -> "Mushrooms";
            default -> "None";
        };
    }
}
