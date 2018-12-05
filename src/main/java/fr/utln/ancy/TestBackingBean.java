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

    @Inject
    private ChaiseTauxEtat chaiseTauxEtat;

    public MaterialType materialType;
    public boolean bonEtat;

    public List<Bureau> bureauGetAll(){
        return bureauTauxEtat.getAll();
    }

    public Bureau bureauGetId(int id){ return bureauTauxEtat.getById(id); }

    public String bureauCreate(){
        bureauTauxEtat.createBureau(materialType, bonEtat);
        return "getAll";
    }

    public float bureauTauxBonEtat(){ return bureauTauxEtat.tauxBonEtat(); }

    public List<Chaise> chaiseGetAll(){return chaiseTauxEtat.getAll();}

    public Chaise chaiseGetId(int id) { return chaiseTauxEtat.getById(id); }

    public String chaiseCreate(){
        chaiseTauxEtat.createChaise(materialType, bonEtat);
        return "getAll";
    }

    public float chaiseTauxBonEtat(){ return chaiseTauxEtat.tauxBonEtat(); }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public boolean isBonEtat() {
        return bonEtat;
    }

    public void setBonEtat(boolean bonEtat) {
        this.bonEtat = bonEtat;
    }
}
