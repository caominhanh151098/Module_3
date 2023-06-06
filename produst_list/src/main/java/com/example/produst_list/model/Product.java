package com.example.produst_list.model;

import com.example.produst_list.services.CategoryService;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private Category category;
    private static int currentId;

    private final CategoryService categoryService = new CategoryService();


    public Product(String name, double price, int quantity, int categoryId) {
        this.id = currentId++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = categoryService.findById(categoryId);
    }

    public Product(int id, String name, double price, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        Product.currentId = currentId;
    }
}
