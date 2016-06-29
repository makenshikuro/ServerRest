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
@Table(name = "PROFESORASIGNATURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesorasignatura.findAll", query = "SELECT p FROM Profesorasignatura p"),
    @NamedQuery(name = "Profesorasignatura.findByIdprofesor", query = "SELECT p FROM Profesorasignatura p WHERE p.profesorasignaturaPK.idprofesor = :idprofesor"),
    @NamedQuery(name = "Profesorasignatura.findByIdasignatura", query = "SELECT p FROM Profesorasignatura p WHERE p.profesorasignaturaPK.idasignatura = :idasignatura"),
    @NamedQuery(name = "Profesorasignatura.findBySituacion", query = "SELECT p FROM Profesorasignatura p WHERE p.situacion = :situacion")})
public class Profesorasignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfesorasignaturaPK profesorasignaturaPK;
    @Size(max = 20)
    @Column(name = "SITUACION")
    private String situacion;
    @JoinColumn(name = "IDASIGNATURA", referencedColumnName = "IDASIGNATURA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Asignaturas asignaturas;
    @JoinColumn(name = "IDPROFESOR", referencedColumnName = "IDPROFESOR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profesores profesores;

    public Profesorasignatura() {
    }

    public Profesorasignatura(ProfesorasignaturaPK profesorasignaturaPK) {
        this.profesorasignaturaPK = profesorasignaturaPK;
    }

    public Profesorasignatura(String idprofesor, String idasignatura) {
        this.profesorasignaturaPK = new ProfesorasignaturaPK(idprofesor, idasignatura);
    }

    public ProfesorasignaturaPK getProfesorasignaturaPK() {
        return profesorasignaturaPK;
    }

    public void setProfesorasignaturaPK(ProfesorasignaturaPK profesorasignaturaPK) {
        this.profesorasignaturaPK = profesorasignaturaPK;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Asignaturas getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Asignaturas asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Profesores getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesores profesores) {
        this.profesores = profesores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profesorasignaturaPK != null ? profesorasignaturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesorasignatura)) {
            return false;
        }
        Profesorasignatura other = (Profesorasignatura) object;
        if ((this.profesorasignaturaPK == null && other.profesorasignaturaPK != null) || (this.profesorasignaturaPK != null && !this.profesorasignaturaPK.equals(other.profesorasignaturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Profesorasignatura[ profesorasignaturaPK=" + profesorasignaturaPK + " ]";
    }
    
}
