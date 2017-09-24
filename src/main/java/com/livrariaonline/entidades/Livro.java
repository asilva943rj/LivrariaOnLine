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
@Table(name = "livro", catalog = "ebooks", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l")
    , @NamedQuery(name = "Livro.findById", query = "SELECT l FROM Livro l WHERE l.id = :id")
    , @NamedQuery(name = "Livro.findByNome", query = "SELECT l FROM Livro l WHERE l.nome = :nome")
    , @NamedQuery(name = "Livro.findByTraducao", query = "SELECT l FROM Livro l WHERE l.traducao = :traducao")
    , @NamedQuery(name = "Livro.findByPaginas", query = "SELECT l FROM Livro l WHERE l.paginas = :paginas")
    , @NamedQuery(name = "Livro.findByPreco", query = "SELECT l FROM Livro l WHERE l.preco = :preco")
    , @NamedQuery(name = "Livro.findByFotoCapa", query = "SELECT l FROM Livro l WHERE l.fotoCapa = :fotoCapa")
    , @NamedQuery(name = "Livro.findByDataPublicacao", query = "SELECT l FROM Livro l WHERE l.dataPublicacao = :dataPublicacao")
    , @NamedQuery(name = "Livro.findByCriadoEm", query = "SELECT l FROM Livro l WHERE l.criadoEm = :criadoEm")})
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "traducao")
    private String traducao;
    @Column(name = "paginas")
    private Integer paginas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Float preco;
    @Size(max = 50)
    @Column(name = "foto_capa")
    private String fotoCapa;
    @Column(name = "data_publicacao")
    @Temporal(TemporalType.DATE)
    private Date dataPublicacao;
    @Column(name = "criado_em")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criadoEm;
    @OneToMany(mappedBy = "livroId")
    private List<LivroCategoria> livroCategoriaList;
    @OneToMany(mappedBy = "livroId")
    private List<LivroAutor> livroAutorList;
    @JoinColumn(name = "editora_id", referencedColumnName = "id")
    @ManyToOne
    private Editora editoraId;
    @JoinColumn(name = "criado_por", referencedColumnName = "id")
    @ManyToOne
    private Usuario criadoPor;

    public Livro() {
    }

    public Livro(Integer id) {
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

    public String getTraducao() {
        return traducao;
    }

    public void setTraducao(String traducao) {
        this.traducao = traducao;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getFotoCapa() {
        return fotoCapa;
    }

    public void setFotoCapa(String fotoCapa) {
        this.fotoCapa = fotoCapa;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    @XmlTransient
    public List<LivroCategoria> getLivroCategoriaList() {
        return livroCategoriaList;
    }

    public void setLivroCategoriaList(List<LivroCategoria> livroCategoriaList) {
        this.livroCategoriaList = livroCategoriaList;
    }

    @XmlTransient
    public List<LivroAutor> getLivroAutorList() {
        return livroAutorList;
    }

    public void setLivroAutorList(List<LivroAutor> livroAutorList) {
        this.livroAutorList = livroAutorList;
    }

    public Editora getEditoraId() {
        return editoraId;
    }

    public void setEditoraId(Editora editoraId) {
        this.editoraId = editoraId;
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
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", nome=" + nome + ", traducao=" + traducao + ", paginas=" + paginas + ", preco=" + preco + ", fotoCapa=" + fotoCapa + ", dataPublicacao=" + dataPublicacao + ", criadoEm=" + criadoEm + ", livroCategoriaList=" + livroCategoriaList + ", livroAutorList=" + livroAutorList + ", editoraId=" + editoraId + ", criadoPor=" + criadoPor + '}';
    }

}
