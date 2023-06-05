package com.example.simple_dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SimpleDictionaryServlet", value = "/simple_dictionary")
public class SimpleDictionaryServlet extends HttpServlet {
    Map<String, String> mapKey = new HashMap<>();

    public void init() {
        mapKey.put("hello", "Chào! Chào cái *beep!");
        mapKey.put("sorry", "Xin lỗi tau đỡ không nổi!");
        mapKey.put("thank", "Cám ơn nhá thằng ngu!");
        mapKey.put("bye", "Chào thân ái và quyết thắng!!!!!!");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String input = request.getParameter("text");
        String result = mapKey.get(input.toLowerCase());
        writer.println("<html>");
        if (result != null) {
            writer.println(String.format("<h1>Dịch sang tiếng việt: %s </h1>", result));
        } else writer.println("<h1>Chịu! chữ khó hiểu vkl!!</h1>");
        writer.println("</html>");
    }

    public void destroy() {
    }
}