package pt.iade.JustReady.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "palco")
public class Palco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pal_id")
    private int pal_id;
    @Column(name="pal_name")
    private String pal_name;
    @Column(name="pal_lat")
    private float pal_lat;
    @Column(name="pal_long")
    private float pal_long;

    public int getPal_id() {
        return pal_id;
    }
    
    public String getPal_name() {
        return pal_name;
    }

    public float getPal_lat() {
        return pal_lat;
    }


    public float getPal_long() {
        return pal_long;
    }

    
    
    
}
