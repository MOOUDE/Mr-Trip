package com.example.mrsnack.mrtrip.Moduls;

public class Guide {

    int id;
    String Name;
    String phoneNum;


    public Guide(int id, String name, String phoneNum) {
        this.id = id;
        Name = name;
        this.phoneNum = phoneNum;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
