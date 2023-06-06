package com.example.produst_list.services;

import com.example.produst_list.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    static List<Category> categories;

    static {
        categories = new ArrayList<>();
        categories.add(new Category(1, "Áo"));
        categories.add(new Category(2, "Quần"));
    }

    public List<Category> findAll() {
        return categories;
    }

    public Category findById(int id) {
        return categories.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
}
