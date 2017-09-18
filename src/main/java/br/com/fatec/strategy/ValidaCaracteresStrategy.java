package br.com.fatec.strategy;

import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.model.Fornecedor;

public class ValidaCaracteresStrategy implements IStrategy {

	public boolean processar(EntidadeDominio entidadeDominio) 
	{
		Fornecedor fornecedor = (Fornecedor) entidadeDominio;
		if(fornecedor.getEndereco().getObs().length() <= 1000)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}