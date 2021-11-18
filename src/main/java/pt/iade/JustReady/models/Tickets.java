package pt.iade.JustReady.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tickets_id")
    private int tickets_id;
    @Column(name="tickets_name")
    private String tickets_name;
    @Column(name="tickets_number")
    private int tickets_number;
    @Column(name="tickets_tt_id")
    private int tickets_tt_id;
    
    public int getTickets_id() {
        return tickets_id;
    }
    
    public String getTickets_name() {
        return tickets_name;
    }
    
    public int getTickets_number() {
        return tickets_number;
    }
    
    public int getTickets_tt_id() {
        return tickets_tt_id;
    }
    

    
}
