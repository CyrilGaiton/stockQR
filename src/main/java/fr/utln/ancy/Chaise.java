package fr.utln.ancy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Chaise {

    @Id
    @GeneratedValue
    @NotNull
    private long id;
    @NotBlank
    private MaterialType matériel;
    @NotNull
    private boolean bonEtat;

    public Chaise(){}

    public MaterialType getMatériel() {
        return matériel;
    }

    public void setMatériel(MaterialType matériel) {
        this.matériel = matériel;
    }

    public boolean isBonEtat() {
        return bonEtat;
    }

    public void setBonEtat(boolean bonEtat) {
        this.bonEtat = bonEtat;
    }
}
