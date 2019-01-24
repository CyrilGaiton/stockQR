package fr.utln.ancy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BureauDAO {

    @PersistenceContext(unitName = "BDR")
    private EntityManager em;

    public BureauDAO(){}

    public Bureau getById(long id){
        return em.find(Bureau.class, id);
    }

    public List<Bureau> getAll(){
        return em.createQuery("SELECT e FROM Bureau e").getResultList();
    }

    public void createBureau(MaterialType materialType, boolean bonEtat){
        Bureau bureau = new Bureau();
        bureau.setMaterial(materialType);
        bureau.setBonEtat(bonEtat);
        em.persist(bureau);
    }

    public void deleteBureau(long id){
        Bureau bureau = getById(id);
        if (bureau != null){
            em.remove(bureau);
        }
    }
}
