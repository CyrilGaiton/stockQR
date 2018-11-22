package fr.utln.ancy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Bureau {

    @Id
    @GeneratedValue
    @NotNull
    private long bureauId;

    @NotBlank
    private MaterialType matériel;

    @NotNull
    private boolean bonEtat;

    public Bureau(){}

    public MaterialType getMatériel() {
        return matériel;
    }

    public void setMatériel(MaterialType matériel) {
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
