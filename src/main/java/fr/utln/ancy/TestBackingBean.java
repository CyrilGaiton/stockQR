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

    public long id;
    public MaterialType materialType;
    public boolean bonEtat;

    public List<Bureau> bureauGetAll(){
        return bureauTauxEtat.getAll();
    }

    public Bureau bureauGetId(){ return bureauTauxEtat.getById(id); }

    public String bureauCreate(){
        bureauTauxEtat.createBureau(materialType, bonEtat);
        return "bureaux";
    }

    public void bureauDelete(long id){
        bureauTauxEtat.deleteBureau(id);
    }

    public String updateBureau(){
        bureauTauxEtat.updateBureau(id, materialType, bonEtat);
        return "bureaux";
    }

    public float bureauTauxBonEtat(){ return bureauTauxEtat.tauxBonEtat(); }


    public List<Chaise> chaiseGetAll(){return chaiseTauxEtat.getAll();}

    public Chaise chaiseGetId() { return chaiseTauxEtat.getById(id); }

    public String chaiseCreate(){
        chaiseTauxEtat.createChaise(materialType, bonEtat);
        return "chaises";
    }

    public void chaiseDelete(long id){
        chaiseTauxEtat.deleteChaise(id);
    }

    public String updateChaise(){
        chaiseTauxEtat.updateChaise(id, materialType, bonEtat);
        return "chaises";
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String update(long id, String classe){
        setId(id);
        return classe;
    }
}
