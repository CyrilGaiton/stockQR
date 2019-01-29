package fr.utln.ancy.Beans;

import fr.utln.ancy.CheckSalleNom;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Salle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Min(0)
    private long idSalle;

    @NotBlank
    @Column(unique = true)
    @CheckSalleNom
    private String nom;

//    @ManyToOne
//    private Bureau[] bureaux;
//
//    @ManyToOne
//    private Chaise[] chaises;

    public Salle(){}


    public long getIdSalle() {
        return idSalle;
    }

//    public Bureau[] getBureaux() {
//        return bureaux;
//    }
//
//    public void setBureaux(Bureau[] bureaux) {
//        this.bureaux = bureaux;
//    }
//
//    public Chaise[] getChaises() {
//        return chaises;
//    }
//
//    public void setChaises(Chaise[] chaises) {
//        this.chaises = chaises;
//    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

