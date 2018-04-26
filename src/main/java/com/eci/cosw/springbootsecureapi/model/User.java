package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;
import com.eci.cosw.springbootsecureapi.model.Change;
import com.eci.cosw.springbootsecureapi.model.Exrequests;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author Santiago Carrillo
 * 8/21/17.
 */


@Entity
@Table(name = "User")
public class User {

    private int  id;

    private String email;

    private String password;

    private String firstname;

    private String lastname;

    private String username;

    private String image;

    private String description;

    private List<Change> changes ;
    private Integer numChanges=0;
    
    private List<Exrequests> exrequests ;
    private Integer numRequest=0;


    public User()
    {
    }

    public User( String email, String password, String firstname, String lastname, String image )
    {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.image = image;
    }
    public User(int id,String email, String password, String name,String lastname, String username, String image, String description) {

        this.email = email;

        this.password = password;

        this.image = image;

        this.firstname = name;

        this.id=id;

        this.lastname = lastname;

        this.description = description;

        this.username = username;

        this.changes = new ArrayList<Change>();

        this.exrequests = new ArrayList<Exrequests>();

    }

    public User(int id,String email, String password, String name,String lastname, String username, String image, String description, List<Change> changes, List<Exrequests> exrequests) {
        
                this.email = email;
        
                this.password = password;
        
                this.image = image;
        
                this.firstname = name;
        
                this.id=id;
        
                this.lastname = lastname;
        
                this.description = description;
        
                this.username = username;

                this.changes = changes;

                this.exrequests = exrequests;
        
            }



    @Column(name = "description")
    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }


    @Column(name = "id")
    public int getId(){ return id; }

    public void setId(int id ){ this.id = id; }

    @Column(name = "image")
    public String getImage()
    {
        return image;
    }

    public void setImage( String image )
    {
        this.image = image;
    }

    @Id
    @Column(name = "email",unique = true)
    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    @Column(name = "name")
    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname( String firstname )
    {
        this.firstname = firstname;
    }

    @Column(name = "lastname")
    public String getLastname()
    {
        return lastname;
    }

    public void setLastname( String lastname )
    {
        this.lastname = lastname;
    }

    @Column(name = "username")
    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\'' + ", firstname='"
            + firstname +  ", username='" + username + '\'' + ", image='" + image + '\'' +'}';
    }


    
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_EXCHANGES",          
            joinColumns =              
                    @JoinColumn(name="USER_email", referencedColumnName="email"),         
            inverseJoinColumns =              
                    @JoinColumn(name="EXCHANGE_id", referencedColumnName="id")
    )      
    public List<Change> getListChange(){
        return this.changes;
    }
    
    public void setListChange(List<Change> changes){
        this.changes=changes;
    }

    public void addNewChange(Change newChange){
        //this.numChanges=this.numChanges+1;
        //newChange.setId(this.numChanges);
        this.changes.add(newChange);
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_EXREQUESTS",          
            joinColumns =              
                    @JoinColumn(name="USER_email", referencedColumnName="email"),         
            inverseJoinColumns =              
                    @JoinColumn(name="EXREQUESTS_id", referencedColumnName="id")
    ) 
    
    public List<Exrequests> getExrequests() {
        return this.exrequests;
    }

    public void addNewRequests(Exrequests newRequests) {
    // aqui se le agrega el id a la solicitud
        //this.numRequest=this.numRequest+1;
        //newRequests.setId(this.numRequest);
        this.exrequests.add(newRequests);
    }

    public void setExrequests(List<Exrequests> exrequests){
        this.exrequests=exrequests;
    }

}
