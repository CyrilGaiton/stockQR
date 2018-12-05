package fr.utln.ancy;

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

    public Bureau getById(int id){ return bureauDAO.getById(id); }

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
}
