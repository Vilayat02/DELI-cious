package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    //TODO Dont forget create input count of items and miltiply it input times to our methods
    //TODO We have to connect and add each element of our order to List or ArrayList and for each order create new file with date

    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chipsList = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chips) {
        chipsList.add(chips);
    }

    /**
     * Calculate full price for all positions
     */
    public double getTotalPrice() {
        double total = 0.0;
        for (Sandwich s : sandwiches) {
            total += s.getTotalPrice();
        }
        for (Drink d : drinks) {
            total += d.getPrice(d.getType());
        }
        for (Chips c : chipsList) {
            total += c.getPrice(c.getType());
        }
        return total;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChipsList() {
        return chipsList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sandwich s : sandwiches) {
            sb.append(s).append("\n");
        }
        for (Drink d : drinks) {
            sb.append(d).append("\n");
        }
        for (Chips c : chipsList) {
            // выводим название и цену чипсов
            sb.append(c.getName())
                    .append(" — $")
                    .append(String.format("%.2f", c.getPrice(c.getType())))
                    .append("\n");
        }
        sb.append(String.format("Order Total: $%.2f", getTotalPrice()));
        return sb.toString();
    }
}
