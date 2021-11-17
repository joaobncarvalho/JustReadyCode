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

    public int getUsers_id() {
        return users_id;
    }
    
    public String getUsers_name() {
        return users_name;
    }
    
    public LocalDate getUsers_bdate() {
        return users_bdate;
    }
    
    public char getUsers_gender() {
        return users_gender;
    }
    
    public String getUsers_email() {
        return users_email;
    }
    
    public int getUsers_ticket() {
        return users_ticket;
    }
    









}