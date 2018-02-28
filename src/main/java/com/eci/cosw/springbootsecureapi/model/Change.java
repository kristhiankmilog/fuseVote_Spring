package com.eci.cosw.springbootsecureapi.model;

public class Change{

    private Integer id;    
    private String nameGame;    
    private String description;    
    private String image;    
    private String state;    
    private Boolean accept;

    public Change(Integer id, String nameGame, String description, String image, String state, Boolean accept){
	this.setId(id);
	this.setNameGame(nameGame);
	this.setDescription(description);
	this.setImage(image);
	this.setState(state);
	this.setAccept(accept);
        
        
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    
    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public String getNameGame() {
        return nameGame;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
    
    public void setAccept(Boolean accept) {
        this.accept = accept;
    }

    public Boolean getAccept() {
        return accept;
    }
}
