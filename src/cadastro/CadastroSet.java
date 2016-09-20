package cadastro;

import java.util.HashSet;
import java.util.Set;

import exceptions.ObjetoInvalidoException;
import exceptions.StringInvalidaException;

/**
 * 
 *  A classe Cadastro Set é responsável por  ???
 *
 */
public class CadastroSet {
	private Set<Cadastro> cadastroSet;

	/**
	 * 
	 * Construtor da classe Cadastro Set 
	 * 
	 */
	public CadastroSet() {
		cadastroSet = new HashSet<>();
	}

	/**
	 * O metodo addCadastro adiciona um novo cadastro a lista 
	 * 
	 * @param c
	 * @return um boolean se o cadastro foi adicionado a lista 
	 */
	public boolean addCadastro(Cadastro c) {
		// Falta validar o argumento
		//
		// O retorno é um default boolean (true), então não deve ser
		// implementado um
		// caso onde esse método retorne false.
		//
		/*
		 * Eu sei que o cliente quer fazer as operações pelo e-mail, mas é
		 * melhor ter o método na forma mais geral, e na implementação do
		 * controller, disponibilizar o método que busca pelo e-mail, e depois
		 * chama esse método.
		 */
		cadastroSet.add(c);
		return true;
	}

	//conferir se o cadastro existe antes de remover
		/**
		 * O metodo removeCadastro recebe um cadastro e e responsavel por remove-lo da lista 
		 * 
		 * @param c
		 * @return um boolean informando se o cadastro foi removido ou nao 
		 */
	public boolean removeCadastro(Cadastro c) {
		cadastroSet.remove(c);
		return true;
	}

	/**
	 * O metodo buscaCadastro e responsavel por achar um cadastro atraves de um e-mail .
	 * 
	 * @param email
	 * @return um cadastro se ele for encontrado
	 */	
	public Cadastro buscaCadastro(String email) throws ObjetoInvalidoException, StringInvalidaException {
		if (email == null || email.trim().equals(""))
			throw new StringInvalidaException();
		
		for(Cadastro c : cadastroSet)
			if(c.getEmail().equals(email))
				return c;

		throw new ObjetoInvalidoException(
				"Erro na consulta de hospede. Hospede de email " + email + " nao foi cadastrado(a).");
	}
}