package fr.utln.ancy;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class TestBackingBean {
    @Inject
    TableBean tableBean;

    public Table[] TableGetAll(){
        return tableBean.getAll();
    }
}
