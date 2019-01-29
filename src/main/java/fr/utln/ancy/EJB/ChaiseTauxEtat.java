package fr.utln.ancy.EJB;

import fr.utln.ancy.Beans.Chaise;
import fr.utln.ancy.DAO.ChaiseDAO;
import fr.utln.ancy.MaterialType;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ChaiseTauxEtat {

    @Inject
    private ChaiseDAO chaiseDAO;

    public Chaise getById(long id){ return chaiseDAO.getById(id); }

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

    public void deleteChaise(long id){
        chaiseDAO.deleteChaise(id);
    }

    public void updateChaise(long id, MaterialType material, boolean bonEtat){
        chaiseDAO.updateChaise(id, material, bonEtat);
    }
}
