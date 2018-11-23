package fr.utln.ancy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Bureau {

    @Id
    @GeneratedValue
    @NotNull
    @Min(0)
    private long bureauId;

    @CheckMaterial
    @Enumerated(EnumType.STRING)
    private MaterialType material;

    @NotNull
    private boolean bonEtat;

    public Bureau(){}

    public MaterialType getMaterial() {
        return material;
    }

    public void setMaterial(MaterialType material) {
        this.material = material;
    }

    public long getBureauId() {
        return bureauId;
    }

    public boolean isBonEtat() {
        return bonEtat;
    }

    public void setBonEtat(boolean bonEtat) {
        this.bonEtat = bonEtat;
    }
}
