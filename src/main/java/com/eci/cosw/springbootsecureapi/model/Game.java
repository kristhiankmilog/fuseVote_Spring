
package com.eci.cosw.springbootsecureapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="games")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Game implements java.io.Serializable{
    private int id;
    private int rateAcum;
    private String name;
    private String photo;
    private String description;



    //private List<Game> games;
    private List<Seller> sellers;
    private List<Comment> comments;

    public Game(){}

    public Game(int id, int rateAcum, String name, String photo, String description) {
        this.id = id;
        this.rateAcum = rateAcum;
        this.name = name;
        this.photo = photo;
        this.description = description;
    }

    /*
    public Game(String name, String photo, String description, int rateAcum, List<Seller> sellers, List<Comment> comments, int id) {
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.rateAcum = rateAcum;
        this.sellers = sellers;
        this.comments = comments;
        this.id = id;
    }*/
   /* public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }*/

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


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="GAMES_id")
    @Fetch(FetchMode.JOIN)
    public List<Seller> getSellers() {
        return sellers;
    }

   public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="GAMES1_id")
     public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


}
