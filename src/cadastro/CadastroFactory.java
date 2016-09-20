package cadastro;

import exceptions.StringInvalidaException;

/**
 * O enum Cadastro Factory e responsavel pela criacao de um cadastro.
 * 
 */
public enum CadastroFactory {
	INSTANCE;

	/**
	 * O metodo create retorna um novo cadastro
	 * 
	 * @throws StringInvalidaException
	 */
	public Cadastro create(String nome, String email, String dataDeNascimento) throws StringInvalidaException {
		return Cadastro.novoCadastro(nome, email, dataDeNascimento);
	}
}