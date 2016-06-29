/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Asignaturas;
import Entidad.Espacios;
import Entidad.Panoramas;
import Entidad.Profesores;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Estudio
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    public List<Asignaturas> findAsignaturas(Object id) {
        return getEntityManager().createNamedQuery("getAsignaturasById").setParameter("idprofesor", id).getResultList();
    }
    public List<Profesores> findProfesores(Object id) {
        return getEntityManager().createNamedQuery("getProfesoresById").setParameter("idasignatura", id).getResultList();
    }
    
    
    public List<Panoramas> findPano(Object id) {
        List<Panoramas> panos = getEntityManager().createNamedQuery("findPanoramasByIdespacio").setParameter("idespacio", id).getResultList();
        List<Panoramas> al = new ArrayList<Panoramas>();
        
        for (Panoramas p : panos){
            Panoramas aux = new Panoramas();
            aux.setPanorama(p.getPanorama());
            al.add(aux);
            //System.out.println(p.getPanorama());
        }
        return al;
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    public List<Espacios> espacioByPiso(String id) {
        return getEntityManager().createNamedQuery("Espacios.findByPiso").setParameter("piso", id).getResultList();
    }
    public List<Profesores> findAllProfesors() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        List<Profesores> profesores = getEntityManager().createQuery(cq).getResultList();
        List<Profesores> profesores2 = new ArrayList<Profesores>();
      
        for (Profesores p : profesores){
            Profesores aux = new Profesores();
            //System.out.println(p.getVisibilidad());
            if(p.getVisibilidad().equals("0")){
                aux.setNombre(p.getNombre());
                aux.setIdprofesor(p.getIdprofesor());
                aux.setVisibilidad("0");
                profesores2.add(aux);
            }
            else{
                profesores2.add(p);
            }
        }
        return profesores2;
    }
    public List<Espacios> findAllEspacios() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        List<Espacios> espacios = getEntityManager().createQuery(cq).getResultList();
        List<Espacios> espacios2 = new ArrayList<Espacios>();
        //Espacios e = null;
        for (Espacios e : espacios){
            Espacios aux = new Espacios();
            if(e.getVisibilidad().equals("0")){
                aux.setIdespacio(e.getIdespacio());
                aux.setNombre(e.getNombre());
                aux.setVisibilidad("0");
                espacios2.add(aux);
            }
            else{
                espacios2.add(e);
            }
        }
        return espacios2;
    }

    
    public Profesores findProfesor(Object id) {
        Profesores profesor = (Profesores) getEntityManager().find(entityClass, id);
        Profesores aux = new Profesores();
         
        if (profesor.getVisibilidad().equals("0")){
            aux.setNombre(profesor.getNombre());
            aux.setIdprofesor(profesor.getIdprofesor());
            aux.setVisibilidad("0");
        }
        else{
            aux = (Profesores) getEntityManager().find(entityClass, id);
        }
        return aux;
    }
    public Espacios findEspacio(Object id) {
        Espacios espacio = (Espacios) getEntityManager().find(entityClass, id);
        Espacios aux = new Espacios();
         
        if (espacio.getVisibilidad().equals("0")){
            aux.setNombre(espacio.getNombre());
            aux.setIdespacio(espacio.getIdespacio());
            aux.setVisibilidad("0");
        }
        else{
            aux = (Espacios) getEntityManager().find(entityClass, id);
        }
        
        
        return aux;
    }
    
}
