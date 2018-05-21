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
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author Kristhian Gomez
 * 17/5/18.
 */


@Entity
@Table(name = "UserVote")
public class User {

    private int  id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String borndate;

    private boolean statevote;

    private List<Change> changes;
    private Integer numChanges=0;

    public User()
    {
    }

    public User(int id, String email, String password, String firstname, String lastname, String borndate)
    {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.borndate = borndate;
        this.statevote = false;         
        
    }
    public User(int id, String email, String password, String firstname, String lastname, String borndate, boolean statevote ) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.borndate = borndate;
        this.statevote = statevote; 
        this.changes = new ArrayList<Change>();

        

    }

    public User(int id, String email, String password, String firstname, String lastname, String borndate, boolean statevote, List<Change> changes) {
        
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.borndate = borndate;
        this.statevote = statevote; 
        this.changes = changes;

                
        
        }



    @Column(name = "id")
    public int getId(){ return id; }

    public void setId(int id ){ this.id = id; }

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

    @Column(name = "firstname")
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

    @Column(name = "bornDate")
    public String getbornDate()
    {
        return borndate;
    }

    public void setbornDate( String bornDate )
    {
        this.borndate = bornDate;
    }

    @Column(name = "stateVote")
    public boolean getstateVote()
    {
        return statevote;
    }

    public void setstateVote( boolean stateVote )
    {
        this.statevote = stateVote;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\'' + ", firstname='"
            + firstname +'}';
    }


    
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USERVOTE_EXCHANGES",          
            joinColumns =              
                    @JoinColumn(name="USERVOTE_email", referencedColumnName="email"),         
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


    
    

}
