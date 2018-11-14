package fr.utln.ancy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TableDAO {

    @PersistenceContext
    private EntityManager em;

    public TableDAO(){}

    public Table getById(int id){
        return em.find(Table.class, id);
    }

    public List getAll(){
        return em.createQuery("SELECT e FROM Table e").getResultList();
    }
}
