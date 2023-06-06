package com.example.produst_list.controller;

import com.example.produst_list.model.Category;
import com.example.produst_list.model.Product;
import com.example.produst_list.services.CategoryService;
import com.example.produst_list.services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "add":
                showAddProduct(req, resp);
                break;
            case "edit":
                showEditProduct(req, resp);
                break;
            case "delete":
                deleteProduct(req,resp);
                break;
            default:
                showProdusts(req, resp);
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
         productService.deleteProduct(id);
         showProdusts(req,resp);


    }

    private void showEditProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("categories", categoryService.findAll());
        req.setAttribute("product",product);
        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "add":
                createProduct(req, resp);
                break;
            case "edit":
                editProduct(req,resp);
                break;
            default:
                showProdusts(req, resp);
        }
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int categoryId = Integer.parseInt(req.getParameter("category"));
        Category category = categoryService.findById(categoryId);
        Product product = new Product(id,name,price,quantity,category);
        productService.editProduct(product);
        req.setAttribute("product",product);
        req.setAttribute("message", "Edited");
        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }


    @Override
    public void init() throws ServletException {
        productService.firstAdd();
    }

    private void showProdusts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }
    private void showAddProduct(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException {
        res.setAttribute("categories", categoryService.findAll());
        res.getRequestDispatcher("/create.jsp")
                .forward(res, resp);
    }
    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy các giá trị ở ô input
        // create object Product;
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int categoryId = Integer.parseInt(req.getParameter("category"));
        Category category = categoryService.findById(categoryId);
        Product product = new Product(name, price, quantity,categoryId);
        productService.addProduct(product);
        req.setAttribute("message","Added");
        req.setAttribute("product", product);
        req.getRequestDispatcher("/create.jsp")
                .forward(req, resp);
    }
}
