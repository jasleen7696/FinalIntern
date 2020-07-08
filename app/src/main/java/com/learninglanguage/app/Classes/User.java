package com.learninglanguage.app.Classes;

public class User {

    String uid;
    String email;
    String fname;
    String lname;
    String password;

    public User(String uid, String email, String fname, String lname, String password) {
        this.uid = uid;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
