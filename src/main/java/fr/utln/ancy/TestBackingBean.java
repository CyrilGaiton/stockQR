package fr.utln.ancy;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ManagedBean
@Named
@SessionScoped
public class TestBackingBean {
    @Inject
    TableTauxEtat tableTauxEtat;

    public List<Table> TableGetAll(){
        return tableTauxEtat.getAll();
    }

    public Table TableGetId(int id){ return tableTauxEtat.getById(id); }

    public int TableTauxBonEtat(){ return tableTauxEtat.tauxBonEtat(); }
}
