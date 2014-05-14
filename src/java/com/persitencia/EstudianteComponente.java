/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.persitencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clubjava
 */
@Entity
@Table(name = "estudiante_componente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstudianteComponente.findAll", query = "SELECT e FROM EstudianteComponente e"),
    @NamedQuery(name = "EstudianteComponente.findByIdEstcomp", query = "SELECT e FROM EstudianteComponente e WHERE e.idEstcomp = :idEstcomp"),
    @NamedQuery(name = "EstudianteComponente.findByIdUsuario", query = "SELECT e FROM EstudianteComponente e WHERE e.idUsuario = :idUsuario")})
public class EstudianteComponente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estcomp")
    private Integer idEstcomp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;

    public EstudianteComponente() {
    }

    public EstudianteComponente(Integer idEstcomp) {
        this.idEstcomp = idEstcomp;
    }

    public EstudianteComponente(Integer idEstcomp, int idUsuario) {
        this.idEstcomp = idEstcomp;
        this.idUsuario = idUsuario;
    }

    public Integer getIdEstcomp() {
        return idEstcomp;
    }

    public void setIdEstcomp(Integer idEstcomp) {
        this.idEstcomp = idEstcomp;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstcomp != null ? idEstcomp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteComponente)) {
            return false;
        }
        EstudianteComponente other = (EstudianteComponente) object;
        if ((this.idEstcomp == null && other.idEstcomp != null) || (this.idEstcomp != null && !this.idEstcomp.equals(other.idEstcomp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.persitencia.EstudianteComponente[ idEstcomp=" + idEstcomp + " ]";
    }
    
}
