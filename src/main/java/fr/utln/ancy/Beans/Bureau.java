package fr.utln.ancy.Beans;

import fr.utln.ancy.MaterialType;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Bureau implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Min(0)
    private long bureauId;

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
