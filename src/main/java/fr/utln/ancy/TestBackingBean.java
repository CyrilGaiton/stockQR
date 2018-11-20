package fr.utln.ancy;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ManagedBean
@SessionScoped
public class TestBackingBean {
    @Inject
    private TableTauxEtat tableTauxEtat;

    @Inject
    private ChaiseTauxEtat chaiseTauxEtat;

    public List<Table> tableGetAll(){
        return tableTauxEtat.getAll();
    }

    public Table tableGetId(int id){ return tableTauxEtat.getById(id); }

    public int tableTauxBonEtat(){ return tableTauxEtat.tauxBonEtat(); }

    public List<Chaise> chaiseGetAll(){return chaiseTauxEtat.getAll();}

    public Chaise chaiseGetId(int id) { return chaiseTauxEtat.getById(id); }

    public int chaiseTauxBonEtat(){ return chaiseTauxEtat.tauxBonEtat(); }
}
