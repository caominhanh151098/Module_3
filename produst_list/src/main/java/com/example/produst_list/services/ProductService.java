package com.example.produst_list.services;

import com.example.produst_list.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    List<Product> productList = new ArrayList<>();

    public void firstAdd() {
        productList.add(new Product("Áo dài", 4.5, 10, 1));
        productList.add(new Product("Áo ngắn", 4.5, 10, 1));
        productList.add(new Product("Quần ngắn", 3.5, 10, 2));
        productList.add(new Product("Quần dài", 3.5, 10, 2));
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id)
                return product;
        }
        return null;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void editProduct(Product product) {
        for (Product item : productList) {
            if (product.getId() == item.getId()) {
                item.setName(product.getName());
                item.setPrice(product.getPrice());
                item.setQuantity(product.getQuantity());
                item.setCategory(product.getCategory());
                return;
            }
        }
    }

    public Product deleteProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.remove(i);
            }
        }
        return null;
    }

}
