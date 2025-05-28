package com.pluralsight.service;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {


    public static void saveOrder(Order order) {
        String time = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String filename = "src/main/resources/ " + time + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("=== RECEIPT === \n");
                    writer.write("Time: " + time + "\n");

            for (Sandwich s : order.getSandwiches()) {
                writer.write(s.toString() + " ");
            }
            for (Drink d : order.getDrinks()) {
                writer.write(d.toString() + " ");
            }
            for (Chips c : order.getChipsList()) {
                writer.write(c.getName() + " — $" + String.format("%.2f", c.getPrice(c.getType())) + " ");
            }

            writer.write("TOTAL: $" + String.format("%.2f", order.getTotalPrice()) + " ");
            writer.flush();
        } catch (IOException e) {
            System.err.println("Failed to save receipt: " + e.getMessage());
        }
    }
}
