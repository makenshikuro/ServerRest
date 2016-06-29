/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Estudio
 */
@Entity
@Table(name = "PANORAMAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Panoramas.findAll", query = "SELECT p FROM Panoramas p"),
    @NamedQuery(name = "findPanoramasByIdespacio", query = "SELECT p FROM Panoramas p WHERE p.panoramasPK.idespacio = :idespacio"),
    @NamedQuery(name = "Panoramas.findByIdpanorama", query = "SELECT p FROM Panoramas p WHERE p.panoramasPK.idpanorama = :idpanorama"),
    @NamedQuery(name = "Panoramas.findByPanorama", query = "SELECT p FROM Panoramas p WHERE p.panorama = :panorama")})
public class Panoramas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PanoramasPK panoramasPK;
    @Size(max = 20)
    @Column(name = "PANORAMA")
    private String panorama;
    @JoinColumn(name = "IDESPACIO", referencedColumnName = "IDESPACIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Espacios espacios;

    public Panoramas() {
    }

    public Panoramas(PanoramasPK panoramasPK) {
        this.panoramasPK = panoramasPK;
    }

    public Panoramas(String idespacio, String idpanorama) {
        this.panoramasPK = new PanoramasPK(idespacio, idpanorama);
    }

    public PanoramasPK getPanoramasPK() {
        return panoramasPK;
    }

    public void setPanoramasPK(PanoramasPK panoramasPK) {
        this.panoramasPK = panoramasPK;
    }

    public String getPanorama() {
        return panorama;
    }

    public void setPanorama(String panorama) {
        this.panorama = panorama;
    }

    public Espacios getEspacios() {
        return espacios;
    }

    public void setEspacios(Espacios espacios) {
        this.espacios = espacios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (panoramasPK != null ? panoramasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Panoramas)) {
            return false;
        }
        Panoramas other = (Panoramas) object;
        if ((this.panoramasPK == null && other.panoramasPK != null) || (this.panoramasPK != null && !this.panoramasPK.equals(other.panoramasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Panoramas[ panoramasPK=" + panoramasPK + " ]";
    }
    
}
