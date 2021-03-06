/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Asignaturas;
import Entidad.Profesores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Estudio
 */
@Stateless
@Path("profesores")
public class ProfesoresFacadeREST extends AbstractFacade<Profesores> {

    @PersistenceContext(unitName = "ServerRestPU")
    private EntityManager em;

    public ProfesoresFacadeREST() {
        super(Profesores.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Profesores entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Profesores entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Profesores find(@PathParam("id") String id) {
        return super.findProfesor(id);
    }

    @GET
    @Override
    @Produces( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profesores> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("{id}/asignaturas")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Asignaturas> Asignaturas(@PathParam("id") String id) {
        return super.findAsignaturas(id);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profesores> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
