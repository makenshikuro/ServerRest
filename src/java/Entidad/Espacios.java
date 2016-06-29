/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Estudio
 */
@Entity
@Table(name = "ESPACIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espacios.findAll", query = "SELECT e FROM Espacios e"),
    @NamedQuery(name = "Espacios.findByIdespacio", query = "SELECT e FROM Espacios e WHERE e.idespacio = :idespacio"),
    @NamedQuery(name = "Espacios.findByNombre", query = "SELECT e FROM Espacios e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Espacios.findByDescripcion", query = "SELECT e FROM Espacios e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Espacios.findByTipo", query = "SELECT e FROM Espacios e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "Espacios.findByBloque", query = "SELECT e FROM Espacios e WHERE e.bloque = :bloque"),
    @NamedQuery(name = "Espacios.findByVisibilidad", query = "SELECT e FROM Espacios e WHERE e.visibilidad = :visibilidad"),
    @NamedQuery(name = "Espacios.findByPiso", query = "SELECT e FROM Espacios e WHERE e.piso = :piso")})
public class Espacios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IDESPACIO")
    private String idespacio;
    @Size(max = 90)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 90)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 20)
    @Column(name = "TIPO")
    private String tipo;
    @Size(max = 20)
    @Column(name = "BLOQUE")
    private String bloque;
    @Size(max = 1)
    @Column(name = "VISIBILIDAD")
    private String visibilidad;
    @Size(max = 1)
    @Column(name = "PISO")
    private String piso;
    @Lob
    @Column(name = "BOUNDINGBOX")
    private String boundingbox;
    @JoinColumn(name = "IDCOORDENADA", referencedColumnName = "IDCOORDENADA")
    @ManyToOne
    private Coordenadas idcoordenada;
    @JoinColumn(name = "IDEDIFICIO", referencedColumnName = "IDEDIFICIO")
    @ManyToOne
    private Edificios idedificio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espacios")
    private Collection<Panoramas> panoramasCollection;
    @OneToMany(mappedBy = "idespacio")
    private Collection<Profesores> profesoresCollection;

    public Espacios() {
    }

    public Espacios(String idespacio) {
        this.idespacio = idespacio;
    }

    public String getIdespacio() {
        return idespacio;
    }

    public void setIdespacio(String idespacio) {
        this.idespacio = idespacio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getBoundingbox() {
        return boundingbox;
    }

    public void setBoundingbox(String boundingbox) {
        this.boundingbox = boundingbox;
    }

    public Coordenadas getIdcoordenada() {
        return idcoordenada;
    }

    public void setIdcoordenada(Coordenadas idcoordenada) {
        this.idcoordenada = idcoordenada;
    }

    public Edificios getIdedificio() {
        return idedificio;
    }

    public void setIdedificio(Edificios idedificio) {
        this.idedificio = idedificio;
    }

    @XmlTransient
    public Collection<Panoramas> getPanoramasCollection() {
        return panoramasCollection;
    }

    public void setPanoramasCollection(Collection<Panoramas> panoramasCollection) {
        this.panoramasCollection = panoramasCollection;
    }

    @XmlTransient
    public Collection<Profesores> getProfesoresCollection() {
        return profesoresCollection;
    }

    public void setProfesoresCollection(Collection<Profesores> profesoresCollection) {
        this.profesoresCollection = profesoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespacio != null ? idespacio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espacios)) {
            return false;
        }
        Espacios other = (Espacios) object;
        if ((this.idespacio == null && other.idespacio != null) || (this.idespacio != null && !this.idespacio.equals(other.idespacio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Espacios[ idespacio=" + idespacio + " ]";
    }
    
}
