package fr.utln.ancy;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@SessionScoped
public class TestBackingBean {
    @Inject
    TableBean tableBean;

    public List<Table> TableGetAll(){
        return tableBean.getAll();
    }
}
