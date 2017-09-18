package br.com.fatec.strategy;

import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.model.Fornecedor;

public class ValidaCampos implements IStrategy {

	private Fornecedor fornecedor;
	
	public boolean processar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		fornecedor = (Fornecedor) entidadeDominio;
		if(fornecedor.getCategoria().getNome().toLowerCase().equals("Importado".toLowerCase()))
			return (validaImportacao(entidadeDominio) && validaDemaisCampos(entidadeDominio));
		else
			return (validaNaoImportado(entidadeDominio) && validaDemaisCampos(entidadeDominio));
	}
	
	public boolean validaImportacao(EntidadeDominio entidadeDominio)
	{
		if(fornecedor.getCI().isEmpty())
			return false;
		else if(!fornecedor.getCnpj().isEmpty() || !fornecedor.getIE().isEmpty())
			return false;
		else
			return true;
	}
	
	public boolean validaNaoImportado(EntidadeDominio entidadeDominio)
	{
		if(!fornecedor.getCI().isEmpty())
			return false;
		else if(fornecedor.getCnpj().isEmpty() || fornecedor.getIE().isEmpty())
			return false;
		else
			return true;
	}
	
	public boolean validaDemaisCampos(EntidadeDominio entidadeDominio)
	{
		if(fornecedor.getNome().isEmpty())
			return false;
		if(fornecedor.getEndereco().getRua().isEmpty())
			return false;
		if(fornecedor.getEndereco().getNumero().isEmpty())
			return false;
		if(fornecedor.getEndereco().getCidade().getNome().isEmpty())
			return false;
		if(fornecedor.getEndereco().getCidade().getEstado().getNome().isEmpty())
			return false;
		if(fornecedor.getEndereco().getCEP().isEmpty())
			return false; 
		if(fornecedor.getEndereco().getCidade().getEstado().getPais().getNome().isEmpty())
			return false;		
		return true;
	}
}
