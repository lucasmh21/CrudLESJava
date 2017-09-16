package br.com.fatec.util;

import java.util.List;

import br.com.fatec.model.EntidadeDominio;

public class Resultado {
	private String mensagemSimples;
	private List<String> mensagens;
	private List<EntidadeDominio> listaEntidade;
	public String getMensagemSimples() {
		return mensagemSimples;
	}
	public void setMensagemSimples(String mensagemSimples) {
		this.mensagemSimples = mensagemSimples;
	}
	public List<String> getMensagens() {
		return mensagens;
	}
	public void setMensagens(List<String> mensagens) {
		this.mensagens = mensagens;
	}
	public List<EntidadeDominio> getListaEntidade() {
		return listaEntidade;
	}
	public void setListaEntidade(List<EntidadeDominio> listaEntidade) {
		this.listaEntidade = listaEntidade;
	}
	
	
}
