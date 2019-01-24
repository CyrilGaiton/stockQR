package fr.utln.ancy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Chaise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Min(0)
    private long chaiseId;
    @CheckMaterial
    @Enumerated(EnumType.STRING)
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
