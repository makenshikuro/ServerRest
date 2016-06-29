/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Estudio
 */
@Embeddable
public class PanoramasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IDESPACIO")
    private String idespacio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "IDPANORAMA")
    private String idpanorama;

    public PanoramasPK() {
    }

    public PanoramasPK(String idespacio, String idpanorama) {
        this.idespacio = idespacio;
        this.idpanorama = idpanorama;
    }

    public String getIdespacio() {
        return idespacio;
    }

    public void setIdespacio(String idespacio) {
        this.idespacio = idespacio;
    }

    public String getIdpanorama() {
        return idpanorama;
    }

    public void setIdpanorama(String idpanorama) {
        this.idpanorama = idpanorama;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespacio != null ? idespacio.hashCode() : 0);
        hash += (idpanorama != null ? idpanorama.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PanoramasPK)) {
            return false;
        }
        PanoramasPK other = (PanoramasPK) object;
        if ((this.idespacio == null && other.idespacio != null) || (this.idespacio != null && !this.idespacio.equals(other.idespacio))) {
            return false;
        }
        if ((this.idpanorama == null && other.idpanorama != null) || (this.idpanorama != null && !this.idpanorama.equals(other.idpanorama))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.PanoramasPK[ idespacio=" + idespacio + ", idpanorama=" + idpanorama + " ]";
    }
    
}
