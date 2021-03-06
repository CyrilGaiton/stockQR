package fr.utln.ancy.DAO;

import fr.utln.ancy.Beans.Chaise;
import fr.utln.ancy.MaterialType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ChaiseDAO {

    @PersistenceContext(unitName = "BDR")
    private EntityManager em;

    public ChaiseDAO(){}

    public Chaise getById(long id){
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

    public void deleteChaise(long id){
        Chaise chaise = getById(id);
        if (chaise != null){
            em.remove(chaise);
        }
    }

    public void updateChaise(long id, MaterialType material, boolean bonEtat){
        Chaise chaise = getById(id);
        chaise.setMaterial(material);
        chaise.setBonEtat(bonEtat);
        em.merge(chaise);
    }
}
