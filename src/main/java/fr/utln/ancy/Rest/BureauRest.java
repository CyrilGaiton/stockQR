package fr.utln.ancy.Rest;

import fr.utln.ancy.Beans.Bureau;
import fr.utln.ancy.DAO.BureauDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bureaux")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class BureauRest {

    @Inject
    private BureauDAO bureauDAO;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bureau getById(@PathParam("id") long id){
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

    @DELETE
    @Path("/deleteBureau/{id}")
    public void deleteBureau(@PathParam("id") long id){
        bureauDAO.deleteBureau(id);
    }

    @PUT
    @Path("/updateBureau/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBureau(@PathParam("id") long id, Bureau bureau){
        if (bureau != null){
            bureauDAO.updateBureau(id,  bureau.getMaterial(), bureau.isBonEtat());
        }
    }
}
