package pt.iade.JustReady.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_type")
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tt_id") 
    private int tt_id;
    @Column(name="tt_name") 
    private String tt_name;
    @Column(name="tt_price") 
    private float tt_price;

    public int getTt_id() {
        return tt_id;
    }

    public String getTt_name() {
        return tt_name;
    }

    public float getTt_price() {
        return tt_price;
    }

}
