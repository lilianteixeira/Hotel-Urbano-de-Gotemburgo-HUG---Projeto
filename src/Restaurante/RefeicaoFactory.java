
package Restaurante;

import exceptions.StringInvalidaException;

import java.util.ArrayList;

/** 
 *Classe referente ao padr�o Factory usado para inst�nciar uma Refeicao
 *
 */
public enum RefeicaoFactory {
	INSTANCIA;

	public Refeicao create(String nome, String descricao, ArrayList<Prato> pratos) throws StringInvalidaException {

		if (nome == null || nome.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio");
		}
		if (descricao == null || descricao.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Descricao nao pode ser nula ou vazia");
		}
		
		return new Refeicao(nome, descricao, pratos);
	}
}
