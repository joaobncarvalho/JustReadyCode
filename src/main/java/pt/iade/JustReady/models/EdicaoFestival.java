package pt.iade.JustReady.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "edicaofestival")
public class EdicaoFestival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="edi_id") 
    private int edi_id;
    @Column(name="edi_name") 
    private String edi_name;
    @Column(name="edi_numeroedicao") 
    private int edi_numeroedicao;

    public int getEdi_id() {
        return edi_id;
    }
    
    public String getEdi_name() {
        return edi_name;
    }
    
    public int getEdi_numeroedicao() {
        return edi_numeroedicao;
    }
    
    
}
