package fr.utln.ancy;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalleDAO {
    @Inject
    private BureauDAO bureauDAO;
    @Inject
    private ChaiseDAO chaiseDAO;

    @PersistenceContext(unitName = "BDR")
    private EntityManager em;

    public SalleDAO(){}

    public Salle getById(int id){
        return em.find(Salle.class, id);
    }

    public Salle getByNom(String nom){
        return (Salle) em.createQuery("SELECT e FROM Salle e WHERE e.nom='"+nom+"'").getSingleResult();
    }

    public List<Salle> getAll(){
        return em.createQuery("SELECT e FROM Salle e").getResultList();
    }

    public void create(String nom){
        Salle salle = new Salle();
        salle.setNom(nom);
        em.persist(salle);
    }

    public void addBureau(String nom, int idBureau){
        Salle salle = this.getByNom(nom);
        Bureau bureau = bureauDAO.getById(idBureau);
        List<Bureau> bureaux = Arrays.asList(salle.getBureaux());
        bureaux.add(bureau);
        salle.setBureaux(bureaux.toArray(new Bureau[bureaux.size()]));
    }

    public void addChaise(String nom, int idChaise){
        Salle salle = this.getByNom(nom);
        Chaise chaise = chaiseDAO.getById(idChaise);
        List<Chaise> chaises = Arrays.asList(salle.getChaises());
        chaises.add(chaise);
        salle.setChaises(chaises.toArray(new Chaise[chaises.size()]));
    }
}

