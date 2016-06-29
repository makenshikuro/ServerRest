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
public class ProfesorasignaturaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "IDPROFESOR")
    private String idprofesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "IDASIGNATURA")
    private String idasignatura;

    public ProfesorasignaturaPK() {
    }

    public ProfesorasignaturaPK(String idprofesor, String idasignatura) {
        this.idprofesor = idprofesor;
        this.idasignatura = idasignatura;
    }

    public String getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(String idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(String idasignatura) {
        this.idasignatura = idasignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofesor != null ? idprofesor.hashCode() : 0);
        hash += (idasignatura != null ? idasignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesorasignaturaPK)) {
            return false;
        }
        ProfesorasignaturaPK other = (ProfesorasignaturaPK) object;
        if ((this.idprofesor == null && other.idprofesor != null) || (this.idprofesor != null && !this.idprofesor.equals(other.idprofesor))) {
            return false;
        }
        if ((this.idasignatura == null && other.idasignatura != null) || (this.idasignatura != null && !this.idasignatura.equals(other.idasignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.ProfesorasignaturaPK[ idprofesor=" + idprofesor + ", idasignatura=" + idasignatura + " ]";
    }
    
}
