package fr.utln.ancy;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/chaises")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class ChaiseRest {

    @Inject
    private ChaiseDAO chaiseDAO;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Chaise getById(@PathParam("id") long id){
        return chaiseDAO.getById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chaise> getAll(){
        return chaiseDAO.getAll();
    }

    @POST
    @Path("/addChaise")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createChaise(Chaise chaise){
        if (chaise != null){
            chaiseDAO.createChaise(chaise.getMaterial(), chaise.isBonEtat());
        }
    }

    @DELETE
    @Path("/deleteChaise/{id}")
    public void deleteChaise(@PathParam("id") long id){
        chaiseDAO.deleteChaise(id);
    }

    @PUT
    @Path("/updateChaise/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateChaise(@PathParam("id") long id, Chaise chaise){
        if (chaise != null){
            chaiseDAO.updateChaise(id,  chaise.getMaterial(), chaise.isBonEtat());
        }
    }
}
