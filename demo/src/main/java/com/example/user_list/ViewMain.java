package com.example.user_list;

import Model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ViewMain", value = "/index.jsp")
public class ViewMain extends HttpServlet {
    private String message;
    private List<User> userList = new ArrayList<>();;

    public void init() {
        userList.add(new User("Mai Văn Hoàn", "1983-08-20", "Hà nội", ""));
        userList.add(new User("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", ""));
        userList.add(new User("Nguyễn Thái Hoà", "1983-08-22", "Nam Định", ""));
        userList.add(new User("Trần Đăng Khoa", "1983-08-17", "Hà Tây", ""));
        userList.add(new User("Nguyễn Đình Thi", "1983-08-19", "Hà nội", ""));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("userlist", userList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}