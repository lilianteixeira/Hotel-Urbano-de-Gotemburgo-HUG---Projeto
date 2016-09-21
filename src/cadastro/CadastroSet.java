package cadastro;

import java.util.HashSet;
import java.util.Set;

import exceptions.CadastroNotFoundException;

/**
 * Essa classe encapsula uma coleção de instâncias de <code>Cadastro</code>, e
 * fornece métodos para a visualização de cada Cadastro, como a edição deles.
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

	/**
	 * Remove uma instância c de <code>Cadastro</code>, desta coleção, se tal
	 * coleção a contiver.
	 * 
	 * @param c
	 *            <code>Cadastro</code> a ser removido da coleção.
	 * @return true se o elemento for removido como resultado da chamada deste
	 *         método.
	 */
	public boolean removeCadastro(Cadastro c) {
		cadastroSet.remove(c);
		return true;
	}

	/**
	 * Retorna uma instância de <code>Cadastro</code> que tenha o email igual a
	 * <code>String</code> passada como referência.
	 * 
	 * @param email
	 *            email que o <code>Cadastro</code> a ser buscado deve ter.
	 * @return instância de <code>Cadastro</code> que tem um email igual ao
	 *         passado como argumento.
	 * @throws NullPointerException
	 *             se <code>email</code> for null.
	 * @throws CadastroNotFoundException
	 *             se o objeto não for encontrado.
	 */
	public Cadastro buscaCadastro(String email) throws CadastroNotFoundException {
		for (Cadastro c : cadastroSet)
			if (c.getEmail().equals(email))
				return c;
		throw new CadastroNotFoundException();

		/*
		 * throw new ObjetoInvalidoException(
		 * "Erro na consulta de hospede. Hospede de email " + email +
		 * " nao foi cadastrado(a).");
		 */
	}

	// Na documentação, deve deixar específico que o método só aceita um
	// determinado conjunto de atributos, passar uma String atributo, que não é
	// esperada, irá lançar uma exception
	public String getInfoCadastro(String email, String atributo) throws CadastroNotFoundException {
		validateInfoArgument(atributo);

		if (atributo.equalsIgnoreCase("Nome")) {
			return buscaCadastro(email).getNome();
		}
		if (atributo.equalsIgnoreCase("Data de nascimento")) {
			return buscaCadastro(email).getDataDeNascimento();
		}
		if (atributo.equalsIgnoreCase("Email")) {
			return buscaCadastro(email).getEmail();
		}
		throw new IllegalArgumentException("atributo inválido");
	}

	public String setInfoCadastro(String email, String atributo, String valor) throws CadastroNotFoundException {
		validateInfoArgument(atributo);

		if(atributo.equalsIgnoreCase("Nome")) {
			buscaCadastro(email).setNome(valor);
			return email;
		}
		if(atributo.equalsIgnoreCase("Data de nascimento")) {
			buscaCadastro(email).setDataDeNascimento(valor);
			return email;
		}
		if(atributo.equalsIgnoreCase("Email")) {
			buscaCadastro(email).setEmail(valor);
			return email;
		}
		throw new IllegalArgumentException("atributo invalido");
	}

	private void validateInfoArgument(String atributo) {
		if (atributo == null)
			throw new NullPointerException("atributo nao pode ser null");
		if (atributo.trim().equals(""))
			throw new IllegalArgumentException("atributo nao pode ser vazio");
	}
}