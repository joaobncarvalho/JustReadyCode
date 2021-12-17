package pt.iade.JustReady.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="users_id") 
    private int users_id;
    @Column(name="users_name") 
    private String users_name;
    @Column(name="users_bdate") 
    private LocalDate users_bdate;
    @Column(name="users_gender") 
    private char users_gender;
    @Column(name="users_email") 
    private String users_email;
    @Column(name="users_ticket") 
    private int users_ticket;
    @Column(name="users_password")
    private String users_password;
    @Column(name= "users_locationlong")
    private float users_locationlong;
    @Column(name= "users_locationlat")
    private float users_locationlat;



    public int getUsers_id() {
        return users_id;
    }
    
    public String getUsers_name() {
        return users_name;
    }
    
    public LocalDate getUsers_bdate() {return users_bdate;}
    
    public char getUsers_gender() {
        return users_gender;
    }
    
    public String getUsers_email() {
        return users_email;
    }
    
    public int getUsers_ticket() {
        return users_ticket;
    }

    public String getUsers_password() {
        return users_password;
    }

    public float getUsers_locationlong() {return users_locationlong;}

    public float getUsers_locationlat() {
        return users_locationlat;
    }



}
