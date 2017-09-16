package br.com.fatec.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Fornecedor extends EntidadeDominio implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private boolean ativo;
	private String cnpj;
	private String IE;
	private String CI;
	private Calendar dataFundacao;
	@Version
	@Column(unique=true)
	private long versao;
	@Embedded
	private Endereco endereco;
	@ManyToMany
	private List<Categoria> categoria;
	@ManyToOne
	private HistoricoFornecedor historicoFornecedor;
	
	public HistoricoFornecedor getHistoricoFornecedor() {
		return historicoFornecedor;
	}
	public void setHistoricoFornecedor(HistoricoFornecedor historicoFornecedor) {
		this.historicoFornecedor = historicoFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getIE() {
		return IE;
	}
	public void setIE(String iE) {
		IE = iE;
	}
	public String getCI() {
		return CI;
	}
	public void setCI(String cI) {
		CI = cI;
	}
	public Calendar getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Categoria> getCategoria() {
		return categoria;
	}
	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getVersao() {
		return versao;
	}
	public void setVersao(long versao) {
		this.versao = versao;
	}
	
	
	
}
