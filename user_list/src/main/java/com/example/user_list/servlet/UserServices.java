package com.example.user_list.servlet;

import com.example.user_list.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServices {
    public List<User> userList= new ArrayList();

    public List<User> firstAdd() {
        userList.add(new User("Mai Văn Hoàn", "1983-08-20", "Hà nội", ""));
        userList.add(new User("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", ""));
        userList.add(new User("Nguyễn Thái Hoà", "1983-08-22", "Nam Định", ""));
        userList.add(new User("Trần Đăng Khoa", "1983-08-17", "Hà Tây", ""));
        userList.add(new User("Nguyễn Đình Thi", "1983-08-19", "Hà nội", ""));
        return userList;
    }

    public List<User> findAll() {
        return userList;
    }
}
