package com.example.user_list.controller;

import com.example.user_list.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ViewMain", value = "/user1")
public class ViewMain extends HttpServlet {
    private String message;
    public static List<User> userList = new ArrayList<>();

    public void init() {
        userList.add(new User("Mai Văn Hoàn", "1983-08-20", "Hà nội", ""));
        userList.add(new User("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", ""));
        userList.add(new User("Nguyễn Thái Hoà", "1983-08-22", "Nam Định", ""));
        userList.add(new User("Trần Đăng Khoa", "1983-08-17", "Hà Tây", ""));
        userList.add(new User("Nguyễn Đình Thi", "1983-08-19", "Hà nội", ""));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "edit":
                showUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            default: {
                request.setAttribute("userlist", userList);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "add":
                addUser(request, response);
                break;
            case "edit":
                editUser(request, response);
                break;
            default: {
                request.setAttribute("userlist", userList);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

    public void showUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userList.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        request.setAttribute("userinfo", user);
        request.getRequestDispatcher("edit_user.jsp").forward(request, response);
    }

    public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");

        userList.add(new User(name, dob, address, ""));
        message = "Thêm mới thành công!";
        request.setAttribute("userlist", userList);
        request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");

        User user = userList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        user.setName(name);
        user.setDob(dob);
        user.setAddress(address);
        message = "Sửa thành công!";
        request.setAttribute("userlist", userList);
        request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        userList = userList.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
        message = "Xóa thành công!";
        request.setAttribute("userlist", userList);
        request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}