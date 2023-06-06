package com.example.simple_calculator;

import java.io.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Calculator", value = "/calculator")
public class Calculator extends HttpServlet {

    static private String message;

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String o1 = request.getParameter("o1");
        String op = request.getParameter("op");
        String o2 = request.getParameter("o2");

        double num1 = Double.parseDouble(o1);
        double num2 = Double.parseDouble(o2);
        double result = 0;
        switch (op) {
            case "+":
                result = num1 + num2;
                message = String.format("%s + %s = %s", num1, num2, result);
                break;
            case "-":
                result = num1 - num2;
                message = String.format("%s - %s = %s", num1, num2, result);
                break;
            case "*":
                result = num1 * num2;
                message = String.format("%s * %s = %s", num1, num2, result);
                break;
            case "/":
                if (num2 == 0)
                    message = "Không thể chia cho 0";
                else {
                    result = num1 / num2;
                    message = String.format("%s / %s = %s", num1, num2, result);
                }
                break;
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    public void destroy() {
    }
}