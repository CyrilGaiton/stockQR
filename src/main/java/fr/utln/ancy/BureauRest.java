package fr.utln.ancy;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bureaux/")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class BureauRest {

    @Inject
    private BureauDAO bureauDAO;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bureau getById(@PathParam("id") int id){
        return bureauDAO.getById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bureau> getAll(){
        return bureauDAO.getAll();
    }

    @POST
    @Path("/addBureau")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBureau(Bureau bureau){
        if (bureau != null){
            bureauDAO.createBureau(bureau.getMaterial(), bureau.isBonEtat());
        }
    }
}
