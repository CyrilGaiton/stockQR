package fr.utln.ancy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Table {

    @Id
    @GeneratedValue
    private long tableId;
    private String matériel;

    public Table(){}

    public String getMatériel() {
        return matériel;
    }

    public void setMatériel(String matériel) {
        this.matériel = matériel;
    }

}
