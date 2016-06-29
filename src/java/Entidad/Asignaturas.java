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
@Table(name = "ASIGNATURAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignaturas.findAll", query = "SELECT a FROM Asignaturas a"),
    @NamedQuery(name = "Asignaturas.findByIdasignatura", query = "SELECT a FROM Asignaturas a WHERE a.idasignatura = :idasignatura"),
    @NamedQuery(name = "Asignaturas.findByNombre", query = "SELECT a FROM Asignaturas a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "getProfesoresById", query = "select pr FROM Asignaturas ASIG JOIN ASIG.profesorasignaturaCollection PA JOIN PA.profesores pr WHERE ASIG.idasignatura =:idasignatura"),
    @NamedQuery(name = "Asignaturas.findByNombreEs", query = "SELECT a FROM Asignaturas a WHERE a.nombreEs = :nombreEs"),
    @NamedQuery(name = "Asignaturas.findByNombreEn", query = "SELECT a FROM Asignaturas a WHERE a.nombreEn = :nombreEn")})
public class Asignaturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "IDASIGNATURA")
    private String idasignatura;
    @Size(max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 40)
    @Column(name = "NOMBRE_ES")
    private String nombreEs;
    @Size(max = 40)
    @Column(name = "NOMBRE_EN")
    private String nombreEn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignaturas")
    private Collection<Profesorasignatura> profesorasignaturaCollection;

    public Asignaturas() {
    }

    public Asignaturas(String idasignatura) {
        this.idasignatura = idasignatura;
    }

    public String getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(String idasignatura) {
        this.idasignatura = idasignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEs() {
        return nombreEs;
    }

    public void setNombreEs(String nombreEs) {
        this.nombreEs = nombreEs;
    }

    public String getNombreEn() {
        return nombreEn;
    }

    public void setNombreEn(String nombreEn) {
        this.nombreEn = nombreEn;
    }

    @XmlTransient
    public Collection<Profesorasignatura> getProfesorasignaturaCollection() {
        return profesorasignaturaCollection;
    }

    public void setProfesorasignaturaCollection(Collection<Profesorasignatura> profesorasignaturaCollection) {
        this.profesorasignaturaCollection = profesorasignaturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasignatura != null ? idasignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaturas)) {
            return false;
        }
        Asignaturas other = (Asignaturas) object;
        if ((this.idasignatura == null && other.idasignatura != null) || (this.idasignatura != null && !this.idasignatura.equals(other.idasignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Asignaturas[ idasignatura=" + idasignatura + " ]";
    }
    
}
