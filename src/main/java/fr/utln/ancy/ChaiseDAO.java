package fr.utln.ancy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ChaiseDAO {

    @PersistenceContext(unitName = "BDR")
    private EntityManager em;

    public ChaiseDAO(){}

    public Chaise getById(int id){
        return em.find(Chaise.class, id);
    }

    public List getAll(){
        return em.createQuery("SELECT c FROM Chaise c").getResultList();
    }

    public void createChaise(MaterialType materialType, boolean bonEtat){
        Chaise chaise = new Chaise();
        chaise.setMaterial(materialType);
        chaise.setBonEtat(bonEtat);
        em.persist(chaise);
    }

}
