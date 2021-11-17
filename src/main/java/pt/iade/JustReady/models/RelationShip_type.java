package pt.iade.JustReady.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "relationship_type")
public class RelationShip_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="rel_id") 
    private int rl_id;
    @Column(name="rel_name") 
    private String rl_name;
   
    
    public int getRel_id() {
        return rl_id;
    }
    
    public String getRel_name() {
        return rl_name;
    }
    
    
}
