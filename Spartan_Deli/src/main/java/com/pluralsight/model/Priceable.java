package com.pluralsight.model;

public interface Priceable {
    double getPrice(int size);
    double getExtraPrice(int size);
}
