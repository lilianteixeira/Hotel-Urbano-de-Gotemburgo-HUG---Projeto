package factorys;

import Restaurante.Prato;
import exceptions.NumeroInvalidoException;
import exceptions.StringInvalidaException;

/**
 * Classe referente ao padr�o Factory usado para inst�nciar um Prato
 *
 */
public enum PratoFactory {
	INSTANCIA;
	
	public Prato create(String nome, double preco, String descricao)
			throws StringInvalidaException, NumeroInvalidoException {

		if (nome == null || nome.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Erro no cadastro do prato. Nome do prato esta vazio.");
		}
		if (preco < 0) {
			throw new NumeroInvalidoException("Erro no cadastro do prato. Preco do prato eh invalido.");
		}
		if (descricao == null || descricao.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Erro no cadastro do prato. Descricao do prato esta vazia.");
		}

		Prato prato = new Prato(nome, preco, descricao);
		return prato;
	}
}
