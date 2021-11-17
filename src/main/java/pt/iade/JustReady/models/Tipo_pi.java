package pt.iade.JustReady.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_pi")
public class Tipo_pi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tpi_id") 
    private int tpi_id;
    @Column(name="tpi_name") 
    private String tpi_name;
    @Column(name="tpi_pi_id") 
    private int tpi_pi_id;
    

    public int getTpi_id() {
        return tpi_id;
    }
    
    public String getTpi_name() {
        return tpi_name;
    }
    
    public int getTpi_pi_id() {
        return tpi_pi_id;
    }
    
}
