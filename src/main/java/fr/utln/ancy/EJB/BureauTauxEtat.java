package fr.utln.ancy.EJB;

import fr.utln.ancy.Beans.Bureau;
import fr.utln.ancy.DAO.BureauDAO;
import fr.utln.ancy.MaterialType;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BureauTauxEtat {
    @Inject
    private BureauDAO bureauDAO;

    public List<Bureau> getAll(){
        return bureauDAO.getAll();
    }

    public Bureau getById(long id){ return bureauDAO.getById(id); }

    public float tauxBonEtat(){
        List<Bureau> bureaux = getAll();
        float count = 0;
        for (Bureau bureau : bureaux) {
            if (bureau.isBonEtat()){
                count++;
            }
        }
        return ((count/ bureaux.size())*100);
    }

    public void createBureau(MaterialType materialType, boolean bonEtat){
        bureauDAO.createBureau(materialType, bonEtat);
    }

    public void deleteBureau(long id){
        bureauDAO.deleteBureau(id);
    }

    public void updateBureau(long id, MaterialType material, boolean bonEtat){
        bureauDAO.updateBureau(id, material, bonEtat);
    }
}
