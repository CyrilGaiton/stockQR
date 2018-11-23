package fr.utln.ancy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Chaise {

    @Id
    @GeneratedValue
    @NotNull
    @Min(0)
    private long chaiseId;
//    @CheckMaterial
    private MaterialType material;
    @NotNull
    private boolean bonEtat;

    public Chaise(){}

    public MaterialType getMaterial() {
        return material;
    }

    public void setMaterial(MaterialType material) {
        this.material = material;
    }

    public long getChaiseId(){ return chaiseId; }

    public boolean isBonEtat() {
        return bonEtat;
    }

    public void setBonEtat(boolean bonEtat) {
        this.bonEtat = bonEtat;
    }
}
