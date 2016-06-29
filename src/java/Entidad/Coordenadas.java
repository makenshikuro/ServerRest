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
@Table(name = "COORDENADAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordenadas.findAll", query = "SELECT c FROM Coordenadas c"),
    @NamedQuery(name = "Coordenadas.findByIdcoordenada", query = "SELECT c FROM Coordenadas c WHERE c.idcoordenada = :idcoordenada"),
    @NamedQuery(name = "Coordenadas.findByDescripcion", query = "SELECT c FROM Coordenadas c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Coordenadas.findByLatitud", query = "SELECT c FROM Coordenadas c WHERE c.latitud = :latitud"),
    @NamedQuery(name = "Coordenadas.findByLongitud", query = "SELECT c FROM Coordenadas c WHERE c.longitud = :longitud")})
public class Coordenadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IDCOORDENADA")
    private String idcoordenada;
    @Size(max = 40)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LATITUD")
    private String latitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LONGITUD")
    private String longitud;
    @OneToMany(mappedBy = "idcoordenada")
    private Collection<Espacios> espaciosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcoordenada")
    private Collection<Edificios> edificiosCollection;

    public Coordenadas() {
    }

    public Coordenadas(String idcoordenada) {
        this.idcoordenada = idcoordenada;
    }

    public Coordenadas(String idcoordenada, String latitud, String longitud) {
        this.idcoordenada = idcoordenada;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getIdcoordenada() {
        return idcoordenada;
    }

    public void setIdcoordenada(String idcoordenada) {
        this.idcoordenada = idcoordenada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @XmlTransient
    public Collection<Espacios> getEspaciosCollection() {
        return espaciosCollection;
    }

    public void setEspaciosCollection(Collection<Espacios> espaciosCollection) {
        this.espaciosCollection = espaciosCollection;
    }

    @XmlTransient
    public Collection<Edificios> getEdificiosCollection() {
        return edificiosCollection;
    }

    public void setEdificiosCollection(Collection<Edificios> edificiosCollection) {
        this.edificiosCollection = edificiosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcoordenada != null ? idcoordenada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordenadas)) {
            return false;
        }
        Coordenadas other = (Coordenadas) object;
        if ((this.idcoordenada == null && other.idcoordenada != null) || (this.idcoordenada != null && !this.idcoordenada.equals(other.idcoordenada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Coordenadas[ idcoordenada=" + idcoordenada + " ]";
    }
    
}
