package com.pluralsight.ui;

import com.pluralsight.model.*;
import com.pluralsight.service.ReceiptWriter;
import com.pluralsight.util.SelectionHelper;

import java.util.Scanner;

public class UserInterface {
    Drink drink;
    Chips chips;
    Scanner sc = new Scanner(System.in);
    boolean exit = false;
    public void display() {
        while (!exit) {
        System.out.println("1 - New Order  0 - Exit");
        int choice = sc.nextInt();
            if (choice == 1) {
                Order order = new Order();
                boolean run = true;
                while (run) {
                    System.out.println("---- Order ----\n1-Add Sandwich\n2-Add Drink\n3-Add Chips\n4-Checkout\n0-Cancel Order");
                    int pick = sc.nextInt();
                    switch (pick){
                        case 1 -> {
                        Sandwich sandwich = processGetSandwich();
                        order.addSandwich(sandwich);
                        }

                     case 2 -> {
                        Drink drink = processGetDrink();
                        order.addDrink(drink);
                    }
                    case 3 -> {
                        Chips chips = processGetChips();
                        order.addChips(chips);
                    }
                    case 4 -> {
                        System.out.println("Final Order:\n" + order);
                        System.out.print("1-Confirm  2-Cancel :");
                        int confirmOfCancel = sc.nextInt(); sc.nextLine();
                        switch (confirmOfCancel){
                            case 1 -> {
                                ReceiptWriter.saveOrder(order);
                                run = false;
                                exit = true;
                                System.out.println("Successfully Checked out!");
                            }
                            case 2 -> {
                                System.out.println("Order was cancelled.");
                                run = false;
                                exit = true;
                            }
                            default -> {
                                ReceiptWriter.saveOrder(order);
                                run = false;
                                exit = true;
                            }
                        }
                    }
                    case 0 -> {
                        System.out.println("Order canceled");
                        run = false;
                        exit = true;
                    }
                    default -> System.out.println("Invalid choice, try again");
                    }
                }
            } else if (choice == 0) {
                System.out.println("Closing ...");
                System.exit(0);
            } else {
                System.out.println("Wrong choice!");
            }
        }
    }

    public Sandwich processGetSandwich(){
        System.out.print("Which type of bread would you like: 1-White  2-Wheat  3-Rye  4-Wrap\n:");
        int breadType = sc.nextInt(); sc.nextLine();
        String breadName = SelectionHelper.getBreadName(breadType);
        Bread bread = new Bread(breadType);

        System.out.print("Pick sandwich size (4, 8, 12 inch): ");
        int size = sc.nextInt(); sc.nextLine();
        Sandwich sandwich = new Sandwich(size, bread);

        System.out.println("Would you like Toasted? 1-Yes  2-No");
        int toasted = sc.nextInt();
        sandwich.setToasted(SelectionHelper.yesNo(toasted));

        System.out.print("Choose meat (0-None, 1-Steak, 2-Ham, 3-Salami, 4-Roast Beef, 5-Chicken, 6-Bacon): ");
        int meatType = sc.nextInt(); sc.nextLine();
        if (meatType != 0) {
            String meatName = SelectionHelper.getMeatsdName(meatType);
            System.out.print("Extra meat? 1-Yes  2-No: ");
            int extra = sc.nextInt(); sc.nextLine();
            sandwich.addMeat(new Meat(meatType, SelectionHelper.yesNo(extra)));
            System.out.println("Added Meat: " + meatName + (SelectionHelper.yesNo(extra) ? " (extra)" : ""));
        }

        System.out.print("Choose cheese (0-None, 1-American, 2-Provolone, 3-Cheddar, 4-Swiss): ");
        int cheeseType = sc.nextInt(); sc.nextLine();
        if (cheeseType != 0) {
            String cheeseName = SelectionHelper.getCheeseName(cheeseType);
            System.out.print("Extra cheese? 1-Yes  2-No: ");
            int extra = sc.nextInt(); sc.nextLine();
            sandwich.addCheese(new Cheese(cheeseType, SelectionHelper.yesNo(extra)));
            System.out.println("Added Cheese: " + cheeseName + (SelectionHelper.yesNo(extra) ? " (extra)" : ""));
        }

        System.out.print("Choose topping (0-None, 1-Lettuce, 2-Peppers, 3-Onions, 4-Tomatoes, 5-Jalapenos, 6-Cucumbers, 7-Pickles, 9-Guacamole, 10-Mushrooms): ");
        int toppingType = sc.nextInt(); sc.nextLine();
        if (toppingType != 0) {
            String toppingName = SelectionHelper.getRegularToppongsName(toppingType);
            sandwich.addTopping(new Topping(toppingType));
            System.out.println("Added Topping: " + toppingName);
        }

        System.out.print("Choose sauce (0-None, 1-Mayo, 2-Mustard, 3-Ketchup, 4-Ranch, 5-Thousand Islands, 6-Vinaigrette): ");
        int sauceType = sc.nextInt(); sc.nextLine();
        if (sauceType != 0) {
            String sauceName = SelectionHelper.getSauceName(sauceType);
            sandwich.addSauce(new Sauce(sauceType));
            System.out.println("Added Sauce: " + sauceName);
        }
        return sandwich;
    }

    private Drink processGetDrink() {
        System.out.print("Pick drink size: 1-Small, 2-Medium, 3-Large: ");
        int size = sc.nextInt(); sc.nextLine();
        Drink drink = new Drink(size);
        String drinkName = SelectionHelper.getDrinkName(size);
        System.out.println("Added Drink: " + drinkName + " — $" + String.format("%.2f", drink.getPrice(size)));
        return drink;
    }

    private Chips processGetChips() {
        System.out.print("Pick chips: 1-Lays, 2-Pringles, 3-Doritos, 4-Cheetos, 5-Ruffles, 6-Tostitos: ");
        int type = sc.nextInt(); sc.nextLine();
        Chips chips = new Chips(type);
        System.out.println("Added Chips: " + chips.getName() + " — $" + String.format("%.2f", chips.getPrice(type)));
        return chips;
    }
}
