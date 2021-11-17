package pt.iade.JustReady.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "relationshiplist")
public class RelationShiplist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rl_id") 
    private int rl_id;
    @Column(name="rl_name") 
    private String rl_name;
    @Column(name="rl_listcount") 
    private int rl_listcount;
    @Column(name="rl_us_num") 
    private int rl_us_num;
    
    public int getRl_id() {
        return rl_id;
    }
    
    public String getRl_name() {
        return rl_name;
    }

    public int getRl_listcount() {
        return rl_listcount;
    }

    public int getRl_us_num() {
        return rl_us_num;
    }


}
