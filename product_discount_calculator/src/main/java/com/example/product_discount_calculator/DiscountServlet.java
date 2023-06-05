package com.example.product_discount_calculator;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("discount"));

        double discount_amount = price * discount * 0.01;
        double discount_price = price - discount_amount;

        writer.println("<html>");
        writer.println(String.format("<label>Product Description: %s</label><br>", description));
        writer.println(String.format("<label>List Price: %s</label><br>", price));
        writer.println(String.format("<label>Discount Percent: %s</label><br>", discount));

        writer.println(String.format("<label>Discount Amount: %s</label><br>", discount_amount));
        writer.println(String.format("<label>Discount Price: %s</label><br>", discount_price));
        writer.println("</html>");
    }

    public void destroy() {
    }
}