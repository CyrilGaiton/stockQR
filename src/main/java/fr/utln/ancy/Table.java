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
    private boolean bonEtat;

    public Table(){}

    public String getMatériel() {
        return matériel;
    }

    public void setMatériel(String matériel) {
        this.matériel = matériel;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public boolean isBonEtat() {
        return bonEtat;
    }

    public void setBonEtat(boolean bonEtat) {
        this.bonEtat = bonEtat;
    }
}
