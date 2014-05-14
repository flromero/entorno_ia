/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.persitencia;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clubjava
 */
@Entity
@Table(name = "PARTICIPACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participacion.findAll", query = "SELECT p FROM Participacion p"),
    @NamedQuery(name = "Participacion.findByIdParticipacion", query = "SELECT p FROM Participacion p WHERE p.idParticipacion = :idParticipacion"),
    @NamedQuery(name = "Participacion.findByHora", query = "SELECT p FROM Participacion p WHERE p.hora = :hora"),
    @NamedQuery(name = "Participacion.findByFechaClase", query = "SELECT p FROM Participacion p WHERE p.fechaClase = :fechaClase")})
public class Participacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PARTICIPACION")
    private Integer idParticipacion;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "FECHA_CLASE")
    @Temporal(TemporalType.DATE)
    private Date fechaClase;
    @JoinColumn(name = "ID_CLASE", referencedColumnName = "ID_CLASE")
    @ManyToOne
    private Clase idClase;

    public Participacion() {
    }

    public Participacion(Integer idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public Integer getIdParticipacion() {
        return idParticipacion;
    }

    public void setIdParticipacion(Integer idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(Date fechaClase) {
        this.fechaClase = fechaClase;
    }

    public Clase getIdClase() {
        return idClase;
    }

    public void setIdClase(Clase idClase) {
        this.idClase = idClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParticipacion != null ? idParticipacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participacion)) {
            return false;
        }
        Participacion other = (Participacion) object;
        if ((this.idParticipacion == null && other.idParticipacion != null) || (this.idParticipacion != null && !this.idParticipacion.equals(other.idParticipacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.persitencia.Participacion[ idParticipacion=" + idParticipacion + " ]";
    }
    
}
