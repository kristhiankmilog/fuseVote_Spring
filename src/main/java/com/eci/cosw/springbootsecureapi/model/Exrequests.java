package com.eci.cosw.springbootsecureapi.model;

import com.eci.cosw.springbootsecureapi.model.User;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "exRequests")
public class Exrequests {

    private int id;  
    private String userRq;
    private String change1Game;
    private String change1;
    private String change2;
    private String state;
    private List<User> users;


    public Exrequests(){
        
    }

    public Exrequests(int id,String userRq, String change1Game, String change1, String change2, String state) {
        this.id = id;
        this.userRq = userRq;
        this.change1Game = change1Game;
        this.change1 = change1;
        this.change2 = change2;
        this.state = state;
    }

    public Exrequests(String userRq, String change1Game, String change1, String change2, String state) {
        this.userRq = userRq;
        this.change1Game = change1Game;
        this.change1 = change1;
        this.change2 = change2;
        this.state = state;
    }


    @Id
	@Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    @Column(name = "userRq")
    public String getUserRq() {
        return userRq;
    }

    @Column(name = "change1Game")
    public String getChange1Game() {
        return change1Game;
    }

    @Column(name = "change1")
    public String getChange1() {
        return change1;
    }

    @Column(name = "change2")
    public String getChange2() {
        return change2;
    }

    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserRq(String userRq) {
        this.userRq = userRq;
    }

    public void setChange1Game(String change1Game) {
        this.change1Game = change1Game;
    }

    public void setChange1(String change1) {
        this.change1 = change1;
    }

    public void setChange2(String change2) {
        this.change2 = change2;
    }

    public void setState(String state) {
        this.state = state;
    }

    @ManyToMany(mappedBy="exrequests",fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    public List<User> getUsers(){
        return this.users;
    }

    public void setUsers(List<User> users){
        this.users=users;
    }
}
