package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    static private int id;
    private String name;
    private Date dob;
    private String Address;
    private String img;

    public User(String name, String dob, String address, String img) {
        id++;
        this.name = name;
        setDob(dob);
        Address = address;
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
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
