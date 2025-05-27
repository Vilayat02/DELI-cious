package com.pluralsight.model;

public interface Priceable {
    abstract double getPrice(int size);
    double getExtraPrice(int size);
}
