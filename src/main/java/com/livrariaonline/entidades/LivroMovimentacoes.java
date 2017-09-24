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
@Table(name = "livro_movimentacoes", catalog = "ebooks", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LivroMovimentacoes.findAll", query = "SELECT l FROM LivroMovimentacoes l")
    , @NamedQuery(name = "LivroMovimentacoes.findById", query = "SELECT l FROM LivroMovimentacoes l WHERE l.id = :id")
    , @NamedQuery(name = "LivroMovimentacoes.findByQuantidade", query = "SELECT l FROM LivroMovimentacoes l WHERE l.quantidade = :quantidade")
    , @NamedQuery(name = "LivroMovimentacoes.findByEntradaSaida", query = "SELECT l FROM LivroMovimentacoes l WHERE l.entradaSaida = :entradaSaida")
    , @NamedQuery(name = "LivroMovimentacoes.findByDataHora", query = "SELECT l FROM LivroMovimentacoes l WHERE l.dataHora = :dataHora")})
public class LivroMovimentacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Size(max = 2)
    @Column(name = "entrada_saida")
    private String entradaSaida;
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @JoinColumn(name = "fornecedor_id", referencedColumnName = "id")
    @ManyToOne
    private Fornecedor fornecedorId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioId;

    public LivroMovimentacoes() {
    }

    public LivroMovimentacoes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getEntradaSaida() {
        return entradaSaida;
    }

    public void setEntradaSaida(String entradaSaida) {
        this.entradaSaida = entradaSaida;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Fornecedor getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Fornecedor fornecedorId) {
        this.fornecedorId = fornecedorId;
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
        if (!(object instanceof LivroMovimentacoes)) {
            return false;
        }
        LivroMovimentacoes other = (LivroMovimentacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LivroMovimentacoes{" + "id=" + id + ", quantidade=" + quantidade + ", entradaSaida=" + entradaSaida + ", dataHora=" + dataHora + ", fornecedorId=" + fornecedorId + ", usuarioId=" + usuarioId + '}';
    }

}
