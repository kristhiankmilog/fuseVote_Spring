package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exChange")
public class Change{

    private int id;    
    private String nameGame;    
    private String description;    
    private String image;    
    private String state;    
    private Boolean accept;
    private String user;
    private List<User> users;

    public Change(int id, String nameGame, String description, String image, String state, Boolean accept,String user){
	this.id=id;
	this.nameGame=nameGame;
	this.description=description;
	this.image=image;
    this.state=state;
	this.accept=accept;
    this.user=user;
        
        
    }

    public Change(){
        
    }
    

   
    public void setId(int id) {
        this.id = id;
    }

    @Id
	@Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    
    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    @Column(name = "namegame")
    public String getNameGame() {
        return nameGame;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "state")
    public String getState() {
        return state;
    }
    
    public void setAccept(Boolean accept) {
        this.accept = accept;
    }

    @Column(name = "accept")
    public Boolean getAccept() {
        return accept;
    }


    public void setUser(String user) {
        this.user = user;
    }

    @Column(name = "user")
    public String getUser() {
        return user;
    }

    @ManyToMany(mappedBy="listChange",fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    public List<User> getUsers(){
        return this.users;
    }

    public void setUsers(List<User> users){
        this.users=users;
    }
}
