package com.example.streams.generation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class GenerateFoodDeliveryData {
    public static void main(String[] args) throws InterruptedException, IOException {
        File file = new File("food-delivery-data.json");
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);

        while (true) {
            int recordsCount = new Random().nextInt(15);
            for (int i = 0; i <= recordsCount; i++) {
                FoodDeliveryData foodDeliveryData = new FoodDeliveryData();

                // Generate and set Order ID
                foodDeliveryData.setOrderId(UUID.randomUUID().toString());

                // Generate and set Delivery Person details
                foodDeliveryData.setDeliveryPersonId(UUID.randomUUID().toString());
                foodDeliveryData.setDeliveryPersonAge(com.example.streams.generation.RandomDataGenUtility.randomIntBetween(20, 50));
                foodDeliveryData.setPersonRating(RandomDataGenUtility.randomBetween(1, 5));

                // Generate and set Pickup (Restaurant) Coordinates
                Map<String, String> coords = RandomDataGenUtility.randomLonLat(10, 12, 77, 80);
                foodDeliveryData.setRestaurantLatitude(Double.parseDouble(coords.get("W")));
                foodDeliveryData.setRestaurantLongitude(Double.parseDouble(coords.get("J")));

                // Generate and set Delivery Coordinates
                coords = RandomDataGenUtility.randomLonLat(12, 14, 80, 82);
                foodDeliveryData.setDeliveryLatitude(Double.parseDouble(coords.get("W")));
                foodDeliveryData.setDeliveryLongitude(Double.parseDouble(coords.get("J")));

                // Generate and set Order Date and Time
                foodDeliveryData.setOrderDate(RandomDataGenUtility.randomDate(LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)));
                foodDeliveryData.setOrderTime(RandomDataGenUtility.randomTime());

                // Generate and set Delivery Date and Time
                foodDeliveryData.setDeliveryDate(RandomDataGenUtility.randomDate(LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)));
                foodDeliveryData.setDeliveryTime(RandomDataGenUtility.randomTime());

                // Generate and set Order Price and Delivery Fee
                foodDeliveryData.setOrderPrice(RandomDataGenUtility.randomBetween(100, 1000));
                foodDeliveryData.setDeliveryFee(RandomDataGenUtility.randomBetween(10, 50));

                // Generate and set Payment Method
                String[] paymentMethod = {"cash", "gpay", "paytm", "phone-pe", "post-paid"};
                foodDeliveryData.setPaymentMethod(RandomDataGenUtility.randomElement(paymentMethod));

                // Generate and set Customer Details
                foodDeliveryData.setCustomerId(UUID.randomUUID().toString());

                // Generate and set Restaurant ID
                foodDeliveryData.setRestaurantId(UUID.randomUUID().toString());

                // Write to file
                bw.write(foodDeliveryData.toString() + "\n");
            }

            bw.flush();
            Thread.sleep(1000);
            System.out.println("Written " + recordsCount + " records to the file.");
        }
    }
}