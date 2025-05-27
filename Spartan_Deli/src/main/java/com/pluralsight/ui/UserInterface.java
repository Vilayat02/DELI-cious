package com.pluralsight.ui;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;

import java.util.Scanner;

public class UserInterface {
    Drink drink;
    Chips chips;
    Scanner sc = new Scanner(System.in);

    public void display() {

        System.out.println("1 - New Order  0 - Exit");
        int choice = sc.nextInt();
        if (choice == 1) {
            boolean run = true;
            while (run) {
                System.out.println("---- Order ----\n1-Add Sandwich\n2-Add Drink\n3-Add Chips\n4-Checkout\n0-Cancel Order");
                int order = sc.nextInt();
                if (order == 1) {


                } else if (order == 2) {
                    processGetDrink();
                } else if (order == 3) {
                    processGetChips();
                } else if (order == 4) {

                } else if (order == 0) {
                    run = false;
                }
                else if (choice == 0) {
                System.exit(0);
                }
            }
        }
    }

    public void processGetDrink(){
        System.out.print("Pick the size: 1-Small  2-Medium  3-Large");
        int size = sc.nextInt();
        sc.nextLine();
        this.drink = new Drink(size);
    }

    public void processGetChips(){
        System.out.println("Pick chips: 1-Lays  2-Pringles  3-Doritos  4-Cheetos  5-Ruffles  6-Tostitos\n:");
        int selected = sc.nextInt();
        sc.nextLine();
        this.chips = new Chips(selected);
    }

    public void processGetSandwich(){
        System.out.print("Which type of bread would you like: 1-White  2-Wheat  3-Rye  4-Wrap\n:");
        int breadType = sc.nextInt();
        sc.nextLine();

    }
}
