
package factorys;

import exceptions.StringInvalidaException;

import java.util.ArrayList;

import Restaurante.Prato;
import Restaurante.Refeicao;

/** 
 *Classe referente ao padr�o Factory usado para inst�nciar uma Refeicao
 *
 */
public enum RefeicaoFactory {
	INSTANCIA;

	public Refeicao create(String nome, String descricao, ArrayList<Prato> pratos) throws StringInvalidaException {

		if (nome == null || nome.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Erro no cadastro de refeicao. Nome da refeicao esta vazio.");
		}
		if (descricao == null || descricao.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Erro no cadastro de refeicao. Descricao da refeicao esta vazia.");
		}
		
		return new Refeicao(nome, descricao, pratos);
	}
}
