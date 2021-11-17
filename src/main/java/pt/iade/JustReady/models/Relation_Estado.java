package pt.iade.JustReady.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "relation_estado")
public class Relation_Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="st_id") 
    private int st_id;
    @Column(name="st_name") 
    private String st_name;

    public int getSt_id() {
        return st_id;
    }
    
    public String getSt_name() {
        return st_name;
    }
    

    
}
