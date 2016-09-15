/**
 * @author Antonio Dartagnan S. C. Junior - 114210775 Turma 02
 */

package Restaurante;

import exceptions.NumeroInvalidoException;
import exceptions.StringInvalidaException;

/** 
 *Classe referente ao padrão Factory usado para instânciar um Prato
 *
 */
public class FactoryPrato {

	public Prato criaPrato(String nome, double preco, String descricao)
			throws StringInvalidaException, NumeroInvalidoException {

		if (nome == null || nome.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio");
		}
		if (preco < 0) {
			throw new NumeroInvalidoException("Preco nao pode ser negativo");
		}
		if (descricao == null || descricao.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Descricao nao pode ser nula ou vazia");
		}
		
		return new Prato(nome, preco, descricao);
	}
}
