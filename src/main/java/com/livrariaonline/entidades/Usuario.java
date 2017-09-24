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
@Table(name = "usuario", catalog = "ebooks", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuario.findBySobrenome", query = "SELECT u FROM Usuario u WHERE u.sobrenome = :sobrenome")
    , @NamedQuery(name = "Usuario.findByCpf", query = "SELECT u FROM Usuario u WHERE u.cpf = :cpf")
    , @NamedQuery(name = "Usuario.findByNascimento", query = "SELECT u FROM Usuario u WHERE u.nascimento = :nascimento")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.findByAdmin", query = "SELECT u FROM Usuario u WHERE u.admin = :admin")
    , @NamedQuery(name = "Usuario.findByAdicionadoEm", query = "SELECT u FROM Usuario u WHERE u.adicionadoEm = :adicionadoEm")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 150)
    @Column(name = "nome")
    private String nome;
    @Size(max = 150)
    @Column(name = "sobrenome")
    private String sobrenome;
    @Size(max = 150)
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "senha")
    private String senha;
    @Size(max = 2)
    @Column(name = "admin")
    private String admin;
    @Column(name = "adicionado_em")
    @Temporal(TemporalType.TIMESTAMP)
    private Date adicionadoEm;
    @OneToMany(mappedBy = "criadoPor")
    private List<LivroCategoria> livroCategoriaList;
    @OneToMany(mappedBy = "criadoPor")
    private List<LivroAutor> livroAutorList;
    @OneToMany(mappedBy = "criadoPor")
    private List<Livro> livroList;
    @OneToMany(mappedBy = "criadoPor")
    private List<Categoria> categoriaList;
    @OneToMany(mappedBy = "criadoPor")
    private List<Fornecedor> fornecedorList;
    @OneToMany(mappedBy = "criadoPor")
    private List<Editora> editoraList;
    @OneToMany(mappedBy = "usuarioId")
    private List<LivroMovimentacoes> livroMovimentacoesList;
    @OneToMany(mappedBy = "usuarioId")
    private List<LogLogins> logLoginsList;
    @OneToMany(mappedBy = "criadoPor")
    private List<Autor> autorList;

    public Usuario() {
    }

    public Usuario(Integer id) {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public Date getAdicionadoEm() {
        return adicionadoEm;
    }

    public void setAdicionadoEm(Date adicionadoEm) {
        this.adicionadoEm = adicionadoEm;
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

    @XmlTransient
    public List<Livro> getLivroList() {
        return livroList;
    }

    public void setLivroList(List<Livro> livroList) {
        this.livroList = livroList;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    @XmlTransient
    public List<Fornecedor> getFornecedorList() {
        return fornecedorList;
    }

    public void setFornecedorList(List<Fornecedor> fornecedorList) {
        this.fornecedorList = fornecedorList;
    }

    @XmlTransient
    public List<Editora> getEditoraList() {
        return editoraList;
    }

    public void setEditoraList(List<Editora> editoraList) {
        this.editoraList = editoraList;
    }

    @XmlTransient
    public List<LivroMovimentacoes> getLivroMovimentacoesList() {
        return livroMovimentacoesList;
    }

    public void setLivroMovimentacoesList(List<LivroMovimentacoes> livroMovimentacoesList) {
        this.livroMovimentacoesList = livroMovimentacoesList;
    }

    @XmlTransient
    public List<LogLogins> getLogLoginsList() {
        return logLoginsList;
    }

    public void setLogLoginsList(List<LogLogins> logLoginsList) {
        this.logLoginsList = logLoginsList;
    }

    @XmlTransient
    public List<Autor> getAutorList() {
        return autorList;
    }

    public void setAutorList(List<Autor> autorList) {
        this.autorList = autorList;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", nascimento=" + nascimento + ", email=" + email + ", senha=" + senha + ", admin=" + admin + ", adicionadoEm=" + adicionadoEm + ", livroCategoriaList=" + livroCategoriaList + ", livroAutorList=" + livroAutorList + ", livroList=" + livroList + ", categoriaList=" + categoriaList + ", fornecedorList=" + fornecedorList + ", editoraList=" + editoraList + ", livroMovimentacoesList=" + livroMovimentacoesList + ", logLoginsList=" + logLoginsList + ", autorList=" + autorList + '}';
    }

}
