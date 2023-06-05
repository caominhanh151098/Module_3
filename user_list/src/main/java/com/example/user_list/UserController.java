package com.example.user_list;

import com.example.user_list.model.User;
import com.example.user_list.servlet.UserServices;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserController", urlPatterns = "/user")
public class UserController extends HttpServlet {
    UserServices userServices = new UserServices();
    List<User> userList = new ArrayList<>();

    public void init() {
        userList = userServices.firstAdd();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            default:
                showList(req, resp);
        }
    }

    public void showList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        userList = userServices.findAll();
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
