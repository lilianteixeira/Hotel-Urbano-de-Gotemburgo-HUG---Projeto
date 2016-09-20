package cadastro;

import java.util.HashSet;
import java.util.Set;

import exceptions.ObjetoInvalidoException;
import exceptions.StringInvalidaException;

/**
 * Essa classe encapsula uma coleção de instâncias de <code>Cadastro</code>, e
 * fornece métodos para a visualização de cada Cadastro, como a edição deles.
 * <p>
 * 
 * @see Cadastro
 *
 */
public class CadastroSet {
	private Set<Cadastro> cadastroSet;

	/**
	 * Construtor de CadastroSet.
	 */
	public CadastroSet() {
		cadastroSet = new HashSet<>();
	}

	/**
	 * adiciona um <code>Cadastro c</code> à essa coleção, se ele já não estiver
	 * presente, e se ele não for <code>null</code>. De maneira mais formal,
	 * adiciona o elemento especificado <code>c</code> à essa coleção, se essa
	 * coleção não contiver <code>c2</code>, tal que <code>c.equals(c2)</code>.
	 * <p>
	 * Essa coleção não aceita objetos do tipo null, e irá lançar um
	 * <code>NullPointerException</code>, se for passado um objeto com
	 * referência <code>null</code> como argumento desse método.
	 * 
	 * @param c
	 *            elemento a ser adicionado nessa coleção.
	 * @return true se a coleção mudou por conta da chamada desse método.
	 * @throws NullPointerException
	 *             se <code>c</code> for <code>null</code>.
	 */
	public boolean addCadastro(Cadastro c) {
		if (c == null)
			throw new NullPointerException("c não pode ser null");
		cadastroSet.add(c);
		return true;
	}

	// conferir se o cadastro existe antes de remover
	/**
	 * Remove uma instância c de <code>Cadastro</code>, desta coleção, se tal coleção a contiver. 
	 * @param c
	 * @return
	 */
	public boolean removeCadastro(Cadastro c) {
		cadastroSet.remove(c);
		return true;
	}

	/**
	 * O metodo buscaCadastro e responsavel por achar um cadastro atraves de um
	 * e-mail .
	 * 
	 * @param email
	 * @return um cadastro se ele for encontrado
	 */
	public Cadastro buscaCadastro(String email) throws ObjetoInvalidoException, StringInvalidaException {
		if (email == null || email.trim().equals(""))
			throw new StringInvalidaException();

		for (Cadastro c : cadastroSet)
			if (c.getEmail().equals(email))
				return c;

		throw new ObjetoInvalidoException(
				"Erro na consulta de hospede. Hospede de email " + email + " nao foi cadastrado(a).");
	}

	public String getInfoCadastro(String email, String atributo) throws Exception {
		validateInfoArgument(email, atributo);

		if (atributo.equalsIgnoreCase("Nome")) {
			return buscaCadastro(email).getNome();
		}
		if (atributo.equalsIgnoreCase("Data de nascimento")) {
			return buscaCadastro(email).getDataDeNascimento();
		}
		if (atributo.equalsIgnoreCase("Email")) {
			return buscaCadastro(email).getEmail();
		}
		throw new Exception(); // Se chegou nesse ponto, é porque o atributo é
								// inválido
	}

	public String setInfoCadastro(String email, String atributo, String valor) throws Exception {
		validateInfoArgument(email, atributo);

		if (atributo.equalsIgnoreCase("Nome")) {
			buscaCadastro(email).setNome(valor);
		}
		if (atributo.equalsIgnoreCase("Data de nascimento")) {
			buscaCadastro(email).setDataDeNascimento(valor);
		}
		if (atributo.equalsIgnoreCase("Email")) {
			buscaCadastro(email).setEmail(valor);
		}
		throw new Exception(); // Se chegou nesse ponto, é porque o atributo é
								// inválido
	}

	private void validateInfoArgument(String email, String atributo) throws Exception {
		if (email == null)
			throw new Exception();
		if (email.trim().equals(""))
			throw new Exception();
		if (atributo == null)
			throw new Exception();
		if (atributo.trim().equals(""))
			throw new Exception();
	}
}