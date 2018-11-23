package fr.utln.ancy;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@SessionScoped
public class TestBackingBean {
    @Inject
    private BureauTauxEtat bureauTauxEtat;

//    @Inject
//    private ChaiseTauxEtat chaiseTauxEtat;

    public List<Bureau> bureauGetAll(){
        return bureauTauxEtat.getAll();
    }

    public Bureau bureauGetId(int id){ return bureauTauxEtat.getById(id); }

    public int bureauTauxBonEtat(){ return bureauTauxEtat.tauxBonEtat(); }

//    public List<Chaise> chaiseGetAll(){return chaiseTauxEtat.getAll();}
//
//    public Chaise chaiseGetId(int id) { return chaiseTauxEtat.getById(id); }
//
//    public int chaiseTauxBonEtat(){ return chaiseTauxEtat.tauxBonEtat(); }
}
