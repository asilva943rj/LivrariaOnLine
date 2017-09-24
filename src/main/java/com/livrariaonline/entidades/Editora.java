/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livrariaonline.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexander.Silva
 */
@Entity
@Table(name = "editora", catalog = "ebooks", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editora.findAll", query = "SELECT e FROM Editora e")
    , @NamedQuery(name = "Editora.findById", query = "SELECT e FROM Editora e WHERE e.id = :id")
    , @NamedQuery(name = "Editora.findByNome", query = "SELECT e FROM Editora e WHERE e.nome = :nome")
    , @NamedQuery(name = "Editora.findBySite", query = "SELECT e FROM Editora e WHERE e.site = :site")
    , @NamedQuery(name = "Editora.findByCriadoEm", query = "SELECT e FROM Editora e WHERE e.criadoEm = :criadoEm")})
public class Editora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "site")
    private String site;
    @Column(name = "criado_em")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criadoEm;
    @OneToMany(mappedBy = "editoraId")
    private List<Livro> livroList;
    @JoinColumn(name = "criado_por", referencedColumnName = "id")
    @ManyToOne
    private Usuario criadoPor;

    public Editora() {
    }

    public Editora(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    @XmlTransient
    public List<Livro> getLivroList() {
        return livroList;
    }

    public void setLivroList(List<Livro> livroList) {
        this.livroList = livroList;
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
        if (!(object instanceof Editora)) {
            return false;
        }
        Editora other = (Editora) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Editora{" + "id=" + id + ", nome=" + nome + ", site=" + site + ", criadoEm=" + criadoEm + ", livroList=" + livroList + ", criadoPor=" + criadoPor + '}';
    }

}
