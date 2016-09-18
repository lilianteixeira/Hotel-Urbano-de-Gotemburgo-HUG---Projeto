package cadastro;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CadastroSet {
	private Set<Cadastro> cadastroSet;

	public CadastroSet() {
		cadastroSet = new HashSet<>();
	}

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

	public boolean removeCadastro(Cadastro c) {
		cadastroSet.remove(c);
		return true;
	}

	public Cadastro buscaCadastro(String email) {
		// Primeiro deve ser feita a validação do argumento
		Cadastro c = null;
		Iterator<Cadastro> i = cadastroSet.iterator();

		while (i.hasNext()) {
			c = i.next();
			if (c.getEmail().equals(email))
				return c;
		}

		return null; // Na verdade, deve lançar uma checked exception, com uma
						// mensagem avisando
		// que não há nenhum cadastro com esse email.
	}
}