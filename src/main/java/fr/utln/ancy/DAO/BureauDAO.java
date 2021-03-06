package fr.utln.ancy.DAO;

import fr.utln.ancy.Beans.Bureau;
import fr.utln.ancy.MaterialType;

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

    public void updateBureau(long id, MaterialType material, boolean bonEtat){
        Bureau bureau = getById(id);
        bureau.setMaterial(material);
        bureau.setBonEtat(bonEtat);
        em.merge(bureau);
    }
}
