package br.com.fatec.strategy;

import java.util.Calendar;

import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.model.Fornecedor;
import br.com.fatec.util.Resultado;

public class ValidaDataStrategy implements IStrategy {

	public boolean processar(EntidadeDominio entidadeDominio) {
	   Resultado resultado = new Resultado();
	   Fornecedor fornecedor = (Fornecedor) entidadeDominio;
	   Calendar data = fornecedor.getDataFundacao();
	   Calendar cal = Calendar.getInstance();
       int anoAtual = cal.get(Calendar.YEAR);
       int dataCadastrada = data.get(Calendar.YEAR);
       if((anoAtual - dataCadastrada) > 1)
    	   return true;
       else if((anoAtual - dataCadastrada) == 1)
       {
    	   int mesAtual = cal.get(Calendar.MONTH);
    	   int mesCadastrado = data.get(Calendar.MONTH);
    	   int aux = 12 - mesCadastrado;
    	   if(mesAtual + aux > 12)
    		   return true;
       }
       return false;
	}

}
