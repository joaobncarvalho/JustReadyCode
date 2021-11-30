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
    @Column(name="rl_rel_nameid")
    private String rl_rel_nameid;
    @Column(name="rl_users_num")
    private int rl_users_num;
    @Column(name="rl_users_idmain")
    private int rl_users_idmain;
    @Column(name="rl_users_idfriend")
    private int rl_users_idfriend;

    
    public int getRl_id() {
        return rl_id;
    }
    
    public String getRl_rel_nameid() {
        return rl_rel_nameid;
    }

    public int getRl_users_num() {
        return rl_users_num;
    }

    public int getRl_users_idmain() {
        return rl_users_idmain;
    }

    public int getRl_users_idfriend() {
        return rl_users_idfriend;
    }


}
