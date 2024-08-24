package com.example.streams.generation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class RandomDataGenUtility {

    /**
     * Randomly generate latitude and longitude within a rectangle
     * @param MinLon minimum longitude
     * @param MaxLon maximum longitude
     * @param MinLat minimum latitude
     * @param MaxLat maximum latitude
     * @return A map with random latitude (key: "W") and longitude (key: "J")
     */
    public static Map<String, String> randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat) {
        BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString(); // 6 digits after the decimal
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        Map<String, String> map = new HashMap<>();
        map.put("J", lon);
        map.put("W", lat);
        return map;
    }

    /**
     * Select a random element from an array of strings
     * @param array The array to select from
     * @return A randomly selected element from the array
     */
    public static String randomElement(String[] array) {
        Random r = new Random();
        return array[r.nextInt(array.length)];
    }

    /**
     * Generate a random phone number
     * @return A randomly generated phone number
     */
    public static String randomPhoneno() {
        Random generator = new Random();
        int num1 = generator.nextInt(600) + 100; // numbers can't include an 8 or 9, can't go below 100.
        int num2 = generator.nextInt(641) + 100; // number has to be less than 742, can't go below 100.
        int num3 = generator.nextInt(8999) + 1000; // can't go below 1000.
        return String.format("%03d-%03d-%04d", num1, num2, num3);
    }

    /**
     * Generate a random double between a minimum and maximum value
     * @param min The minimum value
     * @param max The maximum value
     * @return A random double between min and max
     */
    public static double randomBetween(int min, int max) {
        return Math.random() * (max - min) + min;
    }

    /**
     * Generate a random integer between a minimum and maximum value
     * @param min The minimum value
     * @param max The maximum value
     * @return A random integer between min and max
     */
    public static int randomIntBetween(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    /**
     * Generate a random UUID (used for generating unique IDs like order IDs, customer IDs, etc.)
     * @return A randomly generated UUID as a string
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }
    public static String randomDate(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = startEpochDay + new Random().nextInt((int) (endEpochDay - startEpochDay));
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return randomDate.format(formatter);
    }

    /**
     * Generate a random time
     *
     * @return A randomly generated time
     */
    public static String randomTime() {
        Random random = new Random();
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);
        int second = random.nextInt(60);
        LocalTime randomTime = LocalTime.of(hour, minute, second);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return randomTime.format(formatter);
    }
}