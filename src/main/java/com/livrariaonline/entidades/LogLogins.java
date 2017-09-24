/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livrariaonline.entidades;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexander.Silva
 */
@Entity
@Table(name = "log_logins", catalog = "ebooks", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogLogins.findAll", query = "SELECT l FROM LogLogins l")
    , @NamedQuery(name = "LogLogins.findById", query = "SELECT l FROM LogLogins l WHERE l.id = :id")
    , @NamedQuery(name = "LogLogins.findBySucesso", query = "SELECT l FROM LogLogins l WHERE l.sucesso = :sucesso")
    , @NamedQuery(name = "LogLogins.findByIp", query = "SELECT l FROM LogLogins l WHERE l.ip = :ip")
    , @NamedQuery(name = "LogLogins.findByDataHora", query = "SELECT l FROM LogLogins l WHERE l.dataHora = :dataHora")})
public class LogLogins implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sucesso")
    private Short sucesso;
    @Size(max = 50)
    @Column(name = "ip")
    private String ip;
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioId;

    public LogLogins() {
    }

    public LogLogins(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getSucesso() {
        return sucesso;
    }

    public void setSucesso(Short sucesso) {
        this.sucesso = sucesso;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogLogins)) {
            return false;
        }
        LogLogins other = (LogLogins) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LogLogins{" + "id=" + id + ", sucesso=" + sucesso + ", ip=" + ip + ", dataHora=" + dataHora + ", usuarioId=" + usuarioId + '}';
    }

}
