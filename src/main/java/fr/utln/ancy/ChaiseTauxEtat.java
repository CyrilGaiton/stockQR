package fr.utln.ancy;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ChaiseTauxEtat {

    @Inject
    private ChaiseDAO chaiseDAO;

    public Chaise getById(int id){ return chaiseDAO.getById(id); }

    public List<Chaise> getAll(){ return chaiseDAO.getAll(); }

    public float tauxBonEtat(){
        List<Chaise> chaises = getAll();
        float count = 0;
        for (Chaise chaise:chaises) {
            if (chaise.isBonEtat()){
                count++;
            }
        }
        return ((count/chaises.size())*100);
    }

    public void createChaise(MaterialType materialType, boolean bonEtat){
        chaiseDAO.createChaise(materialType, bonEtat);
    }
}
