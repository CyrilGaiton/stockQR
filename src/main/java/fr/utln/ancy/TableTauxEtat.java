package fr.utln.ancy;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TableTauxEtat {
    @Inject
    private TableDAO tableDAO;

    public List<Table> getAll(){
        return tableDAO.getAll();
    }

    public Table getById(int id){ return tableDAO.getById(id); }

    public int tauxBonEtat(){
        List<Table> tables = getAll();
        int count = 0;
        for (Table table:tables) {
            if (table.isBonEtat()){
                count++;
            }
        }
        return ((count/tables.size())*100);
    }
}
