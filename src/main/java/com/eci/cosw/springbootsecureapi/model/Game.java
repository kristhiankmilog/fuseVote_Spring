
package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="games")
public class Game implements java.io.Serializable{
    private int id;
    private int rateAcum;
    private String name;
    private String photo;
    private String description;
    //private List<Seller> sellers;
    private List<Comment> comments;

    public Game(){}

    public Game(int id, int rateAcum, String name, String photo, String description) {
        this.id = id;
        this.rateAcum = rateAcum;
        this.name = name;
        this.photo = photo;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 150)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name",nullable = false,length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="photo",nullable = false,length = 150)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column(name="description",nullable = false,length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="rate",nullable = false,length = 150)
    public int getRateAcum() {
        return rateAcum;
    }

    public void setRateAcum(int rateAcum) {
        this.rateAcum = rateAcum;
    }

/*
    @OneToMany(mappedBy = "idGame")
    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }
*/

    @OneToMany(mappedBy = "gameId")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString(){
        return "Game-> id:"+Integer.toString(id);
    }

}
