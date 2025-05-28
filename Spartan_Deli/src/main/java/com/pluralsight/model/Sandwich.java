package com.pluralsight.model;

import com.pluralsight.service.PricingService;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private int size;
    private Bread bread;
    private boolean toasted;
    //TODO Other classes in List because customer can add them few times
    private List<Meat> meats = new ArrayList<>();
    private List<Cheese> cheeses = new ArrayList<>();
    private List<Topping> toppings = new ArrayList<>();
    private List<Sauce> sauces = new ArrayList<>();

    public Sandwich(int size, Bread bread) {
        this.size = size;
        this.bread = bread;
    }

    public int getSize() {
        return size;
    }

    public Bread getBread() {
        return bread;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public void addMeat(Meat meat) {
        meats.add(meat);
    }

    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
    }

    public double getTotalPrice() {
        double total = PricingService.basePrice(size);

        for (Meat m : meats) {
            total += m.getPrice(size) + m.getExtraPrice(size);
        }
        for (Cheese c : cheeses) {
            total += c.getPrice(size) + c.getExtraPrice(size);
        }
        //TODO Topping and Sauce are free
        return total;
    }

    public String getDescription() {
        String desc = "---------------------\nSandwich: " + size + "\" on " + bread.getName();
        if (toasted) {
            desc += " (toasted)";
        }
        desc += "\nIngredients:\n";
        if (!meats.isEmpty()) {
            String[] meatNames = meats.stream()
                    .map(m -> m.getName() + (m.isExtra() ? " (extra)" : ""))
                    .toArray(String[]::new);
            desc += "  Meats: " + String.join(", ", meatNames) + "\n";
        }
        if (!cheeses.isEmpty()) {
            String[] cheeseNames = cheeses.stream()
                    .map(c -> c.getName() + (c.isExtra() ? " (extra)" : ""))
                    .toArray(String[]::new);
            desc += "  Cheeses: " + String.join(", ", cheeseNames) + "\n";
        }
        if (!toppings.isEmpty()) {
            String[] toppingNames = toppings.stream()
                    .map(Topping::getName)
                    .toArray(String[]::new);
            desc += "  Toppings: " + String.join(", ", toppingNames) + "\n";
        }
        if (!sauces.isEmpty()) {
            String[] sauceNames = sauces.stream()
                    .map(Sauce::getName)
                    .toArray(String[]::new);
            desc += "  Sauces: " + String.join(", ", sauceNames) + "\n";
        }

        desc += String.format("Sandwich Price: $%.2f", getTotalPrice());
        return desc;
    }

    @Override
    public String toString() {
        return getDescription();
    }

}
