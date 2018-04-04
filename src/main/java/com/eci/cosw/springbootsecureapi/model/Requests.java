package com.eci.cosw.springbootsecureapi.model;

import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.model.Change;

public class Requests {

    private User userRq;
    private Change change1;
    private Change change2;
    private String state;


    public Requests(User userRq, Change change1, Change change2, String state) {
        this.userRq = userRq;
        this.change1 = change1;
        this.change2 = change2;
        this.state = state;
    }

    public User getUserRq() {
        return userRq;
    }

    public Change getChange1() {
        return change1;
    }

    public Change getChange2() {
        return change2;
    }

    public String getState() {
        return state;
    }

    public void setUserRq(User userRq) {
        this.userRq = userRq;
    }

    public void setChange1(Change change1) {
        this.change1 = change1;
    }

    public void setChange2(Change change2) {
        this.change2 = change2;
    }

    public void setState(String state) {
        this.state = state;
    }
}
