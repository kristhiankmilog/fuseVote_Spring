/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.*;

/**
 *
 * @author Kazu
 */
@Entity
@Table(name="seller")
public class Seller {

    private String price;
    private String link;
    private long id;
    private Game idGame;

    public Seller(long id, String price, String link, Game gameId){

        this.price=price;
        this.link=link;
        this.id=id;
        this.idGame=gameId;

    }
    public Seller(){

    }

    @Column(name = "price", nullable = false, length = 100)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Column(name = "link", nullable = false, length = 100)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Id
    @Column(name = "id", nullable = false, length = 100)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="IDGAME_ID")
    public Game getIdGame() {
        return idGame;
    }

    public void setIdGame(Game idGame) {
        this.idGame = idGame;
    }
}
