/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.tolback.xmockups.ServiciosAdicionales;
import com.tolback.xmockups.ServiciosAdicionalesPK;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.PathSegment;
import java.util.List;

/**
 *
 * @author GPG
 */
@Stateless
@Path("com.tolback.xmockups.serviciosadicionales")
public class ServiciosAdicionalesFacadeREST extends AbstractFacade<ServiciosAdicionales> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private ServiciosAdicionalesPK getPrimaryKey(jakarta.ws.rs.core.PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idServicio=idServicioValue;idAlojamiento=idAlojamientoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.tolback.xmockups.ServiciosAdicionalesPK key = new com.tolback.xmockups.ServiciosAdicionalesPK(); /*
         * TODO: put your code here to build a primary key instance.
         * See below the possible algorithm to do it.
         */
        return key;
    }

    public ServiciosAdicionalesFacadeREST() {
        super(ServiciosAdicionales.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ServiciosAdicionales entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, ServiciosAdicionales entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.tolback.xmockups.ServiciosAdicionalesPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ServiciosAdicionales find(@PathParam("id") PathSegment id) {
        com.tolback.xmockups.ServiciosAdicionalesPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ServiciosAdicionales> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ServiciosAdicionales> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
