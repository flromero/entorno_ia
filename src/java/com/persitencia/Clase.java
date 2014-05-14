/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.persitencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author clubjava
 */
@Entity
@Table(name = "CLASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"),
    @NamedQuery(name = "Clase.findByTema", query = "SELECT c FROM Clase c WHERE c.tema = :tema"),
    @NamedQuery(name = "Clase.findBySemana", query = "SELECT c FROM Clase c WHERE c.semana = :semana"),
    @NamedQuery(name = "Clase.findByBimestre", query = "SELECT c FROM Clase c WHERE c.bimestre = :bimestre"),
    @NamedQuery(name = "Clase.findByFechaClase", query = "SELECT c FROM Clase c WHERE c.fechaClase = :fechaClase"),
    @NamedQuery(name = "Clase.findByCompetencias", query = "SELECT c FROM Clase c WHERE c.competencias = :competencias"),
    @NamedQuery(name = "Clase.findByActividad", query = "SELECT c FROM Clase c WHERE c.actividad = :actividad"),
    @NamedQuery(name = "Clase.findByContenido", query = "SELECT c FROM Clase c WHERE c.contenido = :contenido"),
    @NamedQuery(name = "Clase.findByRecurso", query = "SELECT c FROM Clase c WHERE c.recurso = :recurso"),
    @NamedQuery(name = "Clase.findByIdClase", query = "SELECT c FROM Clase c WHERE c.idClase = :idClase")})
public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TEMA")
    private String tema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "SEMANA")
    private String semana;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "BIMESTRE")
    private String bimestre;
    @Column(name = "FECHA_CLASE")
    @Temporal(TemporalType.DATE)
    private Date fechaClase;
    @Size(max = 1024)
    @Column(name = "COMPETENCIAS")
    private String competencias;
    @Size(max = 1024)
    @Column(name = "ACTIVIDAD")
    private String actividad;
    @Size(max = 1024)
    @Column(name = "CONTENIDO")
    private String contenido;
    @Size(max = 1024)
    @Column(name = "RECURSO")
    private String recurso;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLASE")
    private Integer idClase;
    @JoinColumn(name = "ID_COMPONENTE", referencedColumnName = "ID_COMPONENTE")
    @ManyToOne
    private Componente idComponente;
    @OneToMany(mappedBy = "idClase")
    private Collection<Evaluacion> evaluacionCollection;
    @OneToMany(mappedBy = "idClase")
    private Collection<Asistencia> asistenciaCollection;
    @OneToMany(mappedBy = "idClase")
    private Collection<Participacion> participacionCollection;

    public Clase() {
    }

    public Clase(Integer idClase) {
        this.idClase = idClase;
    }

    public Clase(Integer idClase, String tema, String semana, String bimestre) {
        this.idClase = idClase;
        this.tema = tema;
        this.semana = semana;
        this.bimestre = bimestre;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getSemana() {
        return semana;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public String getBimestre() {
        return bimestre;
    }

    public void setBimestre(String bimestre) {
        this.bimestre = bimestre;
    }

    public Date getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(Date fechaClase) {
        this.fechaClase = fechaClase;
    }

    public String getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String competencias) {
        this.competencias = competencias;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public Componente getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Componente idComponente) {
        this.idComponente = idComponente;
    }

    @XmlTransient
    public Collection<Evaluacion> getEvaluacionCollection() {
        return evaluacionCollection;
    }

    public void setEvaluacionCollection(Collection<Evaluacion> evaluacionCollection) {
        this.evaluacionCollection = evaluacionCollection;
    }

    @XmlTransient
    public Collection<Asistencia> getAsistenciaCollection() {
        return asistenciaCollection;
    }

    public void setAsistenciaCollection(Collection<Asistencia> asistenciaCollection) {
        this.asistenciaCollection = asistenciaCollection;
    }

    @XmlTransient
    public Collection<Participacion> getParticipacionCollection() {
        return participacionCollection;
    }

    public void setParticipacionCollection(Collection<Participacion> participacionCollection) {
        this.participacionCollection = participacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClase != null ? idClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.idClase == null && other.idClase != null) || (this.idClase != null && !this.idClase.equals(other.idClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.persitencia.Clase[ idClase=" + idClase + " ]";
    }
    
}
