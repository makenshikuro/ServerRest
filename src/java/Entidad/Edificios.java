/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "EDIFICIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edificios.findAll", query = "SELECT e FROM Edificios e"),
    @NamedQuery(name = "Edificios.findByIdedificio", query = "SELECT e FROM Edificios e WHERE e.idedificio = :idedificio"),
    @NamedQuery(name = "Edificios.findByNombre", query = "SELECT e FROM Edificios e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Edificios.findByDireccion", query = "SELECT e FROM Edificios e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Edificios.findByTelefono", query = "SELECT e FROM Edificios e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Edificios.findByEnlace", query = "SELECT e FROM Edificios e WHERE e.enlace = :enlace"),
    @NamedQuery(name = "Edificios.findByChano", query = "SELECT e FROM Edificios e WHERE e.chano = :chano")})
public class Edificios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "IDEDIFICIO")
    private String idedificio;
    @Size(max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 80)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 30)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 120)
    @Column(name = "ENLACE")
    private String enlace;
    @Size(max = 50)
    @Column(name = "CHANO")
    private String chano;
    @OneToMany(mappedBy = "idedificio")
    private Collection<Espacios> espaciosCollection;
    @JoinColumn(name = "IDCOORDENADA", referencedColumnName = "IDCOORDENADA")
    @ManyToOne(optional = false)
    private Coordenadas idcoordenada;

    public Edificios() {
    }

    public Edificios(String idedificio) {
        this.idedificio = idedificio;
    }

    public String getIdedificio() {
        return idedificio;
    }

    public void setIdedificio(String idedificio) {
        this.idedificio = idedificio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getChano() {
        return chano;
    }

    public void setChano(String chano) {
        this.chano = chano;
    }

    @XmlTransient
    public Collection<Espacios> getEspaciosCollection() {
        return espaciosCollection;
    }

    public void setEspaciosCollection(Collection<Espacios> espaciosCollection) {
        this.espaciosCollection = espaciosCollection;
    }

    public Coordenadas getIdcoordenada() {
        return idcoordenada;
    }

    public void setIdcoordenada(Coordenadas idcoordenada) {
        this.idcoordenada = idcoordenada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idedificio != null ? idedificio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edificios)) {
            return false;
        }
        Edificios other = (Edificios) object;
        if ((this.idedificio == null && other.idedificio != null) || (this.idedificio != null && !this.idedificio.equals(other.idedificio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Edificios[ idedificio=" + idedificio + " ]";
    }
    
}
