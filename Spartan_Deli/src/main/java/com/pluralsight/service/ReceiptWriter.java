package com.pluralsight.service;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {



    public static void saveOrder(Order order) {
        String time = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String timeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String filename = "src/main/resources/ " + time + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("=== RECEIPT === \n");
                    writer.write("Date: " + date + "   Time: " + timeNow + "\n");

            for (Sandwich s : order.getSandwiches()) {
                writer.write(s.toString() + "\n");
            }
            for (Drink d : order.getDrinks()) {
                writer.write(d.toString() + "\n");
            }
            for (Chips c : order.getChipsList()) {
                writer.write(c.getName() + " — $" + String.format("%.2f", c.getPrice(c.getType())) + "\n");
            }

            writer.write("TOTAL: $" + String.format("%.2f", order.getTotalPrice()) + "\n");
            writer.write("TOTAL with Tax: $" + String.format("%.2f", order.getTotalPriceWithTax()));
            writer.flush();
        } catch (IOException e) {
            System.err.println("Failed to save receipt: " + e.getMessage());
        }
    }
}
