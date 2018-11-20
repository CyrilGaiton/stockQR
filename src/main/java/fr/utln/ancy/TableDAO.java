package fr.utln.ancy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TableDAO {

    @PersistenceContext(unitName = "BDR")
    private EntityManager em;

    public Table getById(int id){
        return em.find(Table.class, id);
    }

    public List<Table> getAll(){
        return em.createQuery("SELECT e FROM Table e").getResultList();
    }
}
