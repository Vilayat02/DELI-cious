package com.pluralsight.model;

public class Side extends Item{

    public Side(int type, boolean extra) {
        super(type, extra);
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
        return String.format("Side(type=%d)", getType());
    }

    public String getName() {
        return switch (getType()) {
            case 1 -> "Au Jus";
            case 2 -> "Sauce";
            default -> "None";
        };
    }
}
