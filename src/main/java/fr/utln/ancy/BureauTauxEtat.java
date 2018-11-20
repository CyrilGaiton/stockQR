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

    public int tauxBonEtat(){
        List<Bureau> bureaus = getAll();
        int count = 0;
        for (Bureau bureau : bureaus) {
            if (bureau.isBonEtat()){
                count++;
            }
        }
        return ((count/ bureaus.size())*100);
    }
}
