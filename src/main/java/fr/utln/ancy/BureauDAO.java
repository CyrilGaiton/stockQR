package fr.utln.ancy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BureauDAO {

    @PersistenceContext(unitName = "BDR")
    private EntityManager em;

    public BureauDAO(){}

    public Bureau getById(int id){
        return em.find(Bureau.class, id);
    }

    public List<Bureau> getAll(){
        return em.createQuery("SELECT e FROM Bureau e").getResultList();
    }
}
