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
@Table(name = "comment" )
public class Comment {

    private String content;
    private String user;
    private int rate;
    private long id;
    private Game gameId;

    public Comment() {

    }

    public Comment(String content, String user, int rate, long id, Game gameId) {
        this.content = content;
        this.user = user;
        this.rate = rate;
        this.id = id;
        this.gameId = gameId;
    }

    @Column(name = "content", nullable = false, length = 1000)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "user", nullable = false, length = 100)
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Column(name = "rate", nullable = false, length = 1000)
    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Id
    @Column(name = "id", nullable = false, length = 100)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="GAMEID_ID")
    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }
}
