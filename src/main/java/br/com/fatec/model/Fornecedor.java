package br.com.fatec.model;

import java.util.Calendar;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class Fornecedor extends EntidadeDominio{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private boolean ativo = true;
	private String cnpj;
	private String IE;
	private String CI;
	private Calendar dataFundacao;
	@Embedded
	private Endereco endereco;
	@ManyToOne
	@Cascade(value = {CascadeType.ALL, CascadeType.DELETE, CascadeType.PERSIST})
	private Categoria categoria;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
			
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome "  + getNome() + "\nCNPJ " + getCnpj() + "\nCI " + getCI();
	}
	
}
