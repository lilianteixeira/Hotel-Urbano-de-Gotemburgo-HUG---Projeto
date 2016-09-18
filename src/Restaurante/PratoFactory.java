package Restaurante;

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
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio");
		}
		if (preco < 0) {
			throw new NumeroInvalidoException("Preco nao pode ser negativo");
		}
		if (descricao == null || descricao.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Descricao nao pode ser nula ou vazia");
		}

		Prato prato = new Prato(nome, preco, descricao);
		return prato;
	}
}
