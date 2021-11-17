package pt.iade.JustReady.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ponto_de_interesse")
public class Pontos_de_interesse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pi_id") 
    private int pi_id;
    @Column(name="pi_name") 
    private String pi_name;
    @Column(name="pi_bio")
    private String pi_bio;
    @Column(name="pi_lat") 
    private float pi_lat;
    @Column(name="pi_long") 
    private float pi_long;
    @Column(name="pi_comment") 
    private String pi_comment;
    
    public int getPi_id() {
        return pi_id;
    }
   
    public String getPi_name() {
        return pi_name;
    }
    
    public String getPi_bio() {
        return pi_bio;
    }
    
    public double getPi_lat() {
        return pi_lat;
    }
    
    public double getPi_long() {
        return pi_long;
    }
    
    public String getPi_comment() {
        return pi_comment;
    }
    

    
}
