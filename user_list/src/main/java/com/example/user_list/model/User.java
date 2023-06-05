package com.example.user_list.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private int id;
    private String name;
    private Date dob;
    private String address;
    private String img;
    static private int curretId;

    public User() {
    }

    public User(String name, String dob, String address, String img) {
        this.id = curretId++;
        this.name = name;
        setDob(dob);
        this.address = address;
        this.img = img;
    }

    public User(int id, String name, Date dob, String address, String img) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return new SimpleDateFormat("yyyy-MM-dd").format(this.dob);
    }

    public void setDob(String dob) {
        try {
            this.dob = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
