package pt.iade.JustReady.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "palco")
public class TablePalco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="palco_id") 
    private int pal_id;
    @Column(name="palco_name") 
    private String pal_name;
    @Column(name="palco_lat") 
    private float pal_lat;
    @Column(name="palco_long") 
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
