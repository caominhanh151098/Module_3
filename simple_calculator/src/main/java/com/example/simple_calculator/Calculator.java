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

        if (isNumeric(o1) == false || isNumeric(o2) == false) {
            message = "Số nhập vào không phải là số!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        double num2 = Double.parseDouble(o2);
        if (op.equals("/") && num2 == 0L) {
            message = "Không thể chia cho 0!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            String operator = o1 + op + o2;
            double result;
            try {
                result = (double) engine.eval(operator);
            } catch (ScriptException e) {
                throw new RuntimeException(e);
            }
            message = operator + " = " + result;
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}