package pt.iade.JustReady.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artistas")
public class Artistas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="art_id")
    private int  art_id;
    @Column(name="art_name")
    private String art_name;
    @Column(name="art_concert")
    private LocalDate art_concert;

    public int getArt_id() {
        return art_id;
    }
    
    public String getArt_name() {
        return art_name;
    }
    
    public LocalDate getArt_concert() {
        return art_concert;
    }
    
}
