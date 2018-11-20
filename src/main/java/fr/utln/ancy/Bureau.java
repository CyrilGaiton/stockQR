package fr.utln.ancy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bureau {

    @Id
    @GeneratedValue
    private long bureauId;
    private String matériel;
    private boolean bonEtat;

    public Bureau(){}

    public String getMatériel() {
        return matériel;
    }

    public void setMatériel(String matériel) {
        this.matériel = matériel;
    }

    public long getBureauId() {
        return bureauId;
    }

    public void setBureauId(long bureauId) {
        this.bureauId = bureauId;
    }

    public boolean isBonEtat() {
        return bonEtat;
    }

    public void setBonEtat(boolean bonEtat) {
        this.bonEtat = bonEtat;
    }
}
