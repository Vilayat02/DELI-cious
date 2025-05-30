package com.pluralsight.service;

import com.pluralsight.model.Sandwich;

public class PricingService {

    //TODO 6% State Taxes
    public static double taxPrice(double total){
        return (total * 0.06) + total;
    }

    public static double basePrice(int sizeInInches) {
        return switch (sizeInInches) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };
    }

    public static double meatBasePrice(int size) {
        return switch (size) {
            case 4 -> 1.0;
            case 8 -> 2.0;
            case 12 -> 3.0;
            default -> 0.0;
        };
    }

    public static double meatExtraPrice(int size) {
        return switch (size) {
            case 4  -> 0.5;
            case 8  -> 1.0;
            case 12 -> 1.5;
            default -> 0.0;
        };
    }

    public static double cheeseBasePrice(int size) {
        return switch (size) {
            case 4  -> 0.75;
            case 8  -> 1.50;
            case 12 -> 2.25;
            default -> 0.0;
        };
    }
    public static double cheeseExtraPrice(int size) {
        return switch (size) {
            case 4  -> 0.30;
            case 8  -> 0.60;
            case 12 -> 0.90;
            default -> 0.0;
        };
    }

    public static double drinkBasePrice(int size) {
        return switch (size) {
            case 1 -> 2;
            case 2 -> 2.50;
            case 3 -> 3;
            default -> 0.0;
        };
    }
    //TODO Checking if chips picked make it true
    public static boolean isChipsPicked(int picked){
        return switch (picked){
            case 1,2,3,4,5 -> true;
            default -> false;
        };
    }
    //TODO Returning price dependent if chips picked
    public static double chipsBasePrice(int picked) {
        return (isChipsPicked(picked)) ? 1.50 : 0;
    }

}