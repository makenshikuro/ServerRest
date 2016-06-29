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
@Table(name = "PROFESORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesores.findAll", query = "SELECT p FROM Profesores p"),
    @NamedQuery(name = "Profesores.findByIdprofesor", query = "SELECT p FROM Profesores p WHERE p.idprofesor = :idprofesor"),
    @NamedQuery(name = "getAsignaturasById", query = "select ASIG FROM Profesores pr JOIN PR.profesorasignaturaCollection PA JOIN PA.asignaturas ASIG WHERE PR.idprofesor =:idprofesor"),
    @NamedQuery(name = "Profesores.findByNombre", query = "SELECT p FROM Profesores p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Profesores.findByCorreo", query = "SELECT p FROM Profesores p WHERE p.correo = :correo"),
    @NamedQuery(name = "Profesores.findByFicha", query = "SELECT p FROM Profesores p WHERE p.ficha = :ficha"),
    @NamedQuery(name = "Profesores.findByVisibilidad", query = "SELECT p FROM Profesores p WHERE p.visibilidad = :visibilidad"),
    @NamedQuery(name = "Profesores.findByDepartamento", query = "SELECT p FROM Profesores p WHERE p.departamento = :departamento")})
public class Profesores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "IDPROFESOR")
    private String idprofesor;
    @Size(max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 40)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 120)
    @Column(name = "FICHA")
    private String ficha;
    @Size(max = 1)
    @Column(name = "VISIBILIDAD")
    private String visibilidad;
    @Lob
    @Column(name = "TUTORIAS")
    private String tutorias;
    @Size(max = 120)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @JoinColumn(name = "IDESPACIO", referencedColumnName = "IDESPACIO")
    @ManyToOne
    private Espacios idespacio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesores")
    private Collection<Profesorasignatura> profesorasignaturaCollection;

    public Profesores() {
    }

    public Profesores(String idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(String idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String getTutorias() {
        return tutorias;
    }

    public void setTutorias(String tutorias) {
        this.tutorias = tutorias;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Espacios getIdespacio() {
        return idespacio;
    }

    public void setIdespacio(Espacios idespacio) {
        this.idespacio = idespacio;
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
        hash += (idprofesor != null ? idprofesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesores)) {
            return false;
        }
        Profesores other = (Profesores) object;
        if ((this.idprofesor == null && other.idprofesor != null) || (this.idprofesor != null && !this.idprofesor.equals(other.idprofesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Profesores[ idprofesor=" + idprofesor + " ]";
    }
    
}
