package fr.utln.ancy;

import javax.inject.Inject;
import java.util.List;

public class TableBean {
    @Inject
    TableDAO tableDAO;

    public List<Table> getAll(){
        return tableDAO.getAll();
    }
}
