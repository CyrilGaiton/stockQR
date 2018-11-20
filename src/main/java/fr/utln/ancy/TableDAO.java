package fr.utln.ancy;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Dependent
public class TableDAO {

    @PersistenceContext
    private EntityManager em;

    public TableDAO(){}

    public Table getById(int id){
        return em.find(Table.class, id);
    }

    public List<Table> getAll(){
        return em.createQuery("SELECT e FROM Table e").getResultList();
    }
}
