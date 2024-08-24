package com.example.streams.generation;

import com.google.gson.Gson;

public class FoodDeliveryData {

    private String orderId;
    private String deliveryPersonId;
    private int deliveryPersonAge;
    private double personRating;
    private double deliveryLatitude;
    private double deliveryLongitude;
    private double restaurantLatitude;
    private double restaurantLongitude;
    private String orderDate;
    private String orderTime;
    private String deliveryDate;
    private String deliveryTime;
    private double orderPrice;
    private double deliveryFee;
    private String paymentMethod;
    private String customerId;
    private String restaurantId;

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public void setDeliveryPersonId(String deliveryPersonId) {
        this.deliveryPersonId = deliveryPersonId;
    }

    public int getDeliveryPersonAge() {
        return deliveryPersonAge;
    }

    public void setDeliveryPersonAge(int deliveryPersonAge) {
        this.deliveryPersonAge = deliveryPersonAge;
    }

    public double getPersonRating() {
        return personRating;
    }

    public void setPersonRating(double personRating) {
        this.personRating = personRating;
    }

    public double getDeliveryLatitude() {
        return deliveryLatitude;
    }

    public void setDeliveryLatitude(double deliveryLatitude) {
        this.deliveryLatitude = deliveryLatitude;
    }

    public double getDeliveryLongitude() {
        return deliveryLongitude;
    }

    public void setDeliveryLongitude(double deliveryLongitude) {
        this.deliveryLongitude = deliveryLongitude;
    }

    public double getRestaurantLatitude() {
        return restaurantLatitude;
    }

    public void setRestaurantLatitude(double restaurantLatitude) {
        this.restaurantLatitude = restaurantLatitude;
    }

    public double getRestaurantLongitude() {
        return restaurantLongitude;
    }

    public void setRestaurantLongitude(double restaurantLongitude) {
        this.restaurantLongitude = restaurantLongitude;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    // Convert the object to JSON format using Gson
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}