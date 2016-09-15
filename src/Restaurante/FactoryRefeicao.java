/**
 * @author Antonio Dartagnan S. C. Junior - 114210775 Turma 02
 */
package Restaurante;

import exceptions.StringInvalidaException;

/** 
 *Classe referente ao padrão Factory usado para instânciar uma Refeicao
 *
 */
public class FactoryRefeicao {

	public Refeicao criaRefeicao(String nome, String descricao) throws StringInvalidaException {

		if (nome == null || nome.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio");
		}
		if (descricao == null || descricao.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Descricao nao pode ser nula ou vazia");
		}
		
		return new Refeicao(nome, descricao);
	}
}
