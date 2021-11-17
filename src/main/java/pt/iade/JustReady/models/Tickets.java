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
    @Column(name="tick_id") 
    private int tick_id;
    @Column(name="tick_name") 
    private String tick_name;
    @Column(name="tick_number") 
    private int tick_number;
    @Column(name="ticket_tt_id") 
    private int ticket_tt_id;
    
    public int getTick_id() {
        return tick_id;
    }
    
    public String getTick_name() {
        return tick_name;
    }
    
    public int getTick_number() {
        return tick_number;
    }
    
    public int getTicket_tt_id() {
        return ticket_tt_id;
    }
    

    
}
