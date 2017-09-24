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
@Table(name = "livro_autor", catalog = "ebooks", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LivroAutor.findAll", query = "SELECT l FROM LivroAutor l")
    , @NamedQuery(name = "LivroAutor.findById", query = "SELECT l FROM LivroAutor l WHERE l.id = :id")
    , @NamedQuery(name = "LivroAutor.findByPrincipal", query = "SELECT l FROM LivroAutor l WHERE l.principal = :principal")
    , @NamedQuery(name = "LivroAutor.findByCriadoEm", query = "SELECT l FROM LivroAutor l WHERE l.criadoEm = :criadoEm")})
public class LivroAutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2)
    @Column(name = "principal")
    private String principal;
    @Column(name = "criado_em")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criadoEm;
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    @ManyToOne
    private Autor autorId;
    @JoinColumn(name = "livro_id", referencedColumnName = "id")
    @ManyToOne
    private Livro livroId;
    @JoinColumn(name = "criado_por", referencedColumnName = "id")
    @ManyToOne
    private Usuario criadoPor;

    public LivroAutor() {
    }

    public LivroAutor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Autor getAutorId() {
        return autorId;
    }

    public void setAutorId(Autor autorId) {
        this.autorId = autorId;
    }

    public Livro getLivroId() {
        return livroId;
    }

    public void setLivroId(Livro livroId) {
        this.livroId = livroId;
    }

    public Usuario getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(Usuario criadoPor) {
        this.criadoPor = criadoPor;
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
        if (!(object instanceof LivroAutor)) {
            return false;
        }
        LivroAutor other = (LivroAutor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LivroAutor{" + "id=" + id + ", principal=" + principal + ", criadoEm=" + criadoEm + ", autorId=" + autorId + ", livroId=" + livroId + ", criadoPor=" + criadoPor + '}';
    }

}
